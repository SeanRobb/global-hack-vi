package io.ctl.globalhack.repository;

import io.ctl.globalhack.common.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProviderRepository extends MongoRepository<Provider, String> {

    List<Provider> findByAvailableNameIn(String serviceName);

    List<Provider> findByAvailableNameInAndAvailableAmountGreaterThanEqual(String serviceName, double amount);

    List<Provider> findByAddressZipCode(String zipCode);

}
