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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.helger.base.debug.GlobalDebug;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import se.inera.intyg.schematron.validation.ValidateXmlResponse;
import se.inera.intyg.schematron.validation.XmlValidator;

class SchematronValidatorTest {

    private static final XmlValidator xmlValidator = new XmlValidator("tstrk1031.v3.sch");

    static {
        // avoid com.helger debug log
        GlobalDebug.setDebugModeDirect(false);
    }

    @Test
    void validMinimalXmlPassesTest() throws Exception {
        String inputXml = getResourceFileAsString("tstrk1031/v3/pass-minimal.xml");
        ValidateXmlResponse response = xmlValidator.validate(inputXml);
        assertTrue(response.getValidationErrors().isEmpty(), String.join("\n", response.getValidationErrors()));
    }

    @Test
    void validCompleteXmlPassesTest() throws Exception {
        String inputXml = getResourceFileAsString("tstrk1031/v3/pass-complete.xml");
        ValidateXmlResponse response = xmlValidator.validate(inputXml);
        assertTrue(response.getValidationErrors().isEmpty(), String.join("\n", response.getValidationErrors()));
    }

    @Test
    void failOnRule1() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R1.xml", 1);
    }

    @Test
    void failOnRule2() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R2_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R2_2.xml", 1);
    }

    @Test
    void failOnRule3() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R3.xml", 1);
    }

    @Test
    void failOnRule4() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R4.xml", 1);
    }

    @Test
    void passOnRule4() throws Exception {
        expectValid("tstrk1031/v3/pass-R4_1.xml");
        expectValid("tstrk1031/v3/pass-R4_2.xml");
        expectValid("tstrk1031/v3/pass-R4_3.xml");
        expectValid("tstrk1031/v3/pass-R4_5.xml");
    }

    @Test
    void failOnRule5() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R5.xml", 1);
    }

    @Test
    void failOnRule6() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R6_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R6_2.xml", 1);
    }

    @Test
    void failOnRule7() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R7_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R7_2.xml", 1);
    }

    @Test
    void failOnRule8() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R8.xml", 1);
    }

    @Test
    void passOnRule8() throws Exception {
        expectValid("tstrk1031/v3/pass-R8.xml");
    }

    @Test
    void failOnRule9() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R9.xml", 1);
    }

    @Test
    void passOnRule9() throws Exception {
        expectValid("tstrk1031/v3/pass-R9.xml");
    }

    @Test
    void passOnRule13() throws Exception {
        expectValid("tstrk1031/v3/pass-R13.xml");
    }

    @Test
    void passOnRule14() throws Exception {
        expectValid("tstrk1031/v3/pass-R14.xml");
    }

    @Test
    void passOnRule15() throws Exception {
        expectValid("tstrk1031/v3/pass-R15.xml");
    }

    @Test
    void failOnRule10() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R10.xml", 1);
    }

    @Test
    void passOnRule10() throws Exception {
        expectValid("tstrk1031/v3/pass-R10.xml");
    }

    @Test
    void failOnRule12() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R12.xml", 1);
    }

    @Test
    void failOnRule13() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R13.xml", 1);
    }

    @Test
    void failOnRule14() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R14.xml", 1);
    }

    @Test
    void failOnRule15() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R15_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R15_2.xml", 1);
    }

    @Test
    void failOnRule16() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R16_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R16_2.xml", 1);
    }

    @Test
    void failOnRule17() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R17.xml", 1);
    }

    @Test
    void failOnRule18() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R18.xml", 1);
    }

    @Test
    void failOnRule19() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R19.xml", 6);
    }

    @Test
    void failOnRule20() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R20_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R20_2.xml", 1);
    }

    @Test
    void failOnRule21() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R21_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R21_2.xml", 1);
    }

    @Test
    void failOnRule22() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R22_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R22_2.xml", 1);
    }

    @Test
    void failOnRule23Rule24() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R23-R24.xml", 1);
    }

    @Test
    void failOnRule25() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R25.xml", 1);
    }

    @Test
    void failOnRule26() throws Exception {
        expectValidationErrors("tstrk1031/v3/fail-R26_1.xml", 1);
        expectValidationErrors("tstrk1031/v3/fail-R26_2.xml", 1);
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

        assertFalse(validationErrors.isEmpty(), String.join("\n", validationErrors));
        assertEquals(expectedNoOfError, validationErrors.size());
    }

    private String getResourceFileAsString(String href) throws Exception {

        try (InputStream is = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(href)).openStream()) {
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
