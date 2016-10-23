package io.ctl.globalhack.repository;

import io.ctl.globalhack.common.PersonInNeed;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonInNeedRepository extends MongoRepository<PersonInNeed, String> {

    List<PersonInNeed> findByPhoneNumbersIn(String phoneNumber);

}
