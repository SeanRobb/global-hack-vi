package io.ctl.globalhack.repository;

import com.ctlts.wfaas.data.orchestrate.repository.OrchestrateRepository;
import io.ctl.globalhack.common.PersonInNeed;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonInNeedRepository extends MongoRepository<PersonInNeed, String> {
}
