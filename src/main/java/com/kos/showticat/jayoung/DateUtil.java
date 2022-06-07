package com.kos.showticat.jayoung;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	public static Date convertToDate(String strdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d;
		Date d2 = null;
		try {
			d = sdf.parse(strdate);
			d2 = new Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d2;
	}
	
}
