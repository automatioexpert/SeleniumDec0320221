package com.utils;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * Method to get Time Stamp
	 * @return
	 */
	public static String getTimeStamp() {
		String simpleDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		return simpleDate;
	}
}
