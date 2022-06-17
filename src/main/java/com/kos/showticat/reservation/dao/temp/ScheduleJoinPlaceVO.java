package com.kos.showticat.reservation.dao.temp;

public class ScheduleJoinPlaceVO {
	
	private String showCode, theaterNum, showStart, placeName, placeLoc, placePhone;
	private int placeNum, scheduleNum;
	public ScheduleJoinPlaceVO() {
	}
	public ScheduleJoinPlaceVO(String showCode, String theaterNum, String showStart, String placeName, String placeLoc,
			String placePhone, int placeNum, int scheduleNum) {
		this.showCode = showCode;
		this.theaterNum = theaterNum;
		this.showStart = showStart;
		this.placeName = placeName;
		this.placeLoc = placeLoc;
		this.placePhone = placePhone;
		this.placeNum = placeNum;
		this.scheduleNum = scheduleNum;
	}
	@Override
	public String toString() {
		return "ScheduleJoinPlaceVO [showCode=" + showCode + ", theaterNum=" + theaterNum + ", showStart=" + showStart
				+ ", placeName=" + placeName + ", placeLoc=" + placeLoc + ", placePhone=" + placePhone + ", placeNum="
				+ placeNum + ", scheduleNum=" + scheduleNum + "]";
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
	public String getShowStart() {
		return showStart;
	}
	public void setShowStart(String showStart) {
		this.showStart = showStart;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceLoc() {
		return placeLoc;
	}
	public void setPlaceLoc(String placeLoc) {
		this.placeLoc = placeLoc;
	}
	public String getPlacePhone() {
		return placePhone;
	}
	public void setPlacePhone(String placePhone) {
		this.placePhone = placePhone;
	}
	public int getPlaceNum() {
		return placeNum;
	}
	public void setPlaceNum(int placeNum) {
		this.placeNum = placeNum;
	}
	public int getScheduleNum() {
		return scheduleNum;
	}
	public void setScheduleNum(int scheduleNum) {
		this.scheduleNum = scheduleNum;
	}	
}
