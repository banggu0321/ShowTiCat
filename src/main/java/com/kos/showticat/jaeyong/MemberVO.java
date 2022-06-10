package com.kos.showticat.jaeyong;

import java.sql.Date;

public class MemberVO {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String email;
	private String phone;
	private Date birth;
	private String gender;
	private Date m_date;
	private int point;
	private int place_num;
	
	public MemberVO() {}

	public MemberVO(String m_id, String m_pw, String m_name, String email, String phone, Date birth, String gender,
			Date m_date, int point, int place_num) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.m_date = m_date;
		this.point = point;
		this.place_num = place_num;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getM_date() {
		return m_date;
	}

	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
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
		builder.append("MemberVO [m_id=").append(m_id).append(", m_pw=").append(m_pw).append(", m_name=").append(m_name)
				.append(", email=").append(email).append(", phone=").append(phone).append(", birth=").append(birth)
				.append(", gender=").append(gender).append(", m_date=").append(m_date).append(", point=").append(point)
				.append(", place_num=").append(place_num).append("]");
		return builder.toString();
	}
}
