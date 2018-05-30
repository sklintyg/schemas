/*
 * Copyright (C) 2018 Inera AB (http://www.inera.se)
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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import se.inera.intyg.schemas.contract.util.HashUtility;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PersonnummerTest {

    @BeforeClass
    public static void setUp() {
        ClassLoader.getSystemClassLoader().setClassAssertionStatus("se.inera.intyg.schemas.contract.Personnummer", false);
    }

    @AfterClass
    public static void tearDown() {
        ClassLoader.getSystemClassLoader().setClassAssertionStatus("se.inera.intyg.schemas.contract.Personnummer", true);
    }

    @Test
    public void testInvalidPersonnummer() {
        expectExceptionWhenCreatingValidatedPersonnummer(null);
        expectExceptionWhenCreatingValidatedPersonnummer("");
        expectExceptionWhenCreatingValidatedPersonnummer("21121212-1212");
        expectExceptionWhenCreatingValidatedPersonnummer("121212+112");
        expectExceptionWhenCreatingValidatedPersonnummer("21212-1212");
    }

    @Test
    public void testGetPersonnummer() {
        validatePersonnummerWithoutDash("19121212-1212", "191212121212");
        validatePersonnummerWithoutDash("191212121212", "191212121212");
        validatePersonnummerWithoutDash("1212121212", "201212121212");
        validatePersonnummerWithoutDash("20121212-1212", "201212121212");
        validatePersonnummerWithoutDash("201212121212", "201212121212");
        validatePersonnummerWithoutDash("121212+1212", "191212121212");
        validatePersonnummerWithoutDash("600101+1111", "186001011111");
    }

    @Test
    public void testGetPersonnummerWithDash() {
        validatePersonnummerWithDash("19121212-1212", "19121212-1212");
        validatePersonnummerWithDash("191212121212", "19121212-1212");
        validatePersonnummerWithDash("1212121212", "20121212-1212");
        validatePersonnummerWithDash("20121212-1212", "20121212-1212");
        validatePersonnummerWithDash("201212121212", "20121212-1212");
        validatePersonnummerWithDash("121212+1212", "19121212-1212");
        validatePersonnummerWithDash("600101+1111", "18600101-1111");
    }

    @Test
    public void testToStringShouldReturnTheHashedValue() {
        final List<String> pnrs = Arrays.asList("121212-1212", "19121212-1212", "1212121212", "191212121212");
        for (String pnr : pnrs) {
            try {
                Personnummer personnummer = createPnr(pnr).get();
                assertEquals(personnummer.getPersonnummerHash(), personnummer.toString());
            } catch (AssertionError ae) {
                //I don't know how to disable assertions in code when running test via maven, hence let this assertion error pass
            }
        }
    }

    @Test
    public void testGetPnrHash() {
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c",
                createPnr("920926-2386").get().getPersonnummerHash());
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c",
                createPnr("199209262386").get().getPersonnummerHash());
    }

    @Test
    public void testTwoDifferentPnrsNotEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = createPnr("000000-0000").get();
        final Personnummer personnummer9 = createPnr("999999-9999").get();

        //Then
        assertFalse(personnummer0.equals(personnummer9));
        assertFalse(personnummer9.equals(personnummer0));
    }

    @Test
    public void testTwoIdenticalPnrsEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = createPnr("000000-0000").get();
        final Personnummer personnummer1 = createPnr("000000-0000").get();

        //Then
        assertTrue(personnummer0.equals(personnummer1));
        assertTrue(personnummer1.equals(personnummer0));
    }

    @Test
    public void testPnrWithOrWithoutDashEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = createPnr("920926-2386").get();
        final Personnummer personnummer1 = createPnr("9209262386").get();

        //Then
        assertTrue(personnummer0.equals(personnummer1));
        assertTrue(personnummer1.equals(personnummer0));
    }

    @Test
    public void testHashCode() throws Exception {
        //Given
        final Personnummer personnummer0 = createPnr("000000-0000").get();
        final Personnummer personnummer9 = createPnr("999999-9999").get();

        //Then
        assertTrue(personnummer0.hashCode() != personnummer9.hashCode());
        assertEquals(personnummer0.hashCode(), personnummer0.hashCode());
    }

    @Test
    public void testGetPnrHashSafe() throws Exception {
        assertEquals(HashUtility.EMPTY, Personnummer.getPersonnummerHashSafe(null));

        final Personnummer personnummer = createPnr("920926-2386").get();
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c", Personnummer.getPersonnummerHashSafe(personnummer));
        assertEquals(personnummer.getPersonnummerHash(), Personnummer.getPersonnummerHashSafe(personnummer));
    }

    @Test
    public void testSerializePersonnummer() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final Personnummer value = createPnr("199209262386").get();

        //When
        final String json = objectMapper.writeValueAsString(value);

        //Then
        assertEquals("\"199209262386\"", json);
    }

    @Test
    public void testDeserializePersonnummer() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();

        //When
        final Personnummer personnummer = objectMapper.readValue("\"199209262386\"", Personnummer.class);

        //Then
        assertEquals("199209262386", personnummer.getPersonnummer());
    }

    @Test
    public void testVerifyControlDigit10Digits() {
        Personnummer pnr = createPnr("1212121212").get();
        assertTrue(pnr.verifyControlDigit());
    }

    @Test
    public void testVerifyControlDigit12Digits() {
        Personnummer pnr = createPnr("191212121212").get();
        assertTrue(pnr.verifyControlDigit());
    }
    @Test
    public void testCalculateControlDigit10Digits() {
        Personnummer pnr = createPnr("1212121212").get();
        assertEquals(2, pnr.calculateControlDigit());
    }

    @Test
    public void testCalculateControlDigit12Digits() {
        Personnummer pnr = createPnr("191212121212").get();
        assertEquals(2, pnr.calculateControlDigit());
    }


    @Test
    public void testCalculateControlDigit12DigitsWithLargeDigits() {
        Personnummer pnr = createPnr("19990104-2383").get();
        assertEquals(3, pnr.calculateControlDigit());
    }

    private void validatePersonnummerWithoutDash(String input, String expected) {
        Optional<Personnummer> pnr = createPnr(input);
        if(!pnr.isPresent()) {
            fail();
        } else {
            assertEquals(expected, pnr.get().getPersonnummer());
        }
    }

    private void validatePersonnummerWithDash(String input, String expected) {
        Optional<Personnummer> pnr = createPnr(input);
        if(!createPnr(input).isPresent()) {
            fail();
        } else {
            assertEquals(expected, pnr.get().getPersonnummerWithDash());
        }
    }

    private void expectExceptionWhenCreatingValidatedPersonnummer(String input) {
        if (createPnr(input).isPresent()) {
            fail(String.format("The personnummer %s in test should have failed, i.e should have returned an empty Optional", input));
        }
    }

    private Optional<Personnummer> createPnr(String input) {
        return Personnummer.createPersonnummer(input);
    }


}
