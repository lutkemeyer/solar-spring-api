package com.ltk.api.solar.tools.util;

import com.ltk.api.solar.SolarApplication;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil extends DateUtils {
	
	public static boolean before(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return false;
		}
		return date1.before(date2);
	}
	
	/**
	 * Primeiro depois do segundo
	 */
	public static boolean after(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return false;
		}
		return date1.after(date2);
	}
	
	public static boolean equals(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return false;
		}
		return date1.equals(date2);
	}
	
	public static boolean isToday(Date date) {
		if(date == null) {
			return false;
		}
		LocalDate localDate = LocalDateUtil.toLocalDate(date);
		LocalDate today = LocalDateUtil.today();
		return today.isEqual(localDate);
	}
	
	/**
	 * Segunda-feira
	 */
	public static boolean isMonday(Date date) {
		if(date == null) {
			return false;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;
	}
	
	/**
	 * Terça-feira
	 */
	public static boolean isTuesday(Date date) {
		if(date == null) {
			return false;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY;
	}
	
	/**
	 * Quarta-feira
	 */
	public static boolean isWednesday(Date date) {
		if(date == null) {
			return false;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY;
	}
	
	/**
	 * Quinta-feira
	 */
	public static boolean isThursday(Date date) {
		if(date == null) {
			return false;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY;
	}
	
	/**
	 * Sexta-feira
	 */
	public static boolean isFriday(Date date) {
		if(date == null) {
			return false;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
	}
	
	/**
	 * Sábado
	 */
	public static boolean isSaturday(Date date) {
		if(date == null) {
			return false;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
	}
	
	/**
	 * Domingo
	 */
	public static boolean isSunday(Date date) {
		if(date == null) {
			return false;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}
	
	public static boolean isSameYear(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return false;
		}
		Calendar calendar = CalendarUtil.toCalendar(date1);
		int year1 = calendar.get(Calendar.YEAR);
		calendar.setTime(date2);
		int year2 = calendar.get(Calendar.YEAR);
		return year1 == year2;
	}
	
	public static boolean isSameMonth(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return false;
		}
		Calendar calendar = CalendarUtil.toCalendar(date1);
		int month1 = calendar.get(Calendar.MONTH);
		calendar.setTime(date2);
		int month2 = calendar.get(Calendar.MONTH);
		return month1 == month2;
	}
	
	public static boolean isSameMonthAndYear(Date date1, Date date2) {
		return isSameMonth(date1, date2) && isSameYear(date1, date2);
	}
	
	public static boolean isWeekend(Date date) {
		if(date == null) {
			return false;
		}
		return isSaturday(date) || isSunday(date);
	}
	
	public static boolean isBeforeNoon(Date date) {
		Calendar calendar = CalendarUtil.toCalendar(date);
		return calendar.get(Calendar.HOUR_OF_DAY) < 12;
	}
	
	public static boolean isAfterNoon(Date date) {
		Calendar calendar = CalendarUtil.toCalendar(date);
		return calendar.get(Calendar.HOUR_OF_DAY) >= 12;
	}
	
	public static Date incrementDay(Date date, int days) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	public static Date decrementDay(Date date, int days) {
		return incrementDay(date, -days);
	}
	
	public static Date incrementMonth(Date date, int months) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	
	
	public static Date decrementMonth(Date date, int months) {
		return incrementMonth(date, -months);
	}
	
	
	public static Date incrementYear(Date date, int years) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
	}
	
	
	public static Date decrementYear(Date date, int years) {
		return incrementYear(date, -years);
	}
	
	
	public static Date incrementHour(Date date, int hours) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.add(Calendar.HOUR, hours);
		return calendar.getTime();
	}
	
	
	public static Date decrementHour(Date date, int hours) {
		return incrementHour(date, -hours);
	}
	
	
	public static Date incrementMinute(Date date, int minutes) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}
	
	
	public static Date decrementMinute(Date date, int minutes) {
		return incrementMinute(date, -minutes);
	}
	
	
	public static Date incrementSecond(Date date, int seconds) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}
	
	
	public static Date decrementSecond(Date date, int seconds) {
		return incrementSecond(date, -seconds);
	}
	
	public static int differenceInDays(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return -1;
		}
		long dias = ChronoUnit.DAYS.between(date1.toInstant(), date2.toInstant());
		return (int) dias;
	}
	
	public static int differenceInDays(LocalDate localDate1, LocalDate localDate2) {
		if(localDate1 == null || localDate2 == null) {
			return -1;
		}
		return differenceInDays(toDate(localDate1), toDate(localDate2));
	}
	
	public static int differenceInMonths(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return -1;
		}
		int years = differenceInYears(date1, date2);
		int monthsInThisYear = getMonth(date2) - getMonth(date1);
		return years * 12 + monthsInThisYear;
	}
	
	public static int differenceInMonths(LocalDate localDate1, LocalDate localDate2) {
		if(localDate1 == null || localDate2 == null) {
			return -1;
		}
		return Period.between(localDate1, localDate2)
				.getMonths();
	}
	
	public static int differenceInYears(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return -1;
		}
		return getYear(date2) - getYear(date1);
	}
	
	public static int differenceInYears(LocalDate localDate1, LocalDate localDate2) {
		if(localDate1 == null || localDate2 == null) {
			return -1;
		}
		return Period.between(localDate1, localDate2)
				.getYears();
	}
	
	public static Date toStartOfDay(Date date) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		return calendar.getTime();
	}
	
	public static Date toEndOfDay(Date date) {
		if(date == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar.getTime();
	}
	
	public static Date toStartOfMonth(Date date) {
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
	
	public static Date toEndOfMonth(Date date) {
		Calendar calendar = CalendarUtil.toCalendar(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
	
	public static boolean equivalentDate(Date d1, Date d2) {
		if(d1 == null && d2 == null) {
			return true;
		}
		if(d1 == null || d2 == null) {
			return false;
		}
		int year1 = getYear(d1);
		int year2 = getYear(d2);
		if(year1 != year2) {
			return false;
		}
		int month1 = getMonth(d1);
		int month2 = getMonth(d2);
		if(month1 != month2) {
			return false;
		}
		int day1 = getDay(d1);
		int day2 = getDay(d2);
		if(day1 != day2) {
			return false;
		}
		return true;
	}
	
	public static Date getGreater(Date... dates) {
		if(dates == null) {
			return null;
		}
		Date greater = null;
		for(Date date : dates) {
			if((greater == null && date != null) || after(greater, date)) {
				greater = date;
			}
		}
		return greater;
	}
	
	public static Date getGreater(List<Date> dateList) {
		if(dateList == null) {
			return null;
		}
		return getGreater((Date[]) dateList.toArray());
	}
	
	public static boolean isYear(Date date, int year) {
		if(date == null) {
			return false;
		}
		return year == getYear(date);
	}
	
	public static boolean isMonth(Date date, int month) {
		if(date == null) {
			return false;
		}
		return month == getMonth(date);
	}
	
	public static boolean isDay(Date date, int day) {
		if(date == null) {
			return false;
		}
		return day == getDay(date);
	}
	
	public static boolean isHour(Date date, int hour) {
		if(date == null) {
			return false;
		}
		return hour == getHour(date);
	}
	
	public static boolean isMinute(Date date, int minute) {
		if(date == null) {
			return false;
		}
		return minute == getMinute(date);
	}
	
	public static boolean isSecond(Date date, int second) {
		if(date == null) {
			return false;
		}
		return second == getSecond(date);
	}
	
	public static int getYear(Date date) {
		if(date == null) {
			return 0;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date) {
		if(date == null) {
			return 0;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.MONTH);
	}
	
	public static int getDay(Date date) {
		if(date == null) {
			return 0;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getHour(Date date) {
		if(date == null) {
			return 0;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.HOUR);
	}
	
	public static int getMinute(Date date) {
		if(date == null) {
			return 0;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.MINUTE);
	}
	
	public static int getSecond(Date date) {
		if(date == null) {
			return 0;
		}
		return CalendarUtil.toCalendar(date)
				.get(Calendar.SECOND);
	}
	
//	public static Date toDate(String dateString) {
//		return toDate(dateString, null);
//	}
//
//	public static Date toDate(String dateString, EDateFormat format) {
//		if(StrUtil.isEmpty(dateString)) {
//			return null;
//		}
//		if(format == null) {
//			format = EDateFormat.findPattern(dateString);
//			if(format == null) {
//				return null;
//			}
//		}
//		try {
//			return new SimpleDateFormat(format.getPattern()).parse(dateString);
//		} catch(java.text.ParseException e) {
//			return null;
//		}
//	}
	
	
	public static Date toDate(LocalDate localDate) {
		if(localDate == null) {
			return null;
		}
		try {
			return Date.from(localDate.atStartOfDay(SolarApplication.Defaults.ZONE_ID)
					.toInstant());
		} catch(Exception e) {
			return null;
		}
	}
	
	
	public static Date toDate(LocalDateTime localDateTime) {
		if(localDateTime == null) {
			return null;
		}
		Calendar calendar = CalendarUtil.toCalendar(localDateTime);
		return calendar != null ? calendar.getTime() : null;
	}
	
	@NonNull
	public static Date now() {
		return CalendarUtil.now()
				.getTime();
	}
}
