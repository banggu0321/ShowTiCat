package com.kos.showticat.ja0;

import java.sql.Date;

public class DateVO {
	private Date sysdate;
	private Date sysdate_1;
	private Date sysdate_2;
	private Date sysdate_3;
	private Date sysdate_4;
	private Date sysdate_5;
	private Date sysdate_6;
	
	public DateVO() {}
	
	public DateVO(Date sysdate, Date sysdate_1, Date sysdate_2, Date sysdate_3, Date sysdate_4, Date sysdate_5,
			Date sysdate_6) {
		super();
		this.sysdate = sysdate;
		this.sysdate_1 = sysdate_1;
		this.sysdate_2 = sysdate_2;
		this.sysdate_3 = sysdate_3;
		this.sysdate_4 = sysdate_4;
		this.sysdate_5 = sysdate_5;
		this.sysdate_6 = sysdate_6;
	}

	public Date getSysdate() {
		return sysdate;
	}

	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}

	public Date getSysdate_1() {
		return sysdate_1;
	}

	public void setSysdate_1(Date sysdate_1) {
		this.sysdate_1 = sysdate_1;
	}

	public Date getSysdate_2() {
		return sysdate_2;
	}

	public void setSysdate_2(Date sysdate_2) {
		this.sysdate_2 = sysdate_2;
	}

	public Date getSysdate_3() {
		return sysdate_3;
	}

	public void setSysdate_3(Date sysdate_3) {
		this.sysdate_3 = sysdate_3;
	}

	public Date getSysdate_4() {
		return sysdate_4;
	}

	public void setSysdate_4(Date sysdate_4) {
		this.sysdate_4 = sysdate_4;
	}

	public Date getSysdate_5() {
		return sysdate_5;
	}

	public void setSysdate_5(Date sysdate_5) {
		this.sysdate_5 = sysdate_5;
	}

	public Date getSysdate_6() {
		return sysdate_6;
	}

	public void setSysdate_6(Date sysdate_6) {
		this.sysdate_6 = sysdate_6;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DateVO [sysdate=").append(sysdate).append(", sysdate_1=").append(sysdate_1)
				.append(", sysdate_2=").append(sysdate_2).append(", sysdate_3=").append(sysdate_3)
				.append(", sysdate_4=").append(sysdate_4).append(", sysdate_5=").append(sysdate_5)
				.append(", sysdate_6=").append(sysdate_6).append("]");
		return builder.toString();
	}
	
	
}
