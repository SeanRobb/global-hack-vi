package io.ctl.globalhack.repository;

import io.ctl.globalhack.common.RegisteredPersonInNeed;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by sean on 10/22/16.
 */
public interface RegisteredPersonInNeedRepository extends MongoRepository<RegisteredPersonInNeed, String> {
}
