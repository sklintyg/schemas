package se.inera.certificate.schema.util;

import java.util.ArrayList;
import java.util.List;

import se.inera.certificate.clinicalprocess.healthcond.certificate.v1.CertificateMetaType;
import se.inera.certificate.clinicalprocess.healthcond.certificate.v1.CertificateStatusType;
import se.inera.certificate.model.CertificateState;
import se.inera.certificate.model.Status;
import se.inera.certificate.modules.support.api.dto.CertificateMetaData;

public final class ClinicalProcessCertificateMetaTypeConverter {

    private ClinicalProcessCertificateMetaTypeConverter() {}

    public static CertificateMetaData toCertificateMetaData(CertificateMetaType certificateMetaType) {
        CertificateMetaData metaData = new CertificateMetaData();
        metaData.setCertificateId(certificateMetaType.getCertificateId());
        metaData.setCertificateType(certificateMetaType.getCertificateType());
        metaData.setValidFrom(certificateMetaType.getValidFrom());
        metaData.setValidTo(certificateMetaType.getValidTo());
        metaData.setIssuerName(certificateMetaType.getIssuerName());
        metaData.setFacilityName(certificateMetaType.getFacilityName());
        metaData.setSignDate(certificateMetaType.getSignDate());
        metaData.setAdditionalInfo(certificateMetaType.getAdditionalInfo());
        metaData.setAvailable(certificateMetaType.getAvailable().toLowerCase().equals("true"));
        List<Status> statuses = toStatusList(certificateMetaType.getStatus());
        metaData.setStatus(statuses);
        return metaData;
    }

    private static List<Status> toStatusList(List<CertificateStatusType> certificateStatuses) {
        List<Status> statuses = new ArrayList<>(certificateStatuses.size());
        for (CertificateStatusType certificateStatus : certificateStatuses) {
            statuses.add(toStatus(certificateStatus));
        }
        return statuses;
    }
    
    public static Status toStatus(CertificateStatusType certificateStatus) {
        Status status = new Status();
        status.setTarget(certificateStatus.getTarget());
        status.setTimestamp(certificateStatus.getTimestamp());
        status.setType(CertificateState.valueOf(certificateStatus.getType().value()));
        return status;
    }
}
