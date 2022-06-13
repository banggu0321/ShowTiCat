package com.kos.showticat.VO;

import java.sql.Date;

public class ReservationVO {
	private int reservation_num;
	private String m_id;
	private Date reservation_date;
	private int schedule_num;
	private String payment;
	private int total_price;
	private String pay_yn;
	
	public ReservationVO() {}
	
	public ReservationVO(int reservation_num, String m_id, Date reservation_date, int schedule_num, String payment,
			int total_price, String pay_yn) {
		super();
		this.reservation_num = reservation_num;
		this.m_id = m_id;
		this.reservation_date = reservation_date;
		this.schedule_num = schedule_num;
		this.payment = payment;
		this.total_price = total_price;
		this.pay_yn = pay_yn;
	}

	public int getReservation_num() {
		return reservation_num;
	}

	public void setReservation_num(int reservation_num) {
		this.reservation_num = reservation_num;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public Date getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}

	public int getSchedule_num() {
		return schedule_num;
	}

	public void setSchedule_num(int schedule_num) {
		this.schedule_num = schedule_num;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getPay_yn() {
		return pay_yn;
	}

	public void setPay_yn(String pay_yn) {
		this.pay_yn = pay_yn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservationVO [reservation_num=").append(reservation_num).append(", m_id=").append(m_id)
				.append(", reservation_date=").append(reservation_date).append(", schedule_num=").append(schedule_num)
				.append(", payment=").append(payment).append(", total_price=").append(total_price).append(", pay_yn=")
				.append(pay_yn).append("]");
		return builder.toString();
	}
	
	
}
