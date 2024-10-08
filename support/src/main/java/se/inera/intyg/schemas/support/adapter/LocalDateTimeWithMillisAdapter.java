/*
 * Copyright (C) 2023 Inera AB (http://www.inera.se)
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
package se.inera.intyg.schemas.support.adapter;

import jakarta.xml.bind.DatatypeConverter;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Adapter for converting XML Schema types to Java dates and vice versa.
 *
 * @author andreaskaltenbach
 */
public final class LocalDateTimeWithMillisAdapter {
    private static final ZoneId TIMEZONE = ZoneId.of("Europe/Stockholm");
    private static final String ISO_DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String XSD_DATE_TIMEZONE_REGEXP = "\\d{4}-\\d{2}-\\d{2}([+-].*|Z)";
    private static final String XSD_DATETIME_TIMEZONE_REGEXP = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.?\\d*([+-].*|Z)";

    private LocalDateTimeWithMillisAdapter() {
    }

    /**
     * Converts an xs:datetime to a LocalDateTime.
     */
    public static LocalDateTime parseDateTime(String dateTimeString) {
        // Workaround for the fact that DatatypeConverter doesn't allow setting the default TimeZone,
        // (which means that the system default TimeZone will be used, which might be wrong if hosted in
        // a different TimeZone), and that LocalDateTime doesn't handle datetimes with explicit TimeZone.
        // Hence if the date contains an explicit TimeZone, use DatatypeConverter to do the parsing,
        // otherwise use LocalDateTime's parsing.
        if (dateTimeString.matches(XSD_DATETIME_TIMEZONE_REGEXP) || dateTimeString.matches(XSD_DATE_TIMEZONE_REGEXP)) {
            return LocalDateTime.from(DatatypeConverter.parseDateTime(dateTimeString).toInstant().atZone(TIMEZONE));
        } else {
            return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(ISO_DATETIME_PATTERN));
        }
    }

    /**
     * Print a DateTime (always using ISO format).
     */
    public static String printDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(ISO_DATETIME_PATTERN));
    }

}
