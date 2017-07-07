package com.dgcredit.repluginhostdemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

	// 获取当前日期
	public static String getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		return dateFormat.format(calendar.getTime());
	}

	// 格式化指定日期
	public static String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	public static int daysBetween(String smdate, String bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//格式化秒
	public static String formatSecond(String second) {
		String dateString = "0秒";
		if (second != "") {
			Double s = Double.parseDouble(second);
			String format;
			Object[] array;
			Integer hours = (int) (s / (60 * 60));
			Integer minutes = (int) (s / 60 - hours * 60);
			Integer seconds = (int) (s - minutes * 60 - hours * 60 * 60);
			if (hours > 0) {
				format = "%1$,d时%2$,d分%3$,d秒";
				array = new Object[] { hours, minutes, seconds };
			} else if (minutes > 0) {
				format = "%1$,d分%2$,d秒";
				array = new Object[] { minutes, seconds };
			} else {
				format = "%1$,d秒";
				array = new Object[] { seconds };
			}
			dateString = String.format(format, array);
		}
		return dateString;
	}



	public static String getFormatDate(String timestampString,
			String formatString) {
		// "yyyyMMdd:hhmmss" 20100113:151902
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		long unixLong = 0;
		String date = "";
		try {
			switch (timestampString.length()) {
			case 13:
				unixLong = Long.parseLong(timestampString);
				break;
			case 10:
				unixLong = Long.parseLong(timestampString) * 1000;
				break;
			}
			date = format.format(unixLong);
		} catch (Exception ex) {
			return "";
		}
		return date;
	}

	public static String getTimestampDate(String dateString, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		try {
			return String.valueOf(format.parse(dateString).getTime());
		} catch (Exception e) {
			return "";
		}
	}
}
