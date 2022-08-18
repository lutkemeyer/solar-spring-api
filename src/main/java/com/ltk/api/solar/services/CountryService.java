package com.ltk.api.solar.services;

import com.ltk.api.solar.repositories.springrepository.ICountrySpringRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService {

    private final ICountrySpringRepository repository;

}
