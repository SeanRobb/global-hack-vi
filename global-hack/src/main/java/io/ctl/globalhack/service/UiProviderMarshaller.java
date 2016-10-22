package io.ctl.globalhack.service;

import io.ctl.globalhack.common.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class UiProviderMarshaller {

    public Provider convert(UiProvider uiProvider) {
        Provider provider = new Provider();
        provider.setAddress(new Address());
        provider.setName(uiProvider.getAgencyName());
        provider.setHoursOfOperation(uiProvider.getHoursOfOperation());
        provider.setPhone(uiProvider.getAgencyPhone());
        provider.setWebsite(uiProvider.getAgencyWebsite());
        provider.setOffer(new ArrayList<Service>());
        provider.setNonProfitStatus(uiProvider.getNonProfitStatus());
        provider.setGovernmentEntity(uiProvider.getGovernmentEntity());
        provider.setFaithBased(uiProvider.getFaithBased());

        provider.setAddress(new Address()
                .setZipCode(uiProvider.getAgencyZip())
                .setCity(uiProvider.getAgencyCity())
                .setState(uiProvider.getAgencyState())
                .setDataQuality(true)
                .setStreet(uiProvider.getAgencyStreet()));

        provider.setAgencyExecInfo(
                new ContactInfo()
                        .setEmail(uiProvider.getAgencyExecEmail())
                        .setName(uiProvider.getAgencyExecName())
                        .setNumber(uiProvider.getAgencyExecNumber())
        );

        provider.setAgencyInfo(
                new ContactInfo()
                        .setEmail(uiProvider.getAdmissionContactEmail())
                        .setName(uiProvider.getAdmissionContactName())
                        .setNumber(uiProvider.getAdmissionContactNumber())
        );


        if (StringUtils.isEmpty(uiProvider.getUnitNumber())) {
            Service newService = new Service()
                    .setName("Sleeping Units")
                    .setAmount(BigDecimal.valueOf(Integer.parseInt(uiProvider.getUnitNumber())));
            provider.getOffer().add(newService);
        }

        if (StringUtils.isEmpty(uiProvider.getBedNumber())) {
            Service newService = new Service()
                    .setName("Beds")
                    .setAmount(BigDecimal.valueOf(Integer.parseInt(uiProvider.getBedNumber())));
            provider.getOffer().add(newService);
        }


        uiProvider.getPopServed();
        uiProvider.getEligibilityCriteria();

        return provider;
    }
}
