package com.kos.showticat.VO;

import java.sql.Date;
import java.sql.Time;

public class ScheduleVO {
	private int schedule_num;
	private String show_code;
	private String show_name;
	private String theater_num;
	private int place_num;
	private Date show_start;
	private Time start_time;
	private int cntReserv;
	
	public ScheduleVO() {}

	public ScheduleVO(int schedule_num, String show_code, String show_name, String theater_num, int place_num,
			Date show_start, Time start_time) {
		super();
		this.schedule_num = schedule_num;
		this.show_code = show_code;
		this.show_name = show_name;
		this.theater_num = theater_num;
		this.place_num = place_num;
		this.show_start = show_start;
		this.start_time = start_time;
	}

	public ScheduleVO(int schedule_num, int cntReserv) {
		super();
		this.schedule_num = schedule_num;
		this.cntReserv = cntReserv;
	}

	public int getCntReserv() {
		return cntReserv;
	}

	public void setCntReserv(int cntReserv) {
		this.cntReserv = cntReserv;
	}

	public String getShow_name() {
		return show_name;
	}


	public void setShow_name(String show_name) {
		this.show_name = show_name;
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

	public Time getStart_time() {
		return start_time;
	}

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduleVO [schedule_num=").append(schedule_num).append(", show_code=").append(show_code)
				.append(", show_name=").append(show_name).append(", theater_num=").append(theater_num)
				.append(", place_num=").append(place_num).append(", show_start=").append(show_start)
				.append(", start_time=").append(start_time).append("]");
		return builder.toString();
	}

}
