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
package se.inera.intyg.schematron.tstrk1031.v3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.helger.commons.debug.GlobalDebug;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import se.inera.intyg.schematron.validation.ValidateXmlResponse;
import se.inera.intyg.schematron.validation.XmlValidator;

public class SchematronValidatorTest {

    private static final XmlValidator xmlValidator = new XmlValidator("tstrk1031.v3.sch");

    static {
        // avoid com.helger debug log
        GlobalDebug.setDebugModeDirect(false);
    }

    @Test
    public void validMinimalXmlPassesTest() throws Exception {
        String inputXml = getResourceFileAsString("tstrk1031/v3/pass-minimal.xml");
        ValidateXmlResponse response = xmlValidator.validate(inputXml);
        assertTrue(response.getValidationErrors().stream().collect(Collectors.joining("\n")), response.getValidationErrors().isEmpty());
    }

    @Test
    public void validCompleteXmlPassesTest() throws Exception {
        String inputXml = getResourceFileAsString("tstrk1031/v3/pass-complete.xml");
        ValidateXmlResponse response = xmlValidator.validate(inputXml);
        assertTrue(response.getValidationErrors().stream().collect(Collectors.joining("\n")), response.getValidationErrors().isEmpty());
    }

    @Test
    public void failOnRule1() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R1.xml", 1);
    }

    @Test
    public void failOnRule2() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R2_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R2_2.xml", 1);
    }

    @Test
    public void failOnRule3() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R3.xml", 1);
    }

    @Test
    public void failOnRule4() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R4.xml", 1);
    }

    @Test
    public void failOnRule5() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R5.xml", 1);
    }

    @Test
    public void failOnRule6() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R6_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R6_2.xml", 1);
    }

    @Test
    public void failOnRule7() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R7_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R7_2.xml", 1);
    }

    @Test
    public void failOnRule8() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R8.xml", 1);
    }

    @Test
    public void failOnRule9() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R9.xml", 1);
    }

    @Test
    public void failOnRule10() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R10.xml", 1);
    }

    @Test
    public void failOnRule12() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R12.xml", 1);
    }

    @Test
    public void failOnRule13() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R13.xml", 1);
    }

    @Test
    public void failOnRule14() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R14.xml", 1);
    }

    @Test
    public void failOnRule15() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R15_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R15_2.xml", 1);
    }

    @Test
    public void failOnRule16() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R16_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R16_2.xml", 1);
    }

    @Test
    public void failOnRule17() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R17.xml", 1);
    }

    @Test
    public void failOnRule18() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R18.xml", 1);
    }

    @Test
    public void failOnRule19() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R19.xml", 6);
    }

    @Test
    public void failOnRule20() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R20_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R20_2.xml", 1);
    }

    @Test
    public void failOnRule21() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R21_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R21_2.xml", 1);
    }

    @Test
    public void failOnRule22() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R22_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R22_2.xml", 1);
    }

    @Test
    public void failOnRule23Rule24() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R23-R24.xml", 1);
    }

    @Test
    public void failOnRule25() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R25.xml", 1);
    }

    @Test
    public void failOnRule26() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R26_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R26_2.xml", 1);
    }

    private void expectValidationErrors(String xmlFile, int expectedNoOfError) throws Exception {
        String inputXml = getResourceFileAsString(xmlFile);
        ValidateXmlResponse response = xmlValidator.validate(inputXml);
        final List<String> validationErrors = response.getValidationErrors();

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
