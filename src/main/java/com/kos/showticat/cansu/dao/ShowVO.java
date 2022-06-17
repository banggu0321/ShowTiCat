package com.kos.showticat.cansu.dao;

public class ShowVO {
	private String showCode, showName, director, showTime, poster;

	public ShowVO() {
	}

	public ShowVO(String showCode, String showName, String director, String showTime, String poster) {
		this.showCode = showCode;
		this.showName = showName;
		this.director = director;
		this.showTime = showTime;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getShowCode() {
		return showCode;
	}

	public void setShowCode(String showCode) {
		this.showCode = showCode;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	@Override
	public String toString() {
		return "ShowVO [showCode=" + showCode + ", showName=" + showName + ", director=" + director + ", showTime="
				+ showTime + ", poster=" + poster + "]";
	}	
}
