package io.ctl.globalhack.repository;

import com.ctlts.wfaas.data.orchestrate.repository.OrchestrateRepository;
import io.ctl.globalhack.common.NeedServiceOrg;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NeedServiceRepository extends MongoRepository<NeedServiceOrg, String> {
}
