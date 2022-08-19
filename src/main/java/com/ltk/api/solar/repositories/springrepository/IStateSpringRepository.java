package com.ltk.api.solar.repositories.springrepository;

import com.ltk.api.solar.models.State;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStateSpringRepository extends IGenericSpringRepository<State> {

    Optional<State> findByIdAndTimeRemovedIsNull(String id);

    boolean existsByNameEqualsIgnoreCaseAndTimeRemovedIsNull(String name);

    boolean existsByIbgeCodeEqualsIgnoreCaseAndTimeRemovedIsNull(String ibgeCode);

    boolean existsByUfEqualsIgnoreCaseAndTimeRemovedIsNull(String uf);

    Optional<State> findByNameEqualsIgnoreCaseAndTimeRemovedIsNull(String name);

    Optional<State> findByIbgeCodeEqualsIgnoreCaseAndTimeRemovedIsNull(String ibgeCode);

    Optional<State> findByUfEqualsIgnoreCaseAndTimeRemovedIsNull(String uf);

    int countByTimeRemovedIsNull();

}
