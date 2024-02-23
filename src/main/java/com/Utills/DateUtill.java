package com.Utills;

import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Test
public class DateUtill {

	public static String getTimeStamp() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatBase = DateTimeFormatter.ofPattern("E_dd_MMM_yy_hh_mm_ss");
		String formatDate = dateTime.format(formatBase);
		return formatDate;

	}

}
