package com.kos.showticat.cansu.dao;

public class MembersVO {
	private String mID, mPW, mName, email, phone, birth, gender, mDate, point, placeNum;

	public MembersVO() {
	}

	public MembersVO(String mID, String mPW, String mName, String email, String phone, String birth, String gender,
			String mDate, String point, String placeNum) {
		this.mID = mID;
		this.mPW = mPW;
		this.mName = mName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.mDate = mDate;
		this.point = point;
		this.placeNum = placeNum;
	}

	public String getmID() {
		return mID;
	}

	public void setmID(String mID) {
		this.mID = mID;
	}

	public String getmPW() {
		return mPW;
	}

	public void setmPW(String mPW) {
		this.mPW = mPW;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getPlaceNum() {
		return placeNum;
	}

	public void setPlaceNum(String placeNum) {
		this.placeNum = placeNum;
	}

	@Override
	public String toString() {
		return "MembersVO [mID=" + mID + ", mPW=" + mPW + ", mName=" + mName + ", email=" + email + ", phone=" + phone
				+ ", birth=" + birth + ", gender=" + gender + ", mDate=" + mDate + ", point=" + point + ", placeNum="
				+ placeNum + "]";
	}
}
