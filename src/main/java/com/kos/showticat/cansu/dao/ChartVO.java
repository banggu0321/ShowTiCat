package com.kos.showticat.cansu.dao;

public class ChartVO {
	
	private String showCode;
	private int rateW, rateM, rate10, rate20, rate30, rate40, rate50;
	
	public ChartVO() {
	}

	public ChartVO(String showCode, int rateW, int rateM, int rate10, int rate20, int rate30, int rate40, int rate50) {
		this.showCode = showCode;
		this.rateW = rateW;
		this.rateM = rateM;
		this.rate10 = rate10;
		this.rate20 = rate20;
		this.rate30 = rate30;
		this.rate40 = rate40;
		this.rate50 = rate50;
	}

	public String getShowCode() {
		return showCode;
	}

	public void setShowCode(String showCode) {
		this.showCode = showCode;
	}

	public int getRateW() {
		return rateW;
	}

	public void setRateW(int rateW) {
		this.rateW = rateW;
	}

	public int getRateM() {
		return rateM;
	}

	public void setRateM(int rateM) {
		this.rateM = rateM;
	}

	public int getRate10() {
		return rate10;
	}

	public void setRate10(int rate10) {
		this.rate10 = rate10;
	}

	public int getRate20() {
		return rate20;
	}

	public void setRate20(int rate20) {
		this.rate20 = rate20;
	}

	public int getRate30() {
		return rate30;
	}

	public void setRate30(int rate30) {
		this.rate30 = rate30;
	}

	public int getRate40() {
		return rate40;
	}

	public void setRate40(int rate40) {
		this.rate40 = rate40;
	}

	public int getRate50() {
		return rate50;
	}

	public void setRate50(int rate50) {
		this.rate50 = rate50;
	}

	@Override
	public String toString() {
		return "ChartVO [showCode=" + showCode + ", rateW=" + rateW + ", rateM=" + rateM + ", rate10=" + rate10
				+ ", rate20=" + rate20 + ", rate30=" + rate30 + ", rate40=" + rate40 + ", rate50=" + rate50 + "]";
	}	
}
