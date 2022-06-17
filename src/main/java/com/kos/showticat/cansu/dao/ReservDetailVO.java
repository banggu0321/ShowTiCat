package com.kos.showticat.cansu.dao;

public class ReservDetailVO {
	
	private String ReservationNum, seatNum;

	public ReservDetailVO() {
	}

	public ReservDetailVO(String reservationNum, String seatNum) {
		ReservationNum = reservationNum;
		this.seatNum = seatNum;
	}

	public String getReservationNum() {
		return ReservationNum;
	}

	public void setReservationNum(String reservationNum) {
		ReservationNum = reservationNum;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	@Override
	public String toString() {
		return "ReservDetailVO [ReservationNum=" + ReservationNum + ", seatNum=" + seatNum + "]";
	}
}
