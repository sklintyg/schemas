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
package se.inera.intyg.schematron.tstrk1031.v4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.helger.commons.debug.GlobalDebug;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.junit.Test;
import se.inera.intyg.schematron.validation.ValidateXmlResponse;
import se.inera.intyg.schematron.validation.XmlValidator;

public class SchematronValidatorTest {

    private static final XmlValidator xmlValidator = new XmlValidator("tstrk1031.v4.sch");

    static {
        // avoid com.helger debug log
        GlobalDebug.setDebugModeDirect(false);
    }

    @Test
    public void validMinimalXmlPassesTest() throws Exception {
        String inputXml = getResourceFileAsString("tstrk1031/v4/pass-minimal.xml");
        ValidateXmlResponse response = xmlValidator.validate(inputXml);
        assertTrue(response.getValidationErrors().stream().collect(Collectors.joining("\n")), response.getValidationErrors().isEmpty());
    }

    @Test
    public void validCompleteXmlPassesTest() throws Exception {
        String inputXml = getResourceFileAsString("tstrk1031/v4/pass-complete.xml");
        ValidateXmlResponse response = xmlValidator.validate(inputXml);
        assertTrue(response.getValidationErrors().stream().collect(Collectors.joining("\n")), response.getValidationErrors().isEmpty());
    }

    @Test
    public void failOnRule2() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R2_1.xml", 1);
        expectValidationErrors("tstrk1031/v4/fail-R2_2.xml", 1);
    }

    @Test
    public void failOnRule3() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R3.xml", 1);
    }

    @Test
    public void failOnRule4() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R4.xml", 1);
    }

    @Test
    public void passOnRule4() throws Exception {
        expectValid("tstrk1031/v4/pass-R4_1.xml");
        expectValid("tstrk1031/v4/pass-R4_2.xml");
        expectValid("tstrk1031/v4/pass-R4_3.xml");
    }

    @Test
    public void failOnRule8() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R8.xml", 3);
    }

    @Test
    public void passOnRule8() throws Exception {
        expectValid("tstrk1031/v4/pass-R8.xml");
    }

    @Test
    public void failOnRule9() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R9.xml", 1);
    }

    @Test
    public void passOnRule9() throws Exception {
        expectValid("tstrk1031/v4/pass-R9.xml");
    }

    @Test
    public void failOnRule18() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R18.xml", 1);
    }

    @Test
    public void failOnRule19() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R19_1.xml", 1);
        expectValidationErrors("tstrk1031/v4/fail-R19_2.xml", 1);
    }

    @Test
    public void failOnRule20() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R20_1.xml", 1);
        expectValidationErrors("tstrk1031/v4/fail-R20_2.xml", 1);
    }

    @Test
    public void failOnRule21() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R21_1.xml", 1);
        expectValidationErrors("tstrk1031/v4/fail-R21_2.xml", 1);
    }

    @Test
    public void failOnRule22() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R22_1.xml", 1);
        expectValidationErrors("tstrk1031/v4/fail-R22_2.xml", 1);
    }

    @Test
    public void failOnRule23Rule24() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R23-R24.xml", 1);
    }

    @Test
    public void failOnRule27() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R27-1.xml", 1);
        expectValidationErrors("tstrk1031/v4/fail-R27-2.xml", 1);
    }

    @Test
    public void failOnRule28() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R28.xml", 2);
    }

    @Test
    public void failOnRule29() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R29.xml", 1);
    }

    @Test
    public void failOnRule30() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R30.xml", 6);
    }

    @Test
    public void failOnRule32() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R32.xml", 1);
    }

    @Test
    public void failOnRule33() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R33.xml", 1);
    }

    @Test
    public void failOnRule34() throws Exception {
        expectValidationErrors("tstrk1031/v4/fail-R34.xml", 1);
    }

    private void expectValid(String xmlFile) throws Exception {
        var xmlToValidate = getResourceFileAsString(xmlFile);
        var validationResponse = xmlValidator.validate(xmlToValidate);
        var validationErrors = validationResponse.getValidationErrors();

        assertEquals(0, validationErrors.size());
    }

    private void expectValidationErrors(String xmlFile, int expectedNoOfError) throws Exception {
        var xmlToValidate = getResourceFileAsString(xmlFile);
        var validationResponse = xmlValidator.validate(xmlToValidate);
        var validationErrors = validationResponse.getValidationErrors();

        assertFalse(String.join("\n", validationErrors), validationErrors.isEmpty());
        assertEquals(expectedNoOfError, validationErrors.size());
    }

    private String getResourceFileAsString(String href) throws Exception {

        try (InputStream is = Thread.currentThread().getContextClassLoader().getResource(href).openStream()) {
            if (is == null) {
                return null;
            }
            try (InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }
}
