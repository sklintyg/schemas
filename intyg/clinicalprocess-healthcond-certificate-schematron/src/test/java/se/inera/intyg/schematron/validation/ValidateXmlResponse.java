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
package se.inera.intyg.schematron.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A validate draft response contains a binary VALID/INVALID status and a list of validation messages.
 */
public class ValidateXmlResponse {

    private final ValidationStatus status;

    private final List<String> validationErrors;

    public ValidateXmlResponse(ValidationStatus status, List<String> validationErrors) {
        this.status = status;
        this.validationErrors = new ArrayList<>(validationErrors);
    }

    public List<String> getValidationErrors() {
        return Collections.unmodifiableList(validationErrors);
    }

    public ValidationStatus getStatus() {
        return status;
    }
}
