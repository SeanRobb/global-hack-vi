package io.ctl.globalhack.service;

import io.ctl.globalhack.common.NeedServiceOrg;
import io.ctl.globalhack.common.PersonInNeed;
import io.ctl.globalhack.repository.NeedServiceOrgRepository;
import io.ctl.globalhack.repository.PersonInNeedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kevin on 10/22/16.
 */
@RestController
@Slf4j
public class LocationMatcherService {

    @Autowired
    private PersonInNeedRepository personInNeedRepository;
    @Autowired
    private NeedServiceOrgRepository needServiceOrgRepository;

    public NeedServiceOrg sendPersonInNeedMatchingNeedServiceOrg(PersonInNeed personInNeed){


        NeedServiceOrg needServiceOrg = findPersonInNeedMatchingNeedServiceOrg(personInNeed);

        return needServiceOrg;

    }

    public NeedServiceOrg findPersonInNeedMatchingNeedServiceOrg(PersonInNeed personInNeed){

        NeedServiceOrg needServiceOrg = new NeedServiceOrg();

        return needServiceOrg;
    }

}
