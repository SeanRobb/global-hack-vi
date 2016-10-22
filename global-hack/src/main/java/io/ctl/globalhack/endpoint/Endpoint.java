package io.ctl.globalhack.endpoint;

import io.ctl.globalhack.common.*;
import io.ctl.globalhack.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class Endpoint {

    @Autowired
    private CoordinatorRepository coordinatorRepository;
    @Autowired
    private NeedServiceOrgRepository needServiceOrgRepository;
    @Autowired
    private PersonInNeedRepository personInNeedRepository;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Autowired
    private RegisteredPersonInNeedRepository registeredPersonInNeedRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/personInNeed")
    public PersonInNeed createPersonInNeed(@RequestBody PersonInNeed personInNeed) {
        log.info("Creating Person In Need... {}", personInNeed);
        if (personInNeed.getId() == null) {
            personInNeed.setId(UUID.randomUUID().toString());
        }
        return personInNeedRepository.save(personInNeed);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/personInNeed")
    public PersonInNeed updatePersonInNeed(@RequestBody PersonInNeed personInNeed) {
        log.info("Creating Person In Need... {}", personInNeed);
        if (personInNeed.getId() == null) {
            personInNeed.setId(UUID.randomUUID().toString());
        }
        return personInNeedRepository.save(personInNeed);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/needServiceOrg")
    public NeedServiceOrg createNeedService(@RequestBody NeedServiceOrg needServiceOrg) {
        log.info("Creating Need Service... {}", needServiceOrg);
        if (needServiceOrg.getId() == null) {
            needServiceOrg.setId(UUID.randomUUID().toString());
        }
        return needServiceOrgRepository.save(needServiceOrg);
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


    @RequestMapping(method = RequestMethod.GET, path = "/needServiceOrg")
    public List<NeedServiceOrg> getNeedServiceOrg() {
        log.info("Finding Need Org...");
        return needServiceOrgRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/needServiceOrg", params = "service")
    public List<NeedServiceOrg> getNeedServiceOrg(@RequestParam("service") String serviceName) {
        log.info("Finding Need... Service Name: {}", serviceName);
        return needServiceOrgRepository.findByAvailableNameIn(serviceName);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/needServiceOrg", params = {"service", "available"})
    public List<NeedServiceOrg> getNeedServiceOrg(@RequestParam("service") String serviceName, @RequestParam("available") BigDecimal amountAvailable) {

        log.info("FindingNeed... Service Name: {} Amount Available: {}", serviceName, amountAvailable);
        return needServiceOrgRepository.findByAvailableNameInAndAvailableAmountGreaterThanEqual(serviceName, amountAvailable);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/service")
    public List<ServiceType> getServices() {
        log.info("Getting All Services...");
        return serviceTypeRepository.findAll();
    }



    @RequestMapping(method = RequestMethod.PUT, path = "/twilio/personInNeed")
    public PersonInNeed createTwilioPersonInNeed(@RequestParam(value="Body", required=false) String message) {

        PersonInNeed personInNeed = new PersonInNeed();

        log.info("Creating Person In Need... {}", personInNeed);
        if (personInNeed.getId() == null) {
            personInNeed.setId(UUID.randomUUID().toString());
        }

        if(message != null){
            personInNeed.setMessage(message);
        }
        return personInNeedRepository.save(personInNeed);
    }
}
