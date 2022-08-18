package com.ltk.api.solar.repositories.springrepository;

import com.ltk.api.solar.models.State;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStateSpringRepository extends IGenericSpringRepository<State> {

    Optional<State> findByIdAndActiveIsTrue(String id);

    boolean existsByNameEqualsIgnoreCaseAndActiveIsTrue(String name);

    boolean existsByIbgeCodeEqualsIgnoreCaseAndActiveIsTrue(String ibgeCode);

    boolean existsByUfEqualsIgnoreCaseAndActiveIsTrue(String uf);

    Optional<State> findByNameEqualsIgnoreCaseAndActiveIsTrue(String name);

    Optional<State> findByIbgeCodeEqualsIgnoreCaseAndActiveIsTrue(String ibgeCode);

    Optional<State> findByUfEqualsIgnoreCaseAndActiveIsTrue(String uf);

    int countByActiveIsTrue();

}
