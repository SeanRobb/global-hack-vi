package io.ctl.globalhack.service;

import io.ctl.globalhack.common.Address;
import io.ctl.globalhack.common.PersonInNeed;
import io.ctl.globalhack.common.Provider;
import io.ctl.globalhack.repository.PersonInNeedRepository;
import io.ctl.globalhack.repository.ProviderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by kevin on 10/22/16.
 */
@Component
@Slf4j
public class PersonInNeedService {

    @Autowired
    private PersonInNeedRepository personInNeedRepository;
    @Autowired
    private ProviderRepository providerRepository;

    public PersonInNeed onboardPersonInNeedThatSentText(String fromPhoneNumber,
                                                        String city,
                                                        String state,
                                                        String postalCode,
                                                        String message){
        PersonInNeed personInNeed = savePersonInNeed(fromPhoneNumber, city, state, postalCode, message);

        sendPersonInNeedMatchingProvider(personInNeed);

        return personInNeed;
    }

    public PersonInNeed savePersonInNeed(String fromPhoneNumber,
                                         String city,
                                         String state,
                                         String postalCode,
                                         String message) {

        PersonInNeed personInNeed = new PersonInNeed();
        Address address = new Address();
        personInNeed.setAddress(address);

        log.info("Creating Person In Need... {}", personInNeed);
        if (personInNeed.getId() == null) {
            personInNeed.setId(UUID.randomUUID().toString());
        }

        if (fromPhoneNumber != null) {
            personInNeed.setPhoneNumbers(Arrays.asList(fromPhoneNumber));
        }


        if (city != null) {
            address.setCity(city);
        }
        if (state != null) {
            address.setState(state);
        }
        if (postalCode != null) {
            address.setZipCode(postalCode);
        }
        if (message != null) {
            personInNeed.setMessage(message);
        }
        return personInNeedRepository.save(personInNeed);
    }

    public List<Provider> sendPersonInNeedMatchingProvider(PersonInNeed personInNeed){


        List<Provider> providers = findPersonInNeedMatchingProvider(personInNeed);



        return providers;

    }

    public List<Provider> findPersonInNeedMatchingProvider(PersonInNeed personInNeed){

        List<Provider> providers = providerRepository.findByAddressZipCode(personInNeed.getAddress().getZipCode());

        return providers;
    }



}
