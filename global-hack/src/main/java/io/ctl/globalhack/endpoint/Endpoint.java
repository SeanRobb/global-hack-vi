package io.ctl.globalhack.endpoint;

import com.google.common.collect.Lists;
import io.ctl.globalhack.common.Coordinator;
import io.ctl.globalhack.common.NeedServiceOrg;
import io.ctl.globalhack.common.PersonInNeed;
import io.ctl.globalhack.common.ServiceType;
import io.ctl.globalhack.repository.CoordinatorRepository;
import io.ctl.globalhack.repository.NeedServiceRepository;
import io.ctl.globalhack.repository.PersonInNeedRepository;
import io.ctl.globalhack.repository.ServiceTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Slf4j
public class Endpoint {

    @Autowired
    private CoordinatorRepository coordinatorRepository;
    @Autowired
    private NeedServiceRepository needServiceRepository;
    @Autowired
    private PersonInNeedRepository personInNeedRepository;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @RequestMapping(method = RequestMethod.PUT, path = "/personInNeed")
    public PersonInNeed createPersonInNeed(@RequestBody PersonInNeed personInNeed) {
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
        return needServiceRepository.save(needServiceOrg);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/coordinator")
    public Coordinator createCoordinator(@RequestBody Coordinator coordinator) {
        log.info("Creating Coordinator... {}", coordinator);
        if (coordinator.getId() == null) {
            coordinator.setId(UUID.randomUUID().toString());
        }
        return coordinatorRepository.save(coordinator);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/service")
    public ServiceType createService(@RequestBody ServiceType serviceType) {
        log.info("Creating Service... {}", serviceType);
        if (serviceType.getId() == null) {
            serviceType.setId(UUID.randomUUID().toString());
        }

        return serviceTypeRepository.save(serviceType);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/needServiceOrg", params = "service")
    public List<NeedServiceOrg> getNeedServiceOrg(@RequestParam("service") String serviceName) {
        log.info("findingNeed...");
        return needServiceRepository.findByAvailableNameIn(serviceName);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/needServiceOrg", params = {"service", "amount"})
    public List<NeedServiceOrg> getNeedServiceOrg(@RequestParam("service") String serviceName, @RequestParam("amount") BigDecimal amountAvailable) {

        log.info("findingNeed...");
        return needServiceRepository.findByAvailableNameInAndAvailableAmount(serviceName, amountAvailable);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/service")
    public List<ServiceType> getServices() {
        log.info("Getting...");
        return Lists.newArrayList(serviceTypeRepository.findAll());
    }
}
