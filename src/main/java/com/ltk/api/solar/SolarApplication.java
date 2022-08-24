package com.ltk.api.solar;

import com.ltk.api.solar.tools.enums.EnumConfiguration;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
public class SolarApplication {

	public static final EnumConfiguration CONFIGURATION = EnumConfiguration.DESENVOLVIMENTO;
	
	public static final boolean AUTH_ENABLED = false;
	
	public static void main(String[] args) {
		SpringApplication.run(SolarApplication.class, args);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class Defaults {
		
		public static final String LANGUAGE_PARAM_NAME = "lang";
		
		public static final String LOCALE_LANGUAGE = "pt";
		
		public static final String LOCALE_COUNTRY = "BR";
		
		public static final Locale LOCALE = new Locale(LOCALE_LANGUAGE, LOCALE_COUNTRY);
		
		public static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
		
		public static final TimeZone TIME_ZONE = TimeZone.getTimeZone(ZONE_ID);
		
		public static final String DATABASE_SCHEMA = "public";
		
		
	}
	
}
