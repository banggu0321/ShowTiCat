package com.kos.showticat.cansu.dao;

public class TheaterVO {
	private String theater_num, theater_type;
	private int last_seat, place_num;
	public TheaterVO() {
	}
	public TheaterVO(String theater_num, String theater_type, int last_seat, int place_num) {
		this.theater_num = theater_num;
		this.theater_type = theater_type;
		this.last_seat = last_seat;
		this.place_num = place_num;
	}
	@Override
	public String toString() {
		return "TheaterVO [theater_num=" + theater_num + ", theater_type=" + theater_type + ", last_seat=" + last_seat
				+ ", place_num=" + place_num + "]";
	}
	public String getTheater_num() {
		return theater_num;
	}
	public void setTheater_num(String theater_num) {
		this.theater_num = theater_num;
	}
	public String getTheater_type() {
		return theater_type;
	}
	public void setTheater_type(String theater_type) {
		this.theater_type = theater_type;
	}
	public int getLast_seat() {
		return last_seat;
	}
	public void setLast_seat(int last_seat) {
		this.last_seat = last_seat;
	}
	public int getPlace_num() {
		return place_num;
	}
	public void setPlace_num(int place_num) {
		this.place_num = place_num;
	}
	
	
}
