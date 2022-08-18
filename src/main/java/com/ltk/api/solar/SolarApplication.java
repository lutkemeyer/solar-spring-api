package com.ltk.api.solar;

import com.ltk.api.solar.config.EConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolarApplication {

	public static final EConfiguration CONFIGURATION = EConfiguration.DESENVOLVIMENTO;
	
	public static void main(String[] args) {
		SpringApplication.run(SolarApplication.class, args);
	}

}
