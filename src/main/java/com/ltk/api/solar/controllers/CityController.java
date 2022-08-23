package com.ltk.api.solar.controllers;

import com.ltk.api.solar.SolarApplication;
import com.ltk.api.solar.models.City;
import com.ltk.api.solar.services.CityService;
import com.ltk.api.solar.tos.city.request.CityRequestTo;
import com.ltk.api.solar.tos.city.response.CityResponseTo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*",
             maxAge = 3600)
@RequestMapping("/api/city")
public class CityController {
	
	private final CityService service;
	
	private final MessageSource messageSource;
	
	@PostMapping
	public ResponseEntity<Object> saveCity(@RequestBody @Valid CityRequestTo cityRequestTo) {
		
		// custom validations
		if(service.existsByName(cityRequestTo.getName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflict: This city already exists!");
		}
		
		City city = new City();
		BeanUtils.copyProperties(cityRequestTo, city);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.save(city));
	}
	
	@GetMapping
	public ResponseEntity<Page<CityResponseTo>> getAll(@PageableDefault(page = 0,
	                                                                    size = 20,
	                                                                    sort = {"state.name", "name"},
	                                                                    direction = Sort.Direction.ASC) Pageable pageable) {
		Page<CityResponseTo> pages = service.findAll(pageable)
				.map(city -> new CityResponseTo().setValues(city));
		return ResponseEntity.status(HttpStatus.OK)
				.body(pages);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") String id, @RequestParam(value = SolarApplication.Defaults.LANGUAGE_PARAM_NAME,
	                                                                                            required = false,
	                                                                                            defaultValue = SolarApplication.Defaults.LOCALE_LANGUAGE) Locale locale) {
		Optional<City> optCity = service.findById(id);
		if(optCity.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("City not found.");
		}
		
		String message = messageSource.getMessage("login.bemvindo", new Object[]{}, locale);
		System.out.println("Message: " + message);
		
		CityResponseTo cityResponseTo = new CityResponseTo().setValues(optCity.get());
		return ResponseEntity.status(HttpStatus.OK)
				.body(cityResponseTo);
	}
	
	@GetMapping("/ibgecode/{ibgeCode}")
	public ResponseEntity<Object> findByIbgeCode(@PathVariable(value = "ibgeCode") String ibgeCode) {
		Optional<City> optCity = service.findByIbgeCode(ibgeCode);
		if(optCity.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("City not found.");
		}
		CityResponseTo cityResponseTo = new CityResponseTo().setValues(optCity.get());
		return ResponseEntity.status(HttpStatus.OK)
				.body(cityResponseTo);
	}
	
}
