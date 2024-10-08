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
package se.inera.intyg.schemas.support.adapter.xml;

import java.time.LocalDate;
import se.inera.intyg.schemas.support.adapter.LocalDateAdapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class IsoDateXmlAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String isoDateString) throws Exception {
        return LocalDateAdapter.parseIsoDate(isoDateString);
    }

    @Override
    public String marshal(LocalDate dateValue) throws Exception {
        return LocalDateAdapter.printDate(dateValue);
    }
}
