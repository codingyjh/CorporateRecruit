package com.spring.sideproject.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

	public static String format(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.KOREA);
		return simpleDateFormat.format(date);
	}
	
	public static String currentTime(String pattern) {
		return format(new Date(), pattern);
	}	
}
