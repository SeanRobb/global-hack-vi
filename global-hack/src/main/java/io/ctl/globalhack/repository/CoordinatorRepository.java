package io.ctl.globalhack.repository;

import io.ctl.globalhack.common.Coordinator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoordinatorRepository extends MongoRepository<Coordinator, String> {
}
