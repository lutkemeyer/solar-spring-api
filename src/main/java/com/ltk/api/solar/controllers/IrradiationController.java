package com.ltk.api.solar.controllers;

import com.ltk.api.solar.models.Irradiation;
import com.ltk.api.solar.services.IrradiationService;
import com.ltk.api.solar.tos.city.response.IrradiationResponseTo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/irradiation")
public class IrradiationController {

    private final IrradiationService service;

    @GetMapping("/lat/{lat}/lng/{lng}")
    public ResponseEntity<Object> findById(
            @PathVariable(value = "lat") BigDecimal lat,
            @PathVariable(value = "lng") BigDecimal lng) {
        
        Irradiation irradiation = service.findByLatLng(lat, lng);
    
        IrradiationResponseTo irradiationResponseTo = new IrradiationResponseTo().setValues(irradiation);
        return ResponseEntity.status(HttpStatus.OK).body(irradiationResponseTo);
    }

}
