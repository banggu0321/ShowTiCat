package com.kos.showticat.reservation.dao.temp;

public class ReservationVO {
	
	private String mID, reservationDate, scheduleNum, payment, totalPrice, payYN;
	private int reservationNum;

	public ReservationVO() {
	}

	public ReservationVO(int reservationNum, String mID, String reservationDate, String scheduleNum, String payment,
			String totalPrice, String payYN) {
		this.reservationNum = reservationNum;
		this.mID = mID;
		this.reservationDate = reservationDate;
		this.scheduleNum = scheduleNum;
		this.payment = payment;
		this.totalPrice = totalPrice;
		this.payYN = payYN;
	}

	public int getReservationNum() {
		return reservationNum;
	}

	public void setReservationNum(int reservationNum) {
		this.reservationNum = reservationNum;
	}

	public String getmID() {
		return mID;
	}

	public void setmID(String mID) {
		this.mID = mID;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getScheduleNum() {
		return scheduleNum;
	}

	public void setScheduleNum(String scheduleNum) {
		this.scheduleNum = scheduleNum;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPayYN() {
		return payYN;
	}

	public void setPayYN(String payYN) {
		this.payYN = payYN;
	}

	@Override
	public String toString() {
		return "ReservationVO [reservationNum=" + reservationNum + ", mID=" + mID + ", reservationDate="
				+ reservationDate + ", scheduleNum=" + scheduleNum + ", payment=" + payment + ", totalPrice="
				+ totalPrice + ", payYN=" + payYN + "]";
	}
	
	
	
	

}
