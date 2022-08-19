package com.ltk.api.solar.services;

import com.ltk.api.solar.models.City;
import com.ltk.api.solar.repositories.springrepository.ICitySpringRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private final ICitySpringRepository repository;

    @Transactional
    public City save(City city) {
        return repository.save(city);
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    public Page<City> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<City> findById(String id) {
        return repository.findById(id);
    }

    public Optional<City> findByIbgeCode(String codIbge) {
        return repository.findByIbgeCodeEqualsIgnoreCaseAndTimeRemovedIsNull(codIbge);
    }


}
