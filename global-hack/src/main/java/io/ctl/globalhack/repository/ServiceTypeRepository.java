package io.ctl.globalhack.repository;

import com.ctlts.wfaas.data.orchestrate.repository.OrchestrateRepository;
import io.ctl.globalhack.common.ServiceType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceTypeRepository extends MongoRepository<ServiceType, String> {
}
