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
import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.inera.intyg.schemas.contract.util.HashUtility;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Optional;

@JsonDeserialize(using = PersonnummerDeserializer.class)
public final class Personnummer implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(Personnummer.class);

    private static final int[] CONTROL_DIGIT_WEIGHTS = { 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1 };
    private static final int SHORT_PNR_LEN = 10;
    private static final int LONG_PNR_LEN = 12;

    private static final int CONTROL_DIGIT_SUM_THRESHOLD = 10;

    /*
     * The original personnummer
     */
    private String originalPnr;

    /*
     * The normalized personnummer on the format yyyyMMddxxxx
     */
    private String normalizedPnr;

    private Personnummer() {
    }

    private Personnummer(String originalPnr) throws InvalidPersonNummerException {
        this.originalPnr = originalPnr;
        this.normalizedPnr = normalizePnr();
    }

    /**
     * Returns a Personnummer, iff the String is has a valid format.
     * Valid formats are:
     * <ul>
     *     <li>^(19|20)[0-9]{6}[-+]?[0-9]{4}$</li>
     *     <li>^[0-9]{6}[+-]?[0-9]{4}$</li>
     * </ul>
     *
     * Empty string and null will return an Optional.empty()
     *
     * @return A normalized personnummer on the form (19|20)[0-9]{6}[0-9]{4}
     */
    public static Optional<Personnummer> createPersonnummer(String personnummer) {
        try {
            return Optional.of(new Personnummer(personnummer));
        } catch (InvalidPersonNummerException e) {
            LOG.debug(e.getMessage());
            LOG.info(String.format("Can not create a Personnumer object with '%s'. Returning Optional.empty()", personnummer));
            return Optional.empty();
        }
    }

    /**
     * Returns the personnummer on the format yyyyMMddxxxx.
     *
     * @return A string on the form (19|20)[0-9]{6}-[0-9]{4}
     */
    @JsonValue
    public String getPersonnummer() {
        return normalizedPnr;
    }

    /**
     * Returns a hashed personnummer.
     *
     * @return A string on the form (19|20)[0-9]{6}-[0-9]{4}
     */
    public String getPersonnummerHash() {
        return HashUtility.hash(getNormalizedPnrIfPossible(normalizedPnr));
    }

    public static String getPersonnummerHashSafe(Personnummer personnummer) {
        return personnummer == null ? HashUtility.hash(null) : personnummer.getPersonnummerHash();
    }

    /**
     * Returns a personnummer with a dash.
     *
     * @return Personnummer on form (19|20)[0-9]{6}-[0-9]{4}
     */
    public String getPersonnummerWithDash() {
        // CHECKSTYLE:OFF MagicNumber
        return normalizedPnr.substring(0, 8) + '-' + normalizedPnr.substring(8, 12);
        // CHECKSTYLE:ON MagicNumber
    }

    /**
     * Returns the orignal personnumer, i.e the personnummer provided by the caller.
     *
     * @return a string with the personnummer provided by the caller
     */
    public String getOriginalPnr() {
        return originalPnr;
    }

    /**
     * Returns true if the actual control digit is the one calculated by Personnummer#calculateControlDigit.
     *
     * @return
     *      true or false.
     */
    public boolean verifyControlDigit() {
        String personnummer = getPersonnummer();
        if (personnummer == null || personnummer.length() < SHORT_PNR_LEN) {
            return false;
        }
        int lastDigit = Integer.parseInt(personnummer.substring(personnummer.length() - 1));
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
        String personnummer = getPersonnummer();
        if (personnummer == null) {
            return -1;
        }
        // Remove 19 or 20 (or whatever century...) if necessary.
        if (personnummer.length() == LONG_PNR_LEN) {
            personnummer = personnummer.substring(2);
        }

        String[] parts = personnummer.split("(?!^)");

        int sum = 0;
        for (int n = 0; n < parts.length - 1; n++) {
            sum += sumControlDigit(Integer.parseInt(parts[n]) * CONTROL_DIGIT_WEIGHTS[n]);
        }
        return (SHORT_PNR_LEN - sum % SHORT_PNR_LEN) % SHORT_PNR_LEN;
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
        return Objects.equal(normalizedPnr, that.normalizedPnr);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(normalizedPnr);
    }

    /**
     * Will return the hashed personnummer to make sure the real personnummer is not accidentally logged.
     *
     * @return Hashed personnummer
     */
    @Override
    public String toString() {
        assert false : "Don't use implicit toString. Use explicit getPersonnummerHash or getPersonnummer instead.";
        return getPersonnummerHash();
    }


    // private stuff

    /**
     * Returns the normalized personnummer if it is valid, otherwise returns the originally set personnummer.
     */
    private String getNormalizedPnrIfPossible(String returnValueWhenInvalid) {
        try {
            return normalizePnr();
        } catch (InvalidPersonNummerException e) {
            return returnValueWhenInvalid;
        }
    }

    /**
     * Get the personnummer in a standardized format (yyyyMMddxxxx) regardless of how it was entered.
     */
    private String normalizePnr() throws InvalidPersonNummerException {
        if (originalPnr == null) {
            throw new InvalidPersonNummerException("Can not normalize null");
        }
        if (originalPnr.isEmpty()) {
            throw new InvalidPersonNummerException("Can not normalize empty string");
        }
        if (originalPnr.matches("^(19|20)[0-9]{6}[-+]?[0-9]{4}$")) {
            return originalPnr.replace("-", "").replace("+", "");
        }
        if (originalPnr.matches("^[0-9]{6}[+-]?[0-9]{4}$")) {
            return getCenturyFromYearAndSeparator(originalPnr) + originalPnr.replace("-", "").replace("+", "");
        }
        throw new InvalidPersonNummerException("Personnummer format not handled: " + originalPnr);
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

    /**
     * When calculating control digit with the 2,1,2,1... method, the sum for a digit
     * may be > 9. For example in 1978 the 7 will be multiplied by 2, e.g i == 14. 14 is summed as 1+4.
     * In that case 14/10 == 1 and then 14%10 == 4. Result is 5.
     */
    private int sumControlDigit(int i) {
        if (i < CONTROL_DIGIT_SUM_THRESHOLD) {
            return i;
        } else {
            return i / CONTROL_DIGIT_SUM_THRESHOLD + i % CONTROL_DIGIT_SUM_THRESHOLD;
        }
    }

}
