package io.ctl.globalhack.endpoint;

import io.ctl.globalhack.common.*;
import io.ctl.globalhack.repository.*;
import io.ctl.globalhack.service.PersonInNeedService;
import io.ctl.globalhack.service.UiProviderMarshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class Endpoint {

    @Autowired
    private CoordinatorRepository coordinatorRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private PersonInNeedRepository personInNeedRepository;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Autowired
    private RegisteredPersonInNeedRepository registeredPersonInNeedRepository;
    @Autowired
    private UiProviderMarshaller uiProviderMarshaller;
    @Autowired
    private PersonInNeedService personInNeedService;

    @RequestMapping(method = RequestMethod.POST, path = "/personInNeed")
    public PersonInNeed createPersonInNeed(@RequestBody PersonInNeed personInNeed) {
        log.info("Creating Person In Need... {}", personInNeed);
        if (personInNeed.getId() == null) {
            personInNeed.setId(UUID.randomUUID().toString());
            personInNeed.setDateCreated(new Date());
        }
        personInNeed.setDateUpdated(new Date());
        return personInNeedRepository.save(personInNeed);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/personInNeed")
    public PersonInNeed updatePersonInNeed(@RequestBody PersonInNeed personInNeed) {
        log.info("Creating Person In Need... {}", personInNeed);
        if (personInNeed.getId() == null) {
            personInNeed.setId(UUID.randomUUID().toString());
            personInNeed.setDateCreated(new Date());
        }
        personInNeed.setDateUpdated(new Date());
        return personInNeedRepository.save(personInNeed);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/personInNeed/group")
    public List<PersonInNeed> updatePersonsInNeed(@RequestBody List<PersonInNeed> personsInNeed) {
        return personsInNeed.stream().map(personInNeed -> {
                    log.info("Creating Person In Need... {}", personInNeed);
                    if (personInNeed.getId() == null) {
                        personInNeed.setId(UUID.randomUUID().toString());
                        personInNeed.setDateCreated(new Date());
                    }
                    personInNeed.setDateUpdated(new Date());
                    return personInNeedRepository.save(personInNeed);
                }
        ).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/personInNeed", params = "id")
    public void updatePersonInNeed(@RequestParam("id") String id) {
        log.info("Deleting Person In Need... {}", id);

        personInNeedRepository.delete(id);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/provider")
    public Provider createNeedService(@RequestBody Provider provider) {
        log.info("Creating Need Service... {}", provider);
        if (provider.getId() == null) {
            provider.setId(UUID.randomUUID().toString());
        }

        if (provider.getOffer() != null) {
            provider.getOffer().stream()
                    .filter(service -> serviceTypeRepository.findByName(service.getName()) == null)
                    .forEach(service -> {
                                ServiceType serviceType = new ServiceType()
                                        .setId(UUID.randomUUID().toString())
                                        .setName(service.getName());
                                serviceTypeRepository.save(serviceType);
                            }

                    );
        }

        return providerRepository.save(provider);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/provider/group")
    public List<Provider> createNeedService(@RequestBody List<Provider> providers) {
        return providers.stream().map(provider -> {
            log.info("Creating Need Service... {}", provider);
            if (provider.getId() == null) {
                provider.setId(UUID.randomUUID().toString());
            }

            if (provider.getOffer() != null) {
                provider.getOffer().stream()
                        .filter(service -> serviceTypeRepository.findByName(service.getName()) == null)
                        .forEach(service -> {
                                    ServiceType serviceType = new ServiceType()
                                            .setId(UUID.randomUUID().toString())
                                            .setName(service.getName());
                                    serviceTypeRepository.save(serviceType);
                                }

                        );
            }

            return providerRepository.save(provider);
        }).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/provider")
    public Provider createNeedService(@RequestBody UiProvider uiProvider) {
        log.info("Creating Provider Service... {}", uiProvider);
        Provider provider = uiProviderMarshaller.convert(uiProvider);
        provider.setId(UUID.randomUUID().toString());
        if (provider.getOffer() != null) {
            provider.getOffer().stream()
                    .filter(service -> serviceTypeRepository.findByName(service.getName()) == null)
                    .forEach(service -> {
                                ServiceType serviceType = new ServiceType()
                                        .setId(UUID.randomUUID().toString())
                                        .setName(service.getName());
                                serviceTypeRepository.save(serviceType);
                            }

                    );
        }
        return providerRepository.save(provider);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/coordinator")
    public Coordinator createCoordinator(@RequestBody Coordinator coordinator) {
        log.info("Creating Coordinator... {}", coordinator);
        if (coordinator.getId() == null) {
            coordinator.setId(UUID.randomUUID().toString());
        }
        return coordinatorRepository.save(coordinator);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/registeredPersonInNeed")
    public RegisteredPersonInNeed createRegisteredPersonInNeed(@RequestBody RegisteredPersonInNeed registeredPersonInNeed) {
        log.info("Creating Registered Person in Need... {}", registeredPersonInNeed);
        if (registeredPersonInNeed.getId() == null) {
            registeredPersonInNeed.setId(UUID.randomUUID().toString());
        }

        return registeredPersonInNeedRepository.save(registeredPersonInNeed);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/service")
    public ServiceType createService(@RequestBody ServiceType serviceType) {
        log.info("Creating Service... {}", serviceType);
        if (serviceType.getId() == null) {
            serviceType.setId(UUID.randomUUID().toString());
        }

        return serviceTypeRepository.save(serviceType);
    }

// GETS


    @RequestMapping(method = RequestMethod.GET, path = "/provider")
    public List<Provider> getProvider() {
        log.info("Finding Need Org...");
        return providerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/provider", params = "service")
    public List<Provider> getProvider(@RequestParam("service") String serviceName) {
        log.info("Finding Need... Service Name: {}", serviceName);
        return providerRepository.findByAvailableNameIn(serviceName);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/provider", params = {"service", "available"})
    public List<Provider> getProvider(@RequestParam("service") String serviceName, @RequestParam("available") BigDecimal amountAvailable) {
        log.info("FindingNeed... Service Name: {} Amount Available: {}", serviceName, amountAvailable);
        List<Provider> byAvailableNameIn = providerRepository.findByAvailableNameIn(serviceName);
        return byAvailableNameIn.stream()
                .filter(provider ->
                        provider.getAvailable().stream()
                                .filter(service -> service.getName().equalsIgnoreCase(serviceName))
                                .filter(service -> service.getAmount().compareTo(amountAvailable) < 0)
                                .collect(Collectors.toList()).isEmpty())
                .sorted((provider1, provider2) -> {
                    Optional<Service> first = provider1.getAvailable().stream()
                            .filter(service -> service.getName().equalsIgnoreCase(serviceName))
                            .findFirst();
                    Optional<Service> second = provider2.getAvailable().stream()
                            .filter(service -> service.getName().equalsIgnoreCase(serviceName))
                            .findFirst();

                    if (first.isPresent() && !second.isPresent()) {
                        return 1;
                    }
                    if (!first.isPresent() && second.isPresent()) {
                        return -1;
                    }

                    return second.get().getAmount().compareTo(first.get().getAmount());

                })
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/service")
    public List<String> getServices() {
        log.info("Getting All Services...");
        List<Provider> all = providerRepository.findAll();
        return all.stream()
                .map(Provider::getOffer)
                .flatMap(services -> services.stream().map(Service::getName).distinct())
                .collect(Collectors.toList());
    }


    @RequestMapping(method = RequestMethod.GET, path = "/personInNeed")
    public List<PersonInNeed> getPersonsInNeed() {
        log.info("Getting All Persons In Need...");
        List<PersonInNeed> personInNeeds = personInNeedRepository.findAll();
        return personInNeeds.stream()
                .filter(personInNeed -> personInNeed != null)
                .filter(personInNeed -> personInNeed.getPhoneNumbers() != null)
                .filter(personInNeed -> !personInNeed.getPhoneNumbers().isEmpty())
                .filter(personInNeed -> !personInNeed.getPhoneNumbers()
                        .stream()
                        .filter(phoneNumber -> phoneNumber != null)
                        .collect(Collectors.toList()).isEmpty()
                )
                .filter(personInNeed -> personInNeed.getDateCreated() != null)
                .filter(personInNeed -> personInNeed.getDateUpdated() != null)
                .sorted((personInNeed1, personsInNeed2) -> personInNeed1.getDateCreated().compareTo(personsInNeed2.getDateCreated()))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/personInNeed", params = "phoneNumber")
    public List<PersonInNeed> getPersonsInNeedPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        log.info("Getting All Persons In Need...");
        return personInNeedRepository.findByPhoneNumbersIn(phoneNumber);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/registeredPersonInNeed", params = "phoneNumber")
    public List<RegisteredPersonInNeed> getRegisteredPersonsInNeedPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        log.info("Getting All Persons In Need...");
        return registeredPersonInNeedRepository.findByPersonInNeedPhoneNumbersIn(phoneNumber);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/personInNeed", params = "id")
    public PersonInNeed getPersonsInNeedId(@RequestParam("id") String id) {
        log.info("Getting All Persons In Need...");
        return personInNeedRepository.findOne(id);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/registeredPersonInNeed", params = "id")
    public RegisteredPersonInNeed getRegisteredPersonsInNeedId(@RequestParam("id") String id) {
        log.info("Getting All Persons In Need...");
        return registeredPersonInNeedRepository.findOne(id);
    }

//Twilio

    @RequestMapping(method = RequestMethod.POST, path = "/twilio/personInNeed")
    public PersonInNeed createTwilioPersonInNeed(
            @RequestParam(value = "From", required = false) String fromPhoneNumber,
            @RequestParam(value = "FromCity", required = false) String city,
            @RequestParam(value = "FromState", required = false) String state,
            @RequestParam(value = "FromZip", required = false) String postalCode,
            @RequestParam(value = "Body", required = false) String message
    ) {

        PersonInNeed personInNeed = personInNeedService.onboardPersonInNeedThatSentText(fromPhoneNumber, city, state, postalCode, message);
        log.info("Person in need Created: {}", personInNeed);

        return personInNeed;
    }


}
