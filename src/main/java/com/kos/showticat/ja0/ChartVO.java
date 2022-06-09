package com.kos.showticat.ja0;

public class ChartVO {
	private String show_code;
	private int rate_m;
	private int rate_w;
	private int rate_10;
	private int rate_20;
	private int rate_30;
	private int rate_40;
	private int rate_50;
	
	public ChartVO() {}
	
	public ChartVO(String show_code, int rate_m, int rate_w, int rate_10, int rate_20, int rate_30, int rate_40,
			int rate_50) {
		super();
		this.show_code = show_code;
		this.rate_m = rate_m;
		this.rate_w = rate_w;
		this.rate_10 = rate_10;
		this.rate_20 = rate_20;
		this.rate_30 = rate_30;
		this.rate_40 = rate_40;
		this.rate_50 = rate_50;
	}

	public String getShow_code() {
		return show_code;
	}

	public void setShow_code(String show_code) {
		this.show_code = show_code;
	}

	public int getRate_m() {
		return rate_m;
	}

	public void setRate_m(int rate_m) {
		this.rate_m = rate_m;
	}

	public int getRate_w() {
		return rate_w;
	}

	public void setRate_w(int rate_w) {
		this.rate_w = rate_w;
	}

	public int getRate_10() {
		return rate_10;
	}

	public void setRate_10(int rate_10) {
		this.rate_10 = rate_10;
	}

	public int getRate_20() {
		return rate_20;
	}

	public void setRate_20(int rate_20) {
		this.rate_20 = rate_20;
	}

	public int getRate_30() {
		return rate_30;
	}

	public void setRate_30(int rate_30) {
		this.rate_30 = rate_30;
	}

	public int getRate_40() {
		return rate_40;
	}

	public void setRate_40(int rate_40) {
		this.rate_40 = rate_40;
	}

	public int getRate_50() {
		return rate_50;
	}

	public void setRate_50(int rate_50) {
		this.rate_50 = rate_50;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChartVO [show_code=").append(show_code).append(", rate_m=").append(rate_m).append(", rate_w=")
				.append(rate_w).append(", rate_10=").append(rate_10).append(", rate_20=").append(rate_20)
				.append(", rate_30=").append(rate_30).append(", rate_40=").append(rate_40).append(", rate_50=")
				.append(rate_50).append("]");
		return builder.toString();
	}
}
