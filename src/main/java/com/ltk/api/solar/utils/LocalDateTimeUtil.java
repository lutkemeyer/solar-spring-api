package com.ltk.api.solar.utils;

import com.ltk.api.solar.SolarApplication;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateTimeUtil {

	@NonNull
	public static LocalDateTime now() {
		return LocalDateTime.now(SolarApplication.Defaults.ZONE_ID);
	}

	@NonNull
	public static LocalDateTime tomorrow() {
		return now().plusDays(1);
	}

	@NonNull
	public static LocalDateTime yesterday() {
		return now().minusDays(1);
	}
	
	/**
	 * Retorna a quantidade de dias cheios entre as duas datas
	 *
	 * @param ldt1
	 * @param ldt2
	 *
	 * @return
	 */
	public static int differenceInDays(@Nullable LocalDateTime ldt1, @Nullable LocalDateTime ldt2) {
		if(ldt1 == null || ldt2 == null) {
			return 0;
		}
		return Math.abs((int) DAYS.between(ldt1, ldt2));
	}
	
	@Nullable
	public static LocalDateTime incrementDay(@Nullable LocalDateTime ldt, int dias) {
		if(ldt == null) {
			return null;
		}
		return DAYS.addTo(ldt, dias);
	}
	
	@Nullable
	public static LocalDateTime decrementDay(LocalDateTime ldt, int dias) {
		return incrementDay(ldt, -dias);
	}
	
	@Nullable
	public static LocalDateTime toStartOfDay(@Nullable LocalDateTime ldt) {
		if(ldt == null) {
			return null;
		}
		return toStartOfDay(ldt.toLocalDate());
	}
	
	@Nullable
	public static LocalDateTime toStartOfDay(@Nullable LocalDate ld) {
		if(ld == null) {
			return null;
		}
		return ld.atTime(LocalTime.MIN);
	}
	
	@Nullable
	public static LocalDateTime toEndOfDay(@Nullable LocalDateTime ldt) {
		if(ldt == null) {
			return null;
		}
		return toEndOfDay(ldt.toLocalDate());
	}
	
	@Nullable
	public static LocalDateTime toEndOfDay(@Nullable LocalDate ld) {
		if(ld == null) {
			return null;
		}
		return ld.atTime(LocalTime.MAX);
	}
	
	@Nullable
	public static LocalDateTime toLocalDateTime(@Nullable Calendar cal) {
		if(cal == null) {
			return null;
		}
		return LocalDateTime.ofInstant(cal.toInstant(), SolarApplication.Defaults.ZONE_ID);
	}
	
	@Nullable
	public static LocalDateTime toLocalDateTime(@Nullable Date date) {
		if(date == null) {
			return null;
		}
		return LocalDateTime.ofInstant(date.toInstant(), SolarApplication.Defaults.ZONE_ID);
	}
	
//	@Nullable
//	public static LocalDateTime toLocalDateTime(@Nullable LocalDate ld) {
//		if(ld == null) {
//			return null;
//		}
//		return ld.atTime(LocalTimeUtil.startOfDay());
//	}
	
	public static boolean before(@Nullable LocalDateTime ldt1, @Nullable LocalDateTime ldt2) {
		if(ldt1 == null || ldt2 == null) {
			return false;
		}
		return ldt1.isBefore(ldt2);
	}
	
	public static boolean after(@Nullable LocalDateTime ldt1, @Nullable LocalDateTime ldt2) {
		if(ldt1 == null || ldt2 == null) {
			return false;
		}
		return ldt1.isAfter(ldt2);
	}
	
}
