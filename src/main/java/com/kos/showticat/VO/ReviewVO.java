package com.kos.showticat.VO;

import java.sql.Date;

public class ReviewVO {
	private int review_num;
	private String show_code;
	private String show_name;
	private String m_id;
	private String content;
	private String grade;
	private Date review_date;
	
	public ReviewVO() {	}

	public ReviewVO(int review_num, String show_code, String show_name, String m_id, String content, String grade,
			Date review_date) {
		super();
		this.review_num = review_num;
		this.show_code = show_code;
		this.show_name = show_name;
		this.m_id = m_id;
		this.content = content;
		this.grade = grade;
		this.review_date = review_date;
	}


	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getShow_code() {
		return show_code;
	}

	public void setShow_code(String show_code) {
		this.show_code = show_code;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	
	
}
