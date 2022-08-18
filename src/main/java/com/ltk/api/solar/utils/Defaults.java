package com.ltk.api.solar.utils;

import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

public class Defaults {
	
	public static final Locale LOCALE = new Locale("pt", "BR");
	
	public static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
	
	public static final TimeZone TIME_ZONE = TimeZone.getTimeZone(ZONE_ID);
	
	public static final String DATABASE_SCHEMA = "public";
	
	
}
