package io.ctl.globalhack.common;

import lombok.Data;

import java.util.List;

@Data
public class UiProvider {

    private String agencyName;
    private String agencyAddress;
    private String agencyPhone;
    private String agencyWebsite;

    private String nonProfitStatus;
    private String governmentEntity;
    private String faithBased;

    private String agencyExecName;
    private String agencyExecNumber;
    private String agencyExecEmail;

    private List<String> popServed;

    private String eligibilityCriteria;
    private String admissionContactName;
    private String admissionContactNumber;
    private String admissionContactEmail;

    private String hoursOfOperation;
    private String bedNumber;
    private String unitNumber;
    private String peopleServed;
}
