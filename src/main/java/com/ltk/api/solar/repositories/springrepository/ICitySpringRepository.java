package com.ltk.api.solar.repositories.springrepository;

import com.ltk.api.solar.models.City;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICitySpringRepository extends IGenericSpringRepository<City> {

	Optional<City> findByIdAndActiveIsTrue(String id);

	Optional<City> findByIbgeCodeEqualsIgnoreCaseAndActiveIsTrue(String ibgeCode);

	boolean existsByName(String name);

	boolean existsByNameEqualsIgnoreCase(String name);

	boolean existsByNameContainsIgnoreCase(String name);

	boolean existsByIbgeCodeEqualsIgnoreCase(String ibgeCode);

	Optional<City> findByNameEqualsIgnoreCaseAndActiveIsTrueAndState_Uf(String cityName, String ufState);

	int countByActiveIsTrue();

}
