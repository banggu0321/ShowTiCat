package com.kos.showticat.mypage.confirm.vo;

public class ReservDetailVO {

	private int reservation_num;
	private String seatNum;

	public ReservDetailVO() {

	}

	public ReservDetailVO(int reservation_num, String seatNum) {
		super();
		this.reservation_num = reservation_num;
		this.seatNum = seatNum;
	}

	public int getReservation_num() {
		return reservation_num;
	}

	public void setReservation_num(int reservation_num) {
		this.reservation_num = reservation_num;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservDetailVO [reservation_num=").append(reservation_num).append(", seatNum=").append(seatNum)
				.append("]");
		return builder.toString();
	}

}
