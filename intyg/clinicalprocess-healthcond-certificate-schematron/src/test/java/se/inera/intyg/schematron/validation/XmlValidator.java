/*
 * Copyright (C) 2020 Inera AB (http://www.inera.se)
 *
 * This file is part of sklintyg (https://github.com/sklintyg).
 *
 * sklintyg is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * sklintyg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.inera.intyg.schematron.validation;

import com.helger.schematron.svrl.SVRLHelper;
import com.helger.schematron.svrl.jaxb.SchematronOutputType;
import com.helger.schematron.xslt.SchematronResourceSCH;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public final class XmlValidator {

    private SchematronResourceSCH schematronResource;

    public XmlValidator(String location) {
        //AbstractSchematronXSLTBasedResource
        schematronResource = SchematronResourceSCH.fromClassPath(location);
        if (!schematronResource.isValidSchematron()) {
            throw new IllegalArgumentException("Invalid Schematron!");
        }
    }


    public ValidateXmlResponse validate(String inputXml) throws Exception {
        SchematronOutputType valResult = validateSchematron(new StreamSource(new StringReader(inputXml)));
        if (!SVRLHelper.getAllFailedAssertions(valResult).isEmpty()) {
            List<String> errorMsgs = new ArrayList<>();
            SVRLHelper.getAllFailedAssertions(valResult)
                .forEach(fra -> errorMsgs.add(String.format("TEST: %s, MSG: %s", fra.getTest(), fra.getText())));
            return new ValidateXmlResponse(ValidationStatus.INVALID, errorMsgs);
        } else {
            return new ValidateXmlResponse(ValidationStatus.VALID, new ArrayList<>());
        }
    }

    private SchematronOutputType validateSchematron(Source xmlContent) throws Exception {
        return schematronResource.applySchematronValidationToSVRL(xmlContent);

    }
}
