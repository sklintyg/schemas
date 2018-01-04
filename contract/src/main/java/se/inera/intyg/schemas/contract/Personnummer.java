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

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import se.inera.intyg.schemas.contract.util.HashUtility;

import java.util.Calendar;
import java.util.Optional;

@JsonDeserialize(using = PersonnummerDeserializer.class)
public class Personnummer {

    private final String pnr;

    private static final int[] CONTROL_DIGIT_WEIGHTS = { 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1 };
    private static final int SHORT_PNR_LEN = 10;
    private static final int LONG_PNR_LEN = 12;

    public Personnummer(String pnr) {
        this.pnr = pnr;
    }

    /**
     * Returns a Personnummer with a dash, iff the String is a valid personnummer.
     *
     * @return Validated personnummer on form (19|20)[0-9]{6}-[0-9]{4}
     */
    public static Optional<Personnummer> createValidatedPersonnummerWithDash(String nonValidatedPnr) {
        try {
            String pnrWithoutDash = new Personnummer(nonValidatedPnr).getNormalizedPnr();
            // CHECKSTYLE:OFF MagicNumber
            return Optional.of(new Personnummer(pnrWithoutDash.substring(0, 8) + '-' + pnrWithoutDash.substring(8, 12)));
            // CHECKSTYLE:ON MagicNumber
        } catch (InvalidPersonNummerException e) {
            return Optional.empty();
        }
    }

    public static Optional<Personnummer> createValidatedPersonnummerWithDash(Personnummer nonValidatedPnr) {
        return createValidatedPersonnummerWithDash(nonValidatedPnr.getPersonnummer());
    }

    @JsonValue
    public String getPersonnummer() {
        return pnr;
    }

    /**
     * Will return the hashed personnummer to make sure the real personnummer is not accidentally logged.
     *
     * @return Hashed personnummer
     */
    @Override
    public String toString() {
        assert false : "Don't use implicit toString. Use explicit getPnrHash or getPersonnummer instead.";
        return getPnrHash();
    }

    public String getPnrHash() {
        return HashUtility.hash(getNormalizedPnrIfPossible(pnr));
    }

    /**
     * Returns the normalized personnummer if it is valid, otherwise returns the originally set personnummer.
     */
    private String getNormalizedPnrIfPossible(String returnValueWhenInvalid) {
        try {
            return getNormalizedPnr();
        } catch (InvalidPersonNummerException e) {
            return returnValueWhenInvalid;
        }
    }

    /**
     * Get the personnummer in a standardized format (yyyyMMddxxxx) regardless of how it was entered.
     */
    public String getNormalizedPnr() throws InvalidPersonNummerException {
        if (pnr == null) {
            throw new InvalidPersonNummerException("Can not normalize null");
        }
        if (pnr.matches("^(19|20)[0-9]{6}[-+]?[0-9]{4}$")) {
            return pnr.replace("-", "").replace("+", "");
        }
        if (pnr.matches("^[0-9]{6}[+-]?[0-9]{4}$")) {
            return getCenturyFromYearAndSeparator(pnr) + pnr.replace("-", "").replace("+", "");
        }
        throw new InvalidPersonNummerException("Personnummer format not handled: " + pnr);
    }

    private String getCenturyFromYearAndSeparator(String personnummer) {
        final Calendar now = Calendar.getInstance();
        final int currentYear = now.getWeekYear();
        final boolean personnummerContainsCentury = personnummer.matches("[0-9]{8}[-+]?[0-9]{4}");
        final int yearStartIndex = personnummerContainsCentury ? 2 : 0;
        final int yearFromPersonnummer = Integer.parseInt(personnummer.substring(yearStartIndex, yearStartIndex + 2));
        final int dividerToRemoveNonCenturyYear = 100;
        final int century = (currentYear - yearFromPersonnummer) / dividerToRemoveNonCenturyYear;
        if (personnummer.contains("+")) {
            return String.valueOf(century - 1);
        }
        return String.valueOf(century);
    }

    public String getPersonnummerWithoutDash() {
        if (pnr == null) {
            return null;
        }
        return pnr.replace("-", "");
    }

    /**
     * Returns true if the actual control digit is the one calculated by Personnummer#calculateControlDigit.
     *
     * @return
     *      true or false.
     */
    public boolean verifyControlDigit() {
        String withoutDash = getPersonnummerWithoutDash();
        if (withoutDash == null || withoutDash.length() < SHORT_PNR_LEN) {
            return false;
        }
        int lastDigit = Integer.parseInt(withoutDash.substring(withoutDash.length() - 1));
        return lastDigit == calculateControlDigit();
    }

    /**
     * If we need to check the syntactic validity of a personnummer, this function can be used to calculate the
     * "control digit" of a swedish personnummer.
     *
     * @return
     *         The expected control digit. If the personnummer was syntactically invalid, -1 will be returned.
     */
    public int calculateControlDigit() {
        String noDash = getPersonnummerWithoutDash();
        if (noDash == null) {
            return -1;
        }
        // Remove 19 or 20 (or whatever century...) if necessary.
        if (noDash.length() == LONG_PNR_LEN) {
            noDash = noDash.substring(2);
        }

        String[] parts = noDash.split("(?!^)");

        int sum = 0;
        for (int n = 0; n < parts.length - 1; n++) {
            sum += sumControlDigit(Integer.parseInt(parts[n]) * CONTROL_DIGIT_WEIGHTS[n]);
        }
        return (SHORT_PNR_LEN - sum % SHORT_PNR_LEN) % SHORT_PNR_LEN;
    }

    private int sumControlDigit(int i) {
        if (i < SHORT_PNR_LEN) {
            return i;
        } else {
            return i / SHORT_PNR_LEN + i % SHORT_PNR_LEN;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Personnummer that = (Personnummer) o;
        return Objects.equal(getNormalizedPnrIfPossible(pnr), that.getNormalizedPnrIfPossible(that.pnr));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNormalizedPnrIfPossible(pnr));
    }

    public static String getPnrHashSafe(Personnummer personnummer) {
        return personnummer == null ? HashUtility.hash(null) : personnummer.getPnrHash();
    }

    public static Personnummer empty() {
        return new Personnummer(null);
    }

}
