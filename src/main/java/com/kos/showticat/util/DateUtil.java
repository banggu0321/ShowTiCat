package com.kos.showticat.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
	
	public static Date sysdate() {
		java.util.Date d = new java.util.Date();
		String sdf = new SimpleDateFormat("yyyy-MM-dd").format(d);
		Date date = convertToDate(sdf);
		
		return date;
	}
	
	public static List<Date> dateList() {
		List<Date> dateList = new ArrayList<>();
		dateList.add(sysdate());
		
		Calendar cal = Calendar.getInstance();
		java.util.Date d = new java.util.Date();
		
		for(int i=0;i<6;i++) {
			cal.setTime(d);
			cal.add(Calendar.DATE, +1);

			d = cal.getTime();
			String sdf = new SimpleDateFormat("yyyy-MM-dd").format(d);
			dateList.add(convertToDate(sdf));
		}
		return dateList;
	}
}
