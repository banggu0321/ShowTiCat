package com.kos.showticat.main.vo;

import java.sql.Date;
import java.sql.Time;

public class ScheduleShowVO {
	private int schedule_num;
	private String show_code;
	private String show_name;
	private int place_num;
	private String place_name;
	private String theater_num;
	private Date show_start_date;
	private Time show_start_time;
	private int last_seat;
	
	public ScheduleShowVO() {
		super();
	}

	public ScheduleShowVO(int schedule_num, String show_code, String show_name, int place_num, String place_name,
			String theater_num, Date show_start_date, Time show_start_time, int last_seat) {
		super();
		this.schedule_num = schedule_num;
		this.show_code = show_code;
		this.show_name = show_name;
		this.place_num = place_num;
		this.place_name = place_name;
		this.theater_num = theater_num;
		this.show_start_date = show_start_date;
		this.show_start_time = show_start_time;
		this.last_seat = last_seat;
	}

	public int getSchedule_num() {
		return schedule_num;
	}

	public void setSchedule_num(int schedule_num) {
		this.schedule_num = schedule_num;
	}

	public String getShow_code() {
		return show_code;
	}

	public void setShow_code(String show_code) {
		this.show_code = show_code;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}

	public int getPlace_num() {
		return place_num;
	}

	public void setPlace_num(int place_num) {
		this.place_num = place_num;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getTheater_num() {
		return theater_num;
	}

	public void setTheater_num(String theater_num) {
		this.theater_num = theater_num;
	}

	public Date getShow_start_date() {
		return show_start_date;
	}

	public void setShow_start_date(Date show_start_date) {
		this.show_start_date = show_start_date;
	}

	public Time getShow_start_time() {
		return show_start_time;
	}

	public void setShow_start_time(Time show_start_time) {
		this.show_start_time = show_start_time;
	}

	public int getLast_seat() {
		return last_seat;
	}

	public void setLast_seat(int last_seat) {
		this.last_seat = last_seat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduleShowVO [schedule_num=").append(schedule_num).append(", show_code=").append(show_code)
				.append(", show_name=").append(show_name).append(", place_num=").append(place_num)
				.append(", place_name=").append(place_name).append(", theater_num=").append(theater_num)
				.append(", show_start_date=").append(show_start_date).append(", show_start_time=")
				.append(show_start_time).append(", last_seat=").append(last_seat).append("]");
		return builder.toString();
	}
	
}
