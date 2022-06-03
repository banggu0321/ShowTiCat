package com.kos.showticat.reservation.vo;

public class ScheduleVO {
	private String showCode, theaterNum, placeNum, showStart, scheduleNum;

	public ScheduleVO() {
	}

	public ScheduleVO(String showCode, String theaterNum, String placeNum, String showStart, String scheduleNum) {
		this.showCode = showCode;
		this.theaterNum = theaterNum;
		this.placeNum = placeNum;
		this.showStart = showStart;
		this.scheduleNum = scheduleNum;
	}


	public String getShowCode() {
		return showCode;
	}

	public void setShowCode(String showCode) {
		this.showCode = showCode;
	}

	public String getTheaterNum() {
		return theaterNum;
	}

	public void setTheaterNum(String theaterNum) {
		this.theaterNum = theaterNum;
	}

	public String getPlaceNum() {
		return placeNum;
	}

	public void setPlaceNum(String placeNum) {
		this.placeNum = placeNum;
	}

	public String getShowStart() {
		return showStart;
	}

	public void setShowStart(String showStart) {
		this.showStart = showStart;
	}

	public String getScheduleNum() {
		return scheduleNum;
	}

	public void setScheduleNum(String scheduleNum) {
		this.scheduleNum = scheduleNum;
	}

	@Override
	public String toString() {
		return "ScheduleVO [showCode=" + showCode + ", theaterNum=" + theaterNum + ", placeNum=" + placeNum
				+ ", showStart=" + showStart + ", scheduleNum=" + scheduleNum + "]";
	}
	
	
}
