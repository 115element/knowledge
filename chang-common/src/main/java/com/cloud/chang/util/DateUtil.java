package com.cloud.chang.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String getDay() {
		SimpleDateFormat daySdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		return daySdf.format(date);
	}

	public static String getDay(long time) {
		SimpleDateFormat daySdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date(time);
		return daySdf.format(date);
	}

	public static String getDay(Date time) {
		SimpleDateFormat daySdf = new SimpleDateFormat("yyyyMMdd");
		return daySdf.format(time);
	}

	public static String getMonth() {
		Date date = new Date();
		SimpleDateFormat monthSdf = new SimpleDateFormat("yyyyMM");
		return monthSdf.format(date);
	}

	public static String getMonth(long time) {
		Date date = new Date(time);
		SimpleDateFormat monthSdf = new SimpleDateFormat("yyyyMM");
		return monthSdf.format(date);
	}

	public static String getMonth(Date time) {
		SimpleDateFormat monthSdf = new SimpleDateFormat("yyyyMM");
		return monthSdf.format(time);
	}

	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat timeSdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return timeSdf.format(date);
	}

	public static String formatTime(long time) {
		Date date = new Date(time);
		SimpleDateFormat timeSdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return timeSdf.format(date);
	}

	public static String formatTime(long time, SimpleDateFormat sdf) {
		if (sdf == null) {
			return null;
		}
		Date date = new Date(time);
		return sdf.format(date);
	}

	public static Date parseTime(String time) {
		try {
			SimpleDateFormat timeSdf = new SimpleDateFormat("yyyyMMddHHmmss");
			return timeSdf.parse(time);
		} catch (ParseException e) {
		}
		return null;
	}

	public static Date getLastTimeOfMonth(Date... date) {
		Calendar calendar = Calendar.getInstance();
		if (date.length > 0) {
			calendar.setTime(date[0]);
		}
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		return calendar.getTime();
	}

	public static int getRestDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		return getCurrentMonthDay() - calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getCurrentMonthDay() {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public static Date getStartTimeOfMonth(Date... date) {
		Calendar calendar = Calendar.getInstance();
		if (date.length > 0) {
			calendar.setTime(date[0]);
		}
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		return calendar.getTime();
	}

	public static String getBeforeDay(int beforeDay) {
		return getDay(getBeforeDay(new Date(), beforeDay).getTime());
	}

	public static Date getBeforeDay(Date date, int beforeDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, day - beforeDay);
		return calendar.getTime();
	}

}
