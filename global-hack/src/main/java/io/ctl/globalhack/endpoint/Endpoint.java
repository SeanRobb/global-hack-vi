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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
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
    public PersonInNeed createPersonInNeed(PersonInNeed personInNeed) {
        if (personInNeed.getId() == null) {
            personInNeed.setId(UUID.randomUUID().toString());
        }
        return personInNeedRepository.save(personInNeed);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/needServiceOrg")
    public NeedServiceOrg createNeedService(NeedServiceOrg needServiceOrg) {
        if (needServiceOrg.getId() == null) {
            needServiceOrg.setId(UUID.randomUUID().toString());
        }
        return needServiceRepository.save(needServiceOrg);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/coordinator")
    public Coordinator createCoordinator(Coordinator coordinator) {
        if (coordinator.getId() == null) {
            coordinator.setId(UUID.randomUUID().toString());
        }
        return coordinatorRepository.save(coordinator);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/service")
    public ServiceType createService(ServiceType serviceType) {
        if (serviceType.getId() == null) {
            serviceType.setId(UUID.randomUUID().toString());
        }

        return serviceTypeRepository.save(serviceType);
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/needServiceOrg")
//    public List<NeedServiceOrg> getNeedServiceOrg(@RequestParam("service") String serviceName, @RequestParam("amount") String amountAvailable) {
//
//    }

    @RequestMapping(method = RequestMethod.GET, path = "/needServiceOrg/service")
    public List<ServiceType> getServices() {
        return Lists.newArrayList(serviceTypeRepository.findAll());
    }
}
