package com.kos.showticat.main.vo;

import java.sql.Date;

public class ShowVO {
	private String show_code;
	private String show_name;
	private String director;
	private String trailer;
	private Date opening_date;
	private int show_time;
	private String category;
	private String summary;
	private String poster;
	private int price;

	public ShowVO() {
	}
	public ShowVO(String show_code, String show_name, String poster) {
		this.show_code = show_code;
		this.show_name = show_name;
		this.poster = poster;
	}
	public ShowVO(String show_code, String show_name, String director, String trailer, Date opening_date, int show_time,
			String category, String summary, String poster, int price) {
		super();
		this.show_code = show_code;
		this.show_name = show_name;
		this.director = director;
		this.trailer = trailer;
		this.opening_date = opening_date;
		this.show_time = show_time;
		this.category = category;
		this.summary = summary;
		this.poster = poster;
		this.price = price;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public Date getOpening_date() {
		return opening_date;
	}

	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}

	public int getShow_time() {
		return show_time;
	}

	public void setShow_time(int show_time) {
		this.show_time = show_time;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShowVO [show_code=").append(show_code).append(", show_name=").append(show_name)
				.append(", director=").append(director).append(", trailer=").append(trailer).append(", opening_date=")
				.append(opening_date).append(", show_time=").append(show_time).append(", category=").append(category)
				.append(", summary=").append(summary).append(", poster=").append(poster).append(", price=")
				.append(price).append("]");
		return builder.toString();
	}


	
	
}
