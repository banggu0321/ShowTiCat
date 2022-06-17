package com.kos.showticat.mypage.confirm.vo;

import java.sql.Date;
import java.sql.Time;

public class ConfirmVO {
	private String m_id;
	private String reservation_num;
	private Date reservation_date;
	private int schedule_num;
	private String show_code;
	private String show_name;
	private String category;
	private int price;
	private Date show_start_date;
	private Time show_start_time;
	private int place_num;
	private String place_name;
	private String theater_num;
	private String theater_type;
	private String payment;
	private int total_price;
	private String pay_yn;
	private String detail; //detail button
	private String cancel_yn;//cancel button
	private String review; //review button
	
	public ConfirmVO() {}

	public ConfirmVO(String m_id, String reservation_num, Date reservation_date, int schedule_num, String show_code,
			String show_name, String category, int price, Date show_start_date, Time show_start_time, int place_num,
			String place_name, String theater_num, String theater_type, String payment, int total_price, String pay_yn,
			String detail, String cancel_yn, String review) {
		super();
		this.m_id = m_id;
		this.reservation_num = reservation_num;
		this.reservation_date = reservation_date;
		this.schedule_num = schedule_num;
		this.show_code = show_code;
		this.show_name = show_name;
		this.category = category;
		this.price = price;
		this.show_start_date = show_start_date;
		this.show_start_time = show_start_time;
		this.place_num = place_num;
		this.place_name = place_name;
		this.theater_num = theater_num;
		this.theater_type = theater_type;
		this.payment = payment;
		this.total_price = total_price;
		this.pay_yn = pay_yn;
		this.detail = detail;
		this.cancel_yn = cancel_yn;
		this.review = review;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getReservation_num() {
		return reservation_num;
	}

	public void setReservation_num(String reservation_num) {
		this.reservation_num = reservation_num;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getTheater_type() {
		return theater_type;
	}

	public void setTheater_type(String theater_type) {
		this.theater_type = theater_type;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCancel_yn() {
		return cancel_yn;
	}

	public void setCancel_yn(String cancel_yn) {
		this.cancel_yn = cancel_yn;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfirmVO [m_id=").append(m_id).append(", reservation_num=").append(reservation_num)
				.append(", reservation_date=").append(reservation_date).append(", schedule_num=").append(schedule_num)
				.append(", show_code=").append(show_code).append(", show_name=").append(show_name).append(", category=")
				.append(category).append(", price=").append(price).append(", show_start_date=").append(show_start_date)
				.append(", show_start_time=").append(show_start_time).append(", place_num=").append(place_num)
				.append(", place_name=").append(place_name).append(", theater_num=").append(theater_num)
				.append(", theater_type=").append(theater_type).append(", payment=").append(payment)
				.append(", total_price=").append(total_price).append(", pay_yn=").append(pay_yn).append(", detail=")
				.append(detail).append(", cancel_yn=").append(cancel_yn).append(", review=").append(review).append("]");
		return builder.toString();
	}
}
