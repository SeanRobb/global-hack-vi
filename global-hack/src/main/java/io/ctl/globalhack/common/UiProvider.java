package io.ctl.globalhack.common;

import lombok.Data;

@Data
public class UiProvider {

    private String agencyName;
    private String agencyPhone;
    private String agencyWebsite;

    private String agencyStreet;
    private String agencyCity;
    private String agencyState;
    private String agencyZip;

    private ProviderStatus nonProfitStatus;
    private ProviderStatus governmentEntity;
    private ProviderStatus faithBased;

    private String agencyExecName;
    private String agencyExecNumber;
    private String agencyExecEmail;

    private PopServed popServed;

    private String eligibilityCriteria;
    private String admissionContactName;
    private String admissionContactNumber;
    private String admissionContactEmail;

    private String hoursOfOperation;
    private String bedNumber;
    private String unitNumber;
    private String peopleServed;
}
