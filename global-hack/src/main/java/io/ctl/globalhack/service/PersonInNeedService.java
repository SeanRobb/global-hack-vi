package io.ctl.globalhack.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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

    public static final String TWILIO_PHONE_NUMBER = "+13143100135";
    @Autowired
    private PersonInNeedRepository personInNeedRepository;
    @Autowired
    private ProviderRepository providerRepository;

//    public static final String ACCOUNT_SID = "SK2badf512495c94f521ea229dff6ca187";
    public static final String ACCOUNT_SID = "ACe2074918b35e85c77cfaa54f74da04fb";
//    public static final String AUTH_TOKEN = "BbF3s59GKXKVJ11p7xvDJ7SoFNxR3iyz";
    public static final String AUTH_TOKEN = "7eb732c423f5c6d7b84f1236048335a3";


    public PersonInNeed onboardPersonInNeedThatSentText(String fromPhoneNumber,
                                                        String city,
                                                        String state,
                                                        String postalCode,
                                                        String message){

        log.info("Onboarding Person In Need... {} {} {} {} {}",
                fromPhoneNumber,
                city,
                state,
                postalCode,
                message
                );

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

        log.info("Sending Person in need matching provider... {}", personInNeed);

        List<Provider> providers = findPersonInNeedMatchingProvider(personInNeed);

        String message = "A support coordinator will contact you shortly. \n\n\n";

        if(providers != null && providers.size() > 0){

            message += "Providers Near You: \n\n";

            for(Provider provider : providers){
                message +=
                        provider.getName() + "\n" +
                        provider.getAddress().getStreet() + "\n" +
                        provider.getAddress().getCity() + "\n" +
                        provider.getAddress().getState() + "\n" +
                        provider.getAddress().getZipCode() + "\n\n";
            }
        }
        sendMessage(personInNeed, message);

        return providers;

    }

    private void sendMessage(PersonInNeed personInNeed, String messageToPersonInNeed) {

        log.info("Sending Message... {}, {}", personInNeed, messageToPersonInNeed);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        for(String phoneNumber: personInNeed.getPhoneNumbers()){

            if(phoneNumber != null && phoneNumber.length() > 0){

                Message message = Message.creator(
                        new PhoneNumber(phoneNumber),  // To number
                        new PhoneNumber(TWILIO_PHONE_NUMBER),  // From number
                        messageToPersonInNeed                    // SMS body
                ).create();

            }
        }

    }

    public List<Provider> findPersonInNeedMatchingProvider(PersonInNeed personInNeed){

        log.info("Finding person in need matching provider... {}", personInNeed);

        List<Provider> providers = providerRepository.findByAddressZipCode(personInNeed.getAddress().getZipCode());

        return providers;
    }



}
