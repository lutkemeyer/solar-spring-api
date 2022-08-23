package com.ltk.api.solar.utils;

import com.ltk.api.solar.SolarApplication;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocalDateUtil {
	
	private static final Logger LOGGER = LogManager.getLogger(LocalDateUtil.class);
	
	@NotNull
	public static LocalDate today() {
		return LocalDate.now(SolarApplication.Defaults.ZONE_ID);
	}
	
	@NotNull
	public static LocalDate tomorrow() {
		return today().plusDays(1);
	}
	
	@NotNull
	public static LocalDate yesterday() {
		return today().minusDays(1);
	}
	
	
	public static LocalDate toLocalDate(Date date) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		return calendar.toInstant()
				.atZone(SolarApplication.Defaults.ZONE_ID)
				.toLocalDate();
	}
	
	
	public static LocalDate toLocalDate(LocalDateTime localDateTime) {
		if(localDateTime == null) {
			return null;
		}
		return localDateTime.toLocalDate();
	}
	
	
//	public static LocalDate toLocalDate(String dateString, EDateFormat format) {
//		try {
//			return toLocalDate(DateUtil.toDate(dateString, format));
//		} catch(Exception ignored) {
//			return null;
//		}
//	}
	
	/**
	 * Retorna a diferença de dias entre as datas, em módulo
	 */
	public static int differenceInDays(LocalDate ld1, LocalDate ld2) {
		return Math.abs(compareInDays(ld1, ld2));
	}
	
	/**
	 * Retorna a diferença de dias entre as datas
	 */
	public static int compareInDays(LocalDate ld1, LocalDate ld2) {
		if(ld1 == null || ld2 == null) {
			return 0;
		}
		return (int) DAYS.between(ld1, ld2);
	}
	
	/**
	 * Retorna o primeiro dia do mes
	 *
	 * @param ld
	 *
	 * @return
	 */
	public static LocalDate toFirstDayOfMonth(LocalDate ld) {
		if(ld == null) {
			return null;
		}
		return ld.with(TemporalAdjusters.firstDayOfMonth());
	}
	
	/**
	 * Retorna o ultimo dia do mes
	 *
	 * @param ld
	 *
	 * @return
	 */
	
	public static LocalDate toLastDayOfMonth(LocalDate ld) {
		if(ld == null) {
			return null;
		}
		return ld.with(TemporalAdjusters.lastDayOfMonth());
	}
	
	/**
	 * Incrementa dias em uma data
	 *
	 * @param ld
	 * @param dias
	 *
	 * @return
	 */
	
	public static LocalDate incrementDay(LocalDate ld, int dias) {
		if(ld == null) {
			return null;
		}
		return DAYS.addTo(ld, dias);
	}
	
	/**
	 * Decrementa dias em uma data
	 *
	 * @param ld
	 * @param dias
	 *
	 * @return
	 */
	
	public static LocalDate decrementDay(LocalDate ld, int dias) {
		return incrementDay(ld, -dias);
	}
	
	/**
	 * Incrementa meses em uma data
	 *
	 * @param ld
	 * @param meses
	 *
	 * @return
	 */
	
	public static LocalDate incrementMonth(LocalDate ld, int meses) {
		if(ld == null) {
			return null;
		}
		return MONTHS.addTo(ld, meses);
	}
	
	/**
	 * Decrementa meses em uma data
	 *
	 * @param ld
	 * @param meses
	 *
	 * @return
	 */
	
	public static LocalDate decrementMonth(LocalDate ld, int meses) {
		return incrementMonth(ld, -meses);
	}
	
	/**
	 * Incrementa anos em uma data
	 *
	 * @param ld
	 * @param years
	 *
	 * @return
	 */
	
	public static LocalDate incrementYear(LocalDate ld, int years) {
		if(ld == null) {
			return null;
		}
		return YEARS.addTo(ld, years);
	}
	
	/**
	 * Decrementa anos em uma data
	 *
	 * @param ld
	 * @param years
	 *
	 * @return
	 */
	
	public static LocalDate decrementYear(LocalDate ld, int years) {
		return incrementYear(ld, -years);
	}
	
}
