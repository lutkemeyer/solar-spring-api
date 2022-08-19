package com.ltk.api.solar.repositories.springrepository;

import com.ltk.api.solar.models.Country;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICountrySpringRepository extends IGenericSpringRepository<Country> {

    Optional<Country> findByIdAndTimeRemovedIsNull(String id);

    int countByTimeRemovedIsNull();

}
