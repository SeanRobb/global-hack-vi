package io.ctl.globalhack.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Accessors(chain = true)
public class Provider {

    @Id
    private String id;
    private String name;
    private Address address;
    private String phone;
    private String website;

    private ProviderStatus nonProfitStatus;
    private ProviderStatus governmentEntity;
    private ProviderStatus faithBased;

    private ContactInfo agencyInfo;
    private ContactInfo agencyExecInfo;
    private String hoursOfOperation;
    private String peopleServed;
    private PopServed popServed;

    private List<Service> offer;

    private List<Service> available;
    private List<Service> inUse;
}
