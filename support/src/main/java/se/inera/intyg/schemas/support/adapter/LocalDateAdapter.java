/*
 * Copyright (C) 2016 Inera AB (http://www.inera.se)
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

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Adapter for converting XML Schema types to Java dates and vice versa.
 *
 * @author andreaskaltenbach
 */
public final class LocalDateAdapter {

    private static final ZoneId TIMEZONE = ZoneId.of("Europe/Stockholm");
    private static final String ISO_DATE_PATTERN = "yyyy-MM-dd";
    private static final String ISO_DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final DateTimeFormatter ISO_DATETIME_FORMATTER = new DateTimeFormatterBuilder().appendPattern(ISO_DATETIME_PATTERN)
            .appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).toFormatter();
    private static final String XSD_DATE_TIMEZONE_REGEXP = "[0-9]{4}-[0-9]{2}-[0-9]{2}([+-].*|Z)";
    private static final String XSD_DATETIME_TIMEZONE_REGEXP = "[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}\\.?[0-9]*([+-].*|Z)";

    private LocalDateAdapter() {
    }

    /**
     * Converts an xs:date to a java.time.LocalDate.
     */
    public static LocalDate parseDate(String dateString) {
        // Workaround for the fact that DatatypeConverter doesn't allow setting the default TimeZone,
        // (which means that the system default TimeZone will be used, which might be wrong if hosted in
        // a different TimeZone), and that LocaleDate doesn't handle dates with explicit TimeZone.
        // Hence if the date contains an explicit TimeZone, use DatatypeConverter to do the parsing,
        // otherwise use LocalDate's parsing.
        if (dateString.matches(XSD_DATE_TIMEZONE_REGEXP) || dateString.matches(XSD_DATETIME_TIMEZONE_REGEXP)) {
            return LocalDate.from(javax.xml.bind.DatatypeConverter.parseDate(dateString).toInstant().atZone(TIMEZONE));
        } else {
            return LocalDate.parse(dateString.substring(0, ISO_DATE_PATTERN.length()));
        }
    }

    /**
     * Converts an xs:datetime to a java.time.LocalDateTime.
     */
    public static LocalDateTime parseDateTime(String dateTimeString) {
        // Workaround for the fact that DatatypeConverter doesn't allow setting the default TimeZone,
        // (which means that the system default TimeZone will be used, which might be wrong if hosted in
        // a different TimeZone), and that LocalDateTime doesn't handle datetimes with explicit TimeZone.
        // Hence if the date contains an explicit TimeZone, use DatatypeConverter to do the parsing,
        // otherwise use LocalDateTime's parsing.
        if (dateTimeString.matches(XSD_DATETIME_TIMEZONE_REGEXP) || dateTimeString.matches(XSD_DATE_TIMEZONE_REGEXP)) {
            return LocalDateTime.from(javax.xml.bind.DatatypeConverter.parseDateTime(dateTimeString).toInstant().atZone(TIMEZONE));
        } else if (dateTimeString.contains("T")) {
            return LocalDateTime.parse(dateTimeString, ISO_DATETIME_FORMATTER);
        } else {
            return LocalDate.parse(dateTimeString, DateTimeFormatter.ISO_DATE).atStartOfDay();
        }
    }

    /**
     * Converts an intyg:common-model:1:date to a LocalDate.
     */
    public static LocalDate parseIsoDate(String dateString) {
        return LocalDate.parse(dateString);
    }

    /**
     * Converts an intyg:common-model:1:dateTime to a LocalDateTime.
     */
    public static LocalDateTime parseIsoDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(ISO_DATETIME_PATTERN));
    }

    /**
     * Print a DateTime (always using ISO format).
     */
    public static String printDateTime(LocalDateTime dateTime) {
        return printIsoDateTime(dateTime);
    }

    /**
     * Print a Date (always using ISO format).
     */
    public static String printDate(LocalDate date) {
        return printIsoDate(date);
    }

    /**
     * Print a DateTime in ISO format.
     */
    public static String printIsoDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(ISO_DATETIME_PATTERN));
    }

    /**
     * Print a Date in ISO format.
     */
    public static String printIsoDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(ISO_DATE_PATTERN));
    }
}
