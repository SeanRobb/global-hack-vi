package io.ctl.globalhack.repository;

import io.ctl.globalhack.common.RegisteredPersonInNeed;
import io.ctl.globalhack.common.person.info.veteran.VeteranInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by sean on 10/22/16.
 */
public interface RegisteredPersonInNeedRepository extends MongoRepository<RegisteredPersonInNeed, String> {
    List<RegisteredPersonInNeed> findByVeteranInfo(VeteranInfo veteranInfo);
}
