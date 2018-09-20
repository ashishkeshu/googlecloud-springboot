package com.firekernel.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String getCurrentDateTimeInFormat(DateTimeFormatter format) {
		LocalDateTime dateTime = LocalDateTime.now();
		String strDateTime = dateTime.format(format);
		return strDateTime;
	}
}
