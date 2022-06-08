package com.kos.showticat.jayoung;

public class TheaterVO {
	private String theater_num;
	private String theater_name;
	private int last_seat;
	private int place_num;
	
	public TheaterVO() {}
	
	public TheaterVO(String theater_num, String theater_name, int last_seat, int place_num) {
		super();
		this.theater_num = theater_num;
		this.theater_name = theater_name;
		this.last_seat = last_seat;
		this.place_num = place_num;
	}

	public String getTheater_num() {
		return theater_num;
	}

	public void setTheater_num(String theater_num) {
		this.theater_num = theater_num;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TheaterVO [theater_num=").append(theater_num).append(", theater_name=").append(theater_name)
				.append(", last_seat=").append(last_seat).append(", place_num=").append(place_num).append("]");
		return builder.toString();
	}
}
