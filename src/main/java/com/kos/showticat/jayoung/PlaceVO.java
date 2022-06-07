package com.kos.showticat.jayoung;

public class PlaceVO {
	private int place_num;
	private String place_name;
	private String place_loc;
	private String place_phone;
	
	public PlaceVO() {}
	
	public PlaceVO(int place_num, String place_name, String place_loc, String place_phone) {
		super();
		this.place_num = place_num;
		this.place_name = place_name;
		this.place_loc = place_loc;
		this.place_phone = place_phone;
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

	public String getPlace_loc() {
		return place_loc;
	}

	public void setPlace_loc(String place_loc) {
		this.place_loc = place_loc;
	}

	public String getPlace_phone() {
		return place_phone;
	}

	public void setPlace_phone(String place_phone) {
		this.place_phone = place_phone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlaceVO [place_num=").append(place_num).append(", place_name=").append(place_name)
				.append(", place_loc=").append(place_loc).append(", place_phone=").append(place_phone).append("]");
		return builder.toString();
	}
}
