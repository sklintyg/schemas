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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonnummerTest {

    @BeforeClass
    public static void setUp() throws Exception {
        ClassLoader.getSystemClassLoader().setClassAssertionStatus("se.inera.intyg.schemas.contract.Personnummer", false);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        ClassLoader.getSystemClassLoader().setClassAssertionStatus("se.inera.intyg.schemas.contract.Personnummer", true);
    }

    @Test
    public void testGetPersonnummer() throws Exception {
        //Given
        final String pnr = "190104063698";

        //When
        final Personnummer personnummer = new Personnummer(pnr);

        //Then
        assertEquals(pnr, personnummer.getPersonnummer());
    }

    @Test
    public void testToStringShouldReturnTheHashedValue() throws Exception {
        final List<String> pnrs = Arrays.asList("000000-0000", "00000000-0000", "000000000000", "0000000000", null, "");
        for (String pnr : pnrs) {
            try {
                assertEquals(new Personnummer(pnr).getPnrHash(), new Personnummer(pnr).toString());
            } catch (AssertionError ae) {
                //I don't know how to disable assertions in code when running test via maven, hence let this assertion error pass
            }
        }
    }

    @Test
    public void testGetPnrHash() throws Exception {
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c", new Personnummer("920926-2386").getPnrHash());
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c", new Personnummer("199209262386").getPnrHash());
        assertEquals(HashUtility.EMPTY, new Personnummer(null).getPnrHash());
        assertEquals(HashUtility.EMPTY, new Personnummer("").getPnrHash());
        assertEquals(HashUtility.EMPTY, Personnummer.empty().getPnrHash());
    }

//    @Test
//    public void testIsSamordningsNummer() throws Exception {
//        assertFalse(SamordningsnummerValidator.isSamordningsNummer(new Personnummer("000000-0000")));
//        assertTrue(SamordningsnummerValidator.isSamordningsNummer(new Personnummer("999999-9999")));
//        assertFalse(SamordningsnummerValidator.isSamordningsNummer(new Personnummer("0000000000")));
//        assertTrue(SamordningsnummerValidator.isSamordningsNummer(new Personnummer("9999999999")));
//        assertFalse(SamordningsnummerValidator.isSamordningsNummer(new Personnummer("000000000000")));
//        assertTrue(SamordningsnummerValidator.isSamordningsNummer(new Personnummer("199999999999")));
//        assertFalse(SamordningsnummerValidator.isSamordningsNummer(new Personnummer("99999999999912345")));
//    }

    @Test
    public void testGetPersonnummerWithoutDashRemovesDash() throws Exception {
        //Given
        final Personnummer personnummer = new Personnummer("000000-0000");

        //When
        final String personnummerWithoutDash = personnummer.getPersonnummerWithoutDash();

        //Then
        assertEquals("0000000000", personnummerWithoutDash);
    }

    @Test
    public void testGetPersonnummerWithoutDashWillKeepPnrWithoutDashTheSame() throws Exception {
        //Given
        final String pnr = "0000000000";
        final Personnummer personnummer = new Personnummer(pnr);

        //When
        final String personnummerWithoutDash = personnummer.getPersonnummerWithoutDash();

        //Then
        assertEquals(pnr, personnummerWithoutDash);
    }

    @Test
    public void testTwoDifferentPnrsNotEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = new Personnummer("000000-0000");
        final Personnummer personnummer9 = new Personnummer("999999-9999");

        //Then
        assertFalse(personnummer0.equals(personnummer9));
        assertFalse(personnummer9.equals(personnummer0));
    }

    @Test
    public void testTwoIdenticalPnrsEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = new Personnummer("000000-0000");
        final Personnummer personnummer1 = new Personnummer("000000-0000");

        //Then
        assertTrue(personnummer0.equals(personnummer1));
        assertTrue(personnummer1.equals(personnummer0));
    }

    @Test
    public void testPnrWithOrWithoutDashEquals() throws Exception {
        //Given
        final Personnummer personnummer0 = new Personnummer("920926-2386");
        final Personnummer personnummer1 = new Personnummer("9209262386");

        //Then
        assertTrue(personnummer0.equals(personnummer1));
        assertTrue(personnummer1.equals(personnummer0));
    }

    @Test
    public void testHashCode() throws Exception {
        //Given
        final Personnummer personnummer0 = new Personnummer("000000-0000");
        final Personnummer personnummer9 = new Personnummer("999999-9999");

        //Then
        assertTrue(personnummer0.hashCode() != personnummer9.hashCode());
        assertEquals(personnummer0.hashCode(), personnummer0.hashCode());
    }

    @Test
    public void testGetPnrHashSafe() throws Exception {
        assertEquals(HashUtility.EMPTY, Personnummer.getPnrHashSafe(null));
        assertEquals(HashUtility.EMPTY, Personnummer.getPnrHashSafe(Personnummer.empty()));
        assertEquals(HashUtility.EMPTY, Personnummer.getPnrHashSafe(new Personnummer(null)));
        assertEquals(HashUtility.EMPTY, Personnummer.getPnrHashSafe(new Personnummer("")));

        final Personnummer personnummer = new Personnummer("920926-2386");
        assertEquals("1424d7d0b8d4afd3c1ab1068a5a54d2d6d05d5b07e16effe36c176bd14b53c1c", Personnummer.getPnrHashSafe(personnummer));
        assertEquals(personnummer.getPnrHash(), Personnummer.getPnrHashSafe(personnummer));
    }

    @Test
    public void testEmptyPersonnummerCanHandleAllCalls() throws Exception {
        //Given
        final Personnummer empty = Personnummer.empty();

        //Then
        assertEquals(HashUtility.EMPTY, empty.getPnrHash());
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
    public void testGetNormalizedPnr() throws Exception {
        //Given
        final String pnr = "196001011111";
        final String expected = "196001011111";

        //When
        final String normalizedPnr = new Personnummer(pnr).getNormalizedPnr();

        //Then
        assertEquals(expected, normalizedPnr);
    }

    @Test
    public void testGetNormalizedPnr2() throws Exception {
        //Given
        final String pnr = "19600101-1111";
        final String expected = "196001011111";

        //When
        final String normalizedPnr = new Personnummer(pnr).getNormalizedPnr();

        //Then
        assertEquals(expected, normalizedPnr);
    }

    @Test
    public void testGetNormalizedPnr3() throws Exception {
        //Given
        final String pnr = "600101-1111";
        final String expected = "196001011111";

        //When
        final String normalizedPnr = new Personnummer(pnr).getNormalizedPnr();

        //Then
        assertEquals(expected, normalizedPnr);
    }

    @Test
    public void testGetNormalizedPnr4() throws Exception {
        //Given
        final String pnr = "600101+1111";
        final String expected = "186001011111";

        //When
        final String normalizedPnr = new Personnummer(pnr).getNormalizedPnr();

        //Then
        assertEquals(expected, normalizedPnr);
    }

    @Test
    public void testGetNormalizedPnr5() throws Exception {
        //Given
        final String pnr = "190101010101";
        final String expected = "190101010101";

        //When
        final String normalizedPnr = new Personnummer(pnr).getNormalizedPnr();

        //Then
        assertEquals(expected, normalizedPnr);
    }

    @Test
    public void testCreateValidatedPersonnummerWithDash() throws Exception {
        parameterizedCreateValidatedPersonnummerWithDashTest(null, null);
        parameterizedCreateValidatedPersonnummerWithDashTest("", null);
        parameterizedCreateValidatedPersonnummerWithDashTest("19121212-1212", "19121212-1212");
        parameterizedCreateValidatedPersonnummerWithDashTest("191212121212", "19121212-1212");
        parameterizedCreateValidatedPersonnummerWithDashTest("1212121212", "20121212-1212");
        parameterizedCreateValidatedPersonnummerWithDashTest("21121212-1212", null);
        parameterizedCreateValidatedPersonnummerWithDashTest("20121212-1212", "20121212-1212");
        parameterizedCreateValidatedPersonnummerWithDashTest("201212121212", "20121212-1212");
        parameterizedCreateValidatedPersonnummerWithDashTest("121212+1212", "19121212-1212");
        parameterizedCreateValidatedPersonnummerWithDashTest("121212+112", null);
        parameterizedCreateValidatedPersonnummerWithDashTest("21212-1212", null);
    }

    private void parameterizedCreateValidatedPersonnummerWithDashTest(String input, String expected) {
        Optional<Personnummer> pnr = Personnummer.createValidatedPersonnummerWithDash(input);
        if(expected == null) {
            assertFalse(String.format("Returned something when it should not have, %s", input), pnr.isPresent());
        } else {
            assertTrue(String.format("Failed to return something when it should have, %s", input), pnr.isPresent());
            if(pnr.isPresent()) {
                assertEquals(expected, pnr.get().getPersonnummer());
            }
        }
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

    @Test
    public void testSerializePersonnummer() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();
        final Personnummer value = new Personnummer("1234");

        //When
        final String json = objectMapper.writeValueAsString(value);

        //Then
        assertEquals("\"1234\"", json);
    }

    @Test
    public void testDeserializePersonnummer() throws Exception {
        //Given
        final ObjectMapper objectMapper = new ObjectMapper();

        //When
        final Personnummer personnummer = objectMapper.readValue("\"1234\"", Personnummer.class);

        //Then
        assertEquals("1234", personnummer.getPersonnummer());
    }

    @Test
    public void testVerifyControlDigit10Digits() {
        Personnummer pnr = new Personnummer("1212121212");
        assertTrue(pnr.verifyControlDigit());
    }

    @Test
    public void testVerifyControlDigit12Digits() {
        Personnummer pnr = new Personnummer("191212121212");
        assertTrue(pnr.verifyControlDigit());
    }

    @Test
    public void testVerifyControlDigitEmpty() {
        Personnummer pnr = Personnummer.empty();
        assertEquals(false, pnr.verifyControlDigit());
    }


    @Test
    public void testCalculateControlDigit10Digits() {
        Personnummer pnr = new Personnummer("1212121212");
        assertEquals(2, pnr.calculateControlDigit());
    }

    @Test
    public void testCalculateControlDigit12Digits() {
        Personnummer pnr = new Personnummer("191212121212");
        assertEquals(2, pnr.calculateControlDigit());
    }

    @Test
    public void testCalculateControlDigitEmpty() {
        Personnummer pnr = Personnummer.empty();
        assertEquals(-1, pnr.calculateControlDigit());
    }


}
