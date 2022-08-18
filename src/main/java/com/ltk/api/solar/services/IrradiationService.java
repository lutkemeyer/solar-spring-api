package com.ltk.api.solar.services;

import com.ltk.api.solar.models.Irradiation;
import com.ltk.api.solar.repositories.generic.IrradiationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class IrradiationService {

    private final IrradiationRepository repository;

    public Irradiation findByLatLng(BigDecimal lat, BigDecimal lng) {
        return repository.findByLatLng(lat, lng);
    }

}
