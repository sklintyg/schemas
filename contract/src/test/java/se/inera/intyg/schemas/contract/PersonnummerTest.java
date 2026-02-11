/*
 * Copyright (C) 2019 Inera AB (http://www.inera.se)
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
package se.inera.intyg.schemas.contract;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.inera.intyg.schemas.contract.util.HashUtility;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class PersonnummerTest {

    @BeforeAll
    static void setUp() {
        ClassLoader.getSystemClassLoader().setClassAssertionStatus("se.inera.intyg.schemas.contract.Personnummer", false);
    }

    @AfterAll
    static void tearDown() {
        ClassLoader.getSystemClassLoader().setClassAssertionStatus("se.inera.intyg.schemas.contract.Personnummer", true);
    }

    @Test
    void testInvalidPersonnummer() {
        expectExceptionWhenCreatingValidatedPersonnummer(null);
        expectExceptionWhenCreatingValidatedPersonnummer("");
        expectExceptionWhenCreatingValidatedPersonnummer("21121212-1212");
        expectExceptionWhenCreatingValidatedPersonnummer("121212+112");
        expectExceptionWhenCreatingValidatedPersonnummer("21212-1212");
    }

    @Test
    void testGetPersonnummer() {
        validatePersonnummerWithoutDash("19121212-1212", "191212121212");
        validatePersonnummerWithoutDash("191212121212", "191212121212");
        validatePersonnummerWithoutDash("1212121212", "201212121212");
        validatePersonnummerWithoutDash("20121212-1212", "201212121212");
        validatePersonnummerWithoutDash("201212121212", "201212121212");
        validatePersonnummerWithoutDash("121212+1212", "191212121212");
        validatePersonnummerWithoutDash("600101+1111", "186001011111");
    }

    @Test
    void testGetPersonnummerWithDash() {
        validatePersonnummerWithDash("19121212-1212", "19121212-1212");
        validatePersonnummerWithDash("191212121212", "19121212-1212");
        validatePersonnummerWithDash("1212121212", "20121212-1212");
        validatePersonnummerWithDash("20121212-1212", "20121212-1212");
        validatePersonnummerWithDash("201212121212", "20121212-1212");
        validatePersonnummerWithDash("121212+1212", "19121212-1212");
        validatePersonnummerWithDash("600101+1111", "18600101-1111");
    }

    @Test
    void testToStringShouldReturnTheHashedValue() {
        final List<String> pnrs = Arrays.asList("121212-1212", "19121212-1212", "1212121212", "191212121212");
        for (String pnr : pnrs) {
                Personnummer personnummer = createPnr(pnr).orElseThrow();
                assertEquals(personnummer.getPersonnummerHash(), personnummer.toString());
        }
    }

    @Test
    void testGetPnrHash() {
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c",
                createPnr("920926-2386").orElseThrow().getPersonnummerHash());
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c",
                createPnr("199209262386").orElseThrow().getPersonnummerHash());
    }

    @Test
    void testTwoDifferentPnrsNotEquals() {
        //Given
        final Personnummer personnummer0 = createPnr("000000-0000").orElseThrow();
        final Personnummer personnummer9 = createPnr("999999-9999").orElseThrow();

        //Then
        assertNotEquals(personnummer0, personnummer9);
        assertNotEquals(personnummer9, personnummer0);
    }

    @Test
    void testTwoIdenticalPnrsEquals() {
        //Given
        final Personnummer personnummer0 = createPnr("000000-0000").orElseThrow();
        final Personnummer personnummer1 = createPnr("000000-0000").orElseThrow();

        //Then
        assertEquals(personnummer0, personnummer1);
        assertEquals(personnummer1, personnummer0);
    }

    @Test
    void testPnrWithOrWithoutDashEquals() {
        //Given
        final Personnummer personnummer0 = createPnr("920926-2386").orElseThrow();
        final Personnummer personnummer1 = createPnr("9209262386").orElseThrow();

        //Then
        assertEquals(personnummer0, personnummer1);
        assertEquals(personnummer1, personnummer0);
    }

    @Test
    void testHashCode() {
        //Given
        final Personnummer personnummer0 = createPnr("000000-0000").orElseThrow();
        final Personnummer personnummer9 = createPnr("999999-9999").orElseThrow();

        //Then
        assertNotEquals(personnummer0.hashCode() , personnummer9.hashCode());
        assertEquals(personnummer0.hashCode(), personnummer0.hashCode());
    }

    @Test
    void testGetPnrHashSafe() {
        assertEquals(HashUtility.EMPTY, Personnummer.getPersonnummerHashSafe(null));

        final Personnummer personnummer = createPnr("920926-2386").orElseThrow();
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c", Personnummer.getPersonnummerHashSafe(personnummer));
        assertEquals(personnummer.getPersonnummerHash(), Personnummer.getPersonnummerHashSafe(personnummer));
    }

    @Test
    void testSerializePersonnummer() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final Personnummer value = createPnr("199209262386").orElseThrow();

        //When
        final String json = objectMapper.writeValueAsString(value);

        //Then
        assertEquals("\"199209262386\"", json);
    }

    @Test
    void testDeserializePersonnummer() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();

        //When
        final Personnummer personnummer = objectMapper.readValue("\"199209262386\"", Personnummer.class);

        //Then
        assertEquals("199209262386", personnummer.getPersonnummer());
    }

    @Test
    void testVerifyControlDigit10Digits() {
        Personnummer pnr = createPnr("1212121212").orElseThrow();
        assertTrue(pnr.verifyControlDigit());
    }

    @Test
    void testVerifyControlDigit12Digits() {
        Personnummer pnr = createPnr("191212121212").orElseThrow();
        assertTrue(pnr.verifyControlDigit());
    }
    @Test
    void testCalculateControlDigit10Digits() {
        Personnummer pnr = createPnr("1212121212").orElseThrow();
        assertEquals(2, pnr.calculateControlDigit());
    }

    @Test
    void testCalculateControlDigit12Digits() {
        Personnummer pnr = createPnr("191212121212").orElseThrow();
        assertEquals(2, pnr.calculateControlDigit());
    }

    @Test
    void testCalculateControlDigit12DigitsWithLargeDigits() {
        Personnummer pnr = createPnr("19990104-2383").orElseThrow();
        assertEquals(3, pnr.calculateControlDigit());
    }

    private void validatePersonnummerWithoutDash(String input, String expected) {
        Optional<Personnummer> pnr = createPnr(input);
        assertEquals(expected, pnr.orElseThrow().getPersonnummer());
    }

    private void validatePersonnummerWithDash(String input, String expected) {
        Optional<Personnummer> pnr = createPnr(input);
        assertEquals(expected, pnr.orElseThrow().getPersonnummerWithDash());
    }

    private void expectExceptionWhenCreatingValidatedPersonnummer(String input) {
        assertFalse(createPnr(input).isPresent(), String.format("The personnummer %s in test should have failed, i.e should have returned an empty Optional", input));
    }

    private Optional<Personnummer> createPnr(String input) {
        return Personnummer.createPersonnummer(input);
    }
}
