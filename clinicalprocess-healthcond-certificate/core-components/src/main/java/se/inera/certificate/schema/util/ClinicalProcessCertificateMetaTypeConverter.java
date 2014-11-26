package se.inera.certificate.schema.util;

import se.inera.certificate.clinicalprocess.healthcond.certificate.v1.CertificateMetaType;
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
        return metaData;
    }
}
