package com.kos.showticat.admin.vo;

import java.sql.Date;

public class ScheduleVO {
	private int schedule_num;
	private String show_code;
	private String theater_num;
	private int place_num;
	private Date show_start;
	
	public ScheduleVO() {
	}
	public ScheduleVO(int schedule_num, String show_code, String theater_num, int place_num, Date show_start) {
		super();
		this.schedule_num = schedule_num;
		this.show_code = show_code;
		this.theater_num = theater_num;
		this.place_num = place_num;
		this.show_start = show_start;
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
	public String getTheater_num() {
		return theater_num;
	}
	public void setTheater_num(String theater_num) {
		this.theater_num = theater_num;
	}
	public int getPlace_num() {
		return place_num;
	}
	public void setPlace_num(int place_num) {
		this.place_num = place_num;
	}
	public Date getShow_start() {
		return show_start;
	}
	public void setShow_start(Date show_start) {
		this.show_start = show_start;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduleVO [schedule_num=").append(schedule_num).append(", show_code=").append(show_code)
				.append(", theater_num=").append(theater_num).append(", place_num=").append(place_num)
				.append(", show_start=").append(show_start).append("]");
		return builder.toString();
	}
}
