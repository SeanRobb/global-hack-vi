package io.ctl.globalhack.repository;

import io.ctl.globalhack.common.NeedServiceOrg;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.List;

public interface NeedServiceOrgRepository extends MongoRepository<NeedServiceOrg, String> {

    List<NeedServiceOrg> findByAvailableNameIn(String serviceName);

    List<NeedServiceOrg> findByAvailableNameInAndAvailableAmountGreaterThanEqual(String serviceName, BigDecimal amount);


}
