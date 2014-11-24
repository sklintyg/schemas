package se.inera.ifv.insuranceprocess.healthreporting.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.inera.certificate.modules.support.api.CertificateStateHolder;
import se.inera.ifv.insuranceprocess.certificate.v1.CertificateStatusType;
import se.inera.ifv.insuranceprocess.certificate.v1.StatusType;

/**
 * @author andreaskaltenbach
 */
public final class CertificateStateHolderConverter {

    private CertificateStateHolderConverter() {
    }

    public static List<CertificateStatusType> toCertificateStatusType(List<CertificateStateHolder> source) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }

        List<CertificateStatusType> states = new ArrayList<>();
        for (CertificateStateHolder state : source) {
            states.add(toCertificateStatusType(state));
        }
        return states;
    }

    private static CertificateStatusType toCertificateStatusType(CertificateStateHolder source) {
        CertificateStatusType status = new CertificateStatusType();
        status.setTarget(source.getTarget());
        status.setTimestamp(source.getTimestamp());
        status.setType(StatusType.valueOf(source.getState().name()));
        return status;
    }
}
