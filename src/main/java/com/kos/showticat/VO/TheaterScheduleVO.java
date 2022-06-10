package com.kos.showticat.VO;

import java.sql.Date;
import java.sql.Time;

public class TheaterScheduleVO {
	private String show_code;
	private String show_name;
	private int schedule_num;
	private String theater_num;
	private int place_num;
	private Date show_start;
	private Time start_time;
	private int show_time;
	private String category;
	private String theater_type;
	private int last_seat;
	
	public TheaterScheduleVO() {
		
	}
	public TheaterScheduleVO(String show_code, String show_name, int schedule_num, String theater_num, int place_num,
			Date show_start, Time start_time, int show_time, String category, String theater_type, int last_seat) {
		super();
		this.show_code = show_code;
		this.show_name = show_name;
		this.schedule_num = schedule_num;
		this.theater_num = theater_num;
		this.place_num = place_num;
		this.show_start = show_start;
		this.start_time = start_time;
		this.show_time = show_time;
		this.category = category;
		this.theater_type = theater_type;
		this.last_seat = last_seat;
	}
	
	
}
