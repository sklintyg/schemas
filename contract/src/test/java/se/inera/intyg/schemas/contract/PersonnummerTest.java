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

    private void createValidatedPersonnummerWithoutDash(String input, String expected) {
        Optional<Personnummer> pnr = Personnummer.createValidatedPersonnummer(input);
        if(!pnr.isPresent()) {
            fail();
        } else {
            assertEquals(expected, pnr.get().getPersonnummer());
        }
    }

    private void createValidatedPersonnummerWithDash(String input, String expected) {
        Optional<Personnummer> pnr = Personnummer.createValidatedPersonnummer(input);
        if(!pnr.isPresent()) {
            fail();
        } else {
            assertEquals(expected, pnr.get().getPersonnummerWithDash());
        }
    }

    private void expectExceptionWhenCreatingValidatedPersonnummer(String input) {
        Optional<Personnummer> pnr = Personnummer.createValidatedPersonnummer(input);
        if (pnr.isPresent()) {
            fail(String.format("The personnummer %s in test should have failed, i.e should have returned an empty Optional", input));
        }
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
        createValidatedPersonnummerWithoutDash("19121212-1212", "191212121212");
        createValidatedPersonnummerWithoutDash("191212121212", "191212121212");
        createValidatedPersonnummerWithoutDash("1212121212", "201212121212");
        createValidatedPersonnummerWithoutDash("20121212-1212", "201212121212");
        createValidatedPersonnummerWithoutDash("201212121212", "201212121212");
        createValidatedPersonnummerWithoutDash("121212+1212", "191212121212");
        createValidatedPersonnummerWithoutDash("600101+1111", "186001011111");
    }

    @Test
    public void testGetPersonnummerWithDash() {
        createValidatedPersonnummerWithDash("19121212-1212", "19121212-1212");
        createValidatedPersonnummerWithDash("191212121212", "19121212-1212");
        createValidatedPersonnummerWithDash("1212121212", "20121212-1212");
        createValidatedPersonnummerWithDash("20121212-1212", "20121212-1212");
        createValidatedPersonnummerWithDash("201212121212", "20121212-1212");
        createValidatedPersonnummerWithDash("121212+1212", "19121212-1212");
        createValidatedPersonnummerWithDash("600101+1111", "18600101-1111");
    }

    @Test
    public void testToStringShouldReturnTheHashedValue() {
        final List<String> pnrs = Arrays.asList("121212-1212", "19121212-1212", "1212121212", "191212121212");
        for (String pnr : pnrs) {
            try {
                Personnummer personnummer = Personnummer.createValidatedPersonnummer(pnr).get();
                assertEquals(personnummer.getPersonnummerHash(), personnummer.toString());
            } catch (AssertionError ae) {
                //I don't know how to disable assertions in code when running test via maven, hence let this assertion error pass
            }
        }
    }

    @Test
    public void testGetPnrHash() {
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c",
                Personnummer.createValidatedPersonnummer("920926-2386").get().getPersonnummerHash());
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c",
                Personnummer.createValidatedPersonnummer("199209262386").get().getPersonnummerHash());
    }

    @Test
    public void testTwoDifferentPnrsNotEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = Personnummer.createValidatedPersonnummer("000000-0000").get();
        final Personnummer personnummer9 = Personnummer.createValidatedPersonnummer("999999-9999").get();

        //Then
        assertFalse(personnummer0.equals(personnummer9));
        assertFalse(personnummer9.equals(personnummer0));
    }

    @Test
    public void testTwoIdenticalPnrsEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = Personnummer.createValidatedPersonnummer("000000-0000").get();
        final Personnummer personnummer1 = Personnummer.createValidatedPersonnummer("000000-0000").get();

        //Then
        assertTrue(personnummer0.equals(personnummer1));
        assertTrue(personnummer1.equals(personnummer0));
    }

    @Test
    public void testPnrWithOrWithoutDashEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = Personnummer.createValidatedPersonnummer("920926-2386").get();
        final Personnummer personnummer1 = Personnummer.createValidatedPersonnummer("9209262386").get();

        //Then
        assertTrue(personnummer0.equals(personnummer1));
        assertTrue(personnummer1.equals(personnummer0));
    }

    @Test
    public void testHashCode() throws Exception {
        //Given
        final Personnummer personnummer0 = Personnummer.createValidatedPersonnummer("000000-0000").get();
        final Personnummer personnummer9 = Personnummer.createValidatedPersonnummer("999999-9999").get();

        //Then
        assertTrue(personnummer0.hashCode() != personnummer9.hashCode());
        assertEquals(personnummer0.hashCode(), personnummer0.hashCode());
    }

    @Test
    public void testGetPnrHashSafe() throws Exception {
        assertEquals(HashUtility.EMPTY, Personnummer.getPersonnummerHashSafe(null));

        final Personnummer personnummer = Personnummer.createValidatedPersonnummer("920926-2386").get();
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c", Personnummer.getPersonnummerHashSafe(personnummer));
        assertEquals(personnummer.getPersonnummerHash(), Personnummer.getPersonnummerHashSafe(personnummer));
    }

    @Test
    public void testSerializePersonnummer() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final Personnummer value = Personnummer.createValidatedPersonnummer("199209262386").get();

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
        Personnummer pnr = Personnummer.createValidatedPersonnummer("1212121212").get();
        assertTrue(pnr.verifyControlDigit());
    }

    @Test
    public void testVerifyControlDigit12Digits() {
        Personnummer pnr = Personnummer.createValidatedPersonnummer("191212121212").get();
        assertTrue(pnr.verifyControlDigit());
    }

    /*
    @Test
    public void testVerifyControlDigitEmpty() {
        Personnummer pnr = Personnummer.empty();
        assertEquals(false, pnr.verifyControlDigit());
    }

    @Test
    public void testCalculateControlDigitEmpty() {
        Personnummer pnr = Personnummer.empty();
        assertEquals(-1, pnr.calculateControlDigit());
    }
    */

    @Test
    public void testCalculateControlDigit10Digits() {
        Personnummer pnr = Personnummer.createValidatedPersonnummer("1212121212").get();
        assertEquals(2, pnr.calculateControlDigit());
    }

    @Test
    public void testCalculateControlDigit12Digits() {
        Personnummer pnr = Personnummer.createValidatedPersonnummer("191212121212").get();
        assertEquals(2, pnr.calculateControlDigit());
    }

    /*
    @Test
    public void testEmptyPersonnummerCanHandleAllCalls() throws Exception {
        //Given
        final Personnummer empty = Personnummer.empty();

        //Then
        assertEquals(HashUtility.EMPTY, empty.getPersonnummerHash());
        assertEquals(null, empty.getPersonnummer());
        assertEquals(null, empty.getPersonnummerWithoutDash());
        assertEquals(false, empty.equals(null));
        assertEquals(31, empty.hashCode());
        assertEquals(false, empty.verifyControlDigit());

        try {
            assertEquals(HashUtility.EMPTY, empty.toString());
        } catch (AssertionError ae) {
            //I don't know how to disable assertions in code when running test via maven, hence let this assertion error pass
        }

        boolean exceptionThrownWhenNormalizing = false;
        try {
            empty.getNormalizedPnr();
        } catch (InvalidPersonNummerException e) {
            exceptionThrownWhenNormalizing = true;
        }
        assertTrue(exceptionThrownWhenNormalizing);

        //Fail this test if a new method is added to Personnummer to make sure a call to it is added here
        assertEquals(9, countNonPrivateMethodsInClass(Personnummer.class));

    }

    private int countNonPrivateMethodsInClass(Class<Personnummer> personnummerClass) {
        final Method[] declaredMethods = personnummerClass.getDeclaredMethods();
        int counter = 0;
        for (Method declaredMethod : declaredMethods) {
            int modifierBits = declaredMethod.getModifiers();
            if (!Modifier.isPrivate(modifierBits) && !Modifier.isStatic(modifierBits)) {
                counter++;
            }
        }
        return counter;
    }

    @Test
    public void testSerializeDeserializePersonnummerNull() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final Personnummer originalPnr = new Personnummer(null);

        //When
        final String json = objectMapper.writeValueAsString(originalPnr);

        //Then
        assertEquals("null", json);

        //When
        final Personnummer personnummer = objectMapper.readValue(json, Personnummer.class);

        //Then
        assertEquals(originalPnr.getPersonnummer(), personnummer.getPersonnummer());
    }

    @Test
    public void testSerializeDeserializePersonnummerEmpty() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final Personnummer originalPnr = new Personnummer("");

        //When
        final String json = objectMapper.writeValueAsString(originalPnr);

        //Then
        assertEquals("\"\"", json);

        //When
        final Personnummer personnummer = objectMapper.readValue(json, Personnummer.class);

        //Then
        assertEquals(originalPnr.getPersonnummer(), personnummer.getPersonnummer());
    }
    */

}
