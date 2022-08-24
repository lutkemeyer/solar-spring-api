package com.ltk.api.solar.tools.util;

import com.ltk.api.solar.SolarApplication;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CalendarUtil {
	
	@NotNull
	public static Calendar now() {
		return Calendar.getInstance(SolarApplication.Defaults.TIME_ZONE);
	}
	
	public static Calendar toCalendar(Date date) {
		if(date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance(SolarApplication.Defaults.TIME_ZONE);
		calendar.setTime(date);
		return calendar;
	}
	
	public static Calendar toCalendar(LocalDateTime ldt) {
		if(ldt == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance(SolarApplication.Defaults.TIME_ZONE);
		calendar.clear();
		calendar.set(ldt.getYear(), ldt.getMonthValue() - 1, ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute(), ldt.getSecond());
		return calendar;
	}
	
	public static Calendar toCalendar(LocalDate ldt) {
		if(ldt == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance(SolarApplication.Defaults.TIME_ZONE);
		calendar.clear();
		calendar.set(ldt.getYear(), ldt.getMonthValue() - 1, ldt.getDayOfMonth(), 0, 0, 0);
		return calendar;
	}
	
	public static Calendar toEndOfDay(Calendar calendar) {
		if(calendar == null) {
			return null;
		}
		Calendar clone = toCalendar(calendar.getTime());
		clone.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		clone.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		clone.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		clone.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		return clone;
	}
	
	public static Calendar toStartOfDay(Calendar calendar) {
		if(calendar == null) {
			return null;
		}
		Calendar clone = toCalendar(calendar.getTime());
		clone.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		clone.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		clone.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		clone.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		return clone;
	}
	
}
