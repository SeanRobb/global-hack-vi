package io.ctl.globalhack.endpoint;

import io.ctl.globalhack.common.Coordinator;
import io.ctl.globalhack.common.NeedServiceOrg;
import io.ctl.globalhack.common.PersonInNeed;
import io.ctl.globalhack.repository.CoordinatorRepository;
import io.ctl.globalhack.repository.NeedServiceRepository;
import io.ctl.globalhack.repository.PersonInNeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Endpoint {

    @Autowired
    private CoordinatorRepository coordinatorRepository;
    @Autowired
    private NeedServiceRepository needServiceRepository;
    @Autowired
    private PersonInNeedRepository personInNeedRepository;

    @RequestMapping(method = RequestMethod.PUT, path = "/personInNeed")
    public PersonInNeed createPersonInNeed(PersonInNeed personInNeed) {
        if (personInNeed.getId() == null){
            personInNeed.setId(UUID.randomUUID().toString());
        }
        return personInNeedRepository.save(personInNeed);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/needServiceOrg")
    public NeedServiceOrg createNeedService(NeedServiceOrg needServiceOrg) {
        if (needServiceOrg.getId() == null){
            needServiceOrg.setId(UUID.randomUUID().toString());
        }
        return needServiceRepository.save(needServiceOrg);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/coordinator")
    public Coordinator createCoordinator(Coordinator coordinator) {
        if (coordinator.getId() == null){
            coordinator.setId(UUID.randomUUID().toString());
        }
        return coordinatorRepository.save(coordinator);
    }


}
