package se.inera.ifv.insuranceprocess.healthreporting.validate;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.inera.certificate.logging.LogMarkers;
import se.inera.certificate.schema.Constants;
import se.inera.ifv.insuranceprocess.healthreporting.v2.PatientType;

import com.google.common.base.Joiner;

public final class PatientValidator {

    private static final Logger LOG = LoggerFactory.getLogger(PatientValidator.class);

    private static final List<String> PATIENT_ID_OIDS = asList(Constants.PERSON_ID_OID, Constants.SAMORDNING_ID_OID);

    private static final String PERSON_NUMBER_REGEX = "[0-9]{8}[-+]?[0-9]{4}";
    private static final String PERSON_NUMBER_WITHOUT_DASH_REGEX = "[0-9]{12}";

    private PatientValidator() {
    }

    /**
     *  Validate and correct patient information.
     *  @return true if valid enough to continue
     */
    public static List<String> validateAndCorrect(PatientType patient) {
        List<String> validationErrors = new ArrayList<String>();
        if (patient == null) {
            validationErrors.add("No Patient element found!");
            return validationErrors;
        }

        // Check patient id - mandatory
        if (patient.getPersonId() == null
            || patient.getPersonId().getExtension() == null
            || patient.getPersonId().getExtension().isEmpty()) {
            validationErrors.add("No Patient Id found!");
            return validationErrors;
        }
        //Correct personnummer without dashes
        String personNumber = patient.getPersonId().getExtension();
        if (Pattern.matches(PERSON_NUMBER_WITHOUT_DASH_REGEX, personNumber)) {
            patient.getPersonId().setExtension(formatWithDash(personNumber));
            LOG.warn(LogMarkers.VALIDATION, "Validation warning: Person-id " + personNumber + " is lacking a separating dash - corrected.");
        }
        // Check patient o.i.d.
        if (patient.getPersonId().getRoot() == null || !PATIENT_ID_OIDS.contains(patient.getPersonId().getRoot())) {
            validationErrors.add(String.format("Wrong o.i.d. for Patient Id! Should be %s", Joiner.on(" or ").join(PATIENT_ID_OIDS)));
        }

        // Check format of patient id (has to be a valid personnummer)
        if (!Pattern.matches(PERSON_NUMBER_REGEX, personNumber)) {
            validationErrors.add("Wrong format for person-id! Valid format is YYYYMMDD-XXXX or YYYYMMDD+XXXX.");
        }
        return validationErrors;
    }

    // CHECKSTYLE:OFF MagicNumber
    private static String formatWithDash(String personNumber) {
        return personNumber.substring(0, 8) + "-" + personNumber.substring(8);
    }
    // CHECKSTYLE:ON MagicNumber
}
