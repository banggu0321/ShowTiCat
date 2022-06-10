package com.kos.showticat.jaeyong;

public class ReservationVO {

	private int RESERVATION_NUM;
	private String M_ID;
	private String RESERVATION_DATE;
	private int SCHEDULE_NUM;
	private String PAYMENT;
	private int TOTAL_PRICE;
	private String PAY_YN;
	
	public ReservationVO() {
		super();
	}

	public ReservationVO(int rESERVATION_NUM, String m_ID, String rESERVATION_DATE, int sCHEDULE_NUM, String pAYMENT,
			int tOTAL_PRICE, String pAY_YN) {
		super();
		RESERVATION_NUM = rESERVATION_NUM;
		M_ID = m_ID;
		RESERVATION_DATE = rESERVATION_DATE;
		SCHEDULE_NUM = sCHEDULE_NUM;
		PAYMENT = pAYMENT;
		TOTAL_PRICE = tOTAL_PRICE;
		PAY_YN = pAY_YN;
	}

	public int getRESERVATION_NUM() {
		return RESERVATION_NUM;
	}

	public void setRESERVATION_NUM(int rESERVATION_NUM) {
		RESERVATION_NUM = rESERVATION_NUM;
	}

	public String getM_ID() {
		return M_ID;
	}

	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}

	public String getRESERVATION_DATE() {
		return RESERVATION_DATE;
	}

	public void setRESERVATION_DATE(String rESERVATION_DATE) {
		RESERVATION_DATE = rESERVATION_DATE;
	}

	public int getSCHEDULE_NUM() {
		return SCHEDULE_NUM;
	}

	public void setSCHEDULE_NUM(int sCHEDULE_NUM) {
		SCHEDULE_NUM = sCHEDULE_NUM;
	}

	public String getPAYMENT() {
		return PAYMENT;
	}

	public void setPAYMENT(String pAYMENT) {
		PAYMENT = pAYMENT;
	}

	public int getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}

	public void setTOTAL_PRICE(int tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}

	public String getPAY_YN() {
		return PAY_YN;
	}

	public void setPAY_YN(String pAY_YN) {
		PAY_YN = pAY_YN;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservationDTO [RESERVATION_NUM=").append(RESERVATION_NUM).append(", M_ID=").append(M_ID)
				.append(", RESERVATION_DATE=").append(RESERVATION_DATE).append(", SCHEDULE_NUM=").append(SCHEDULE_NUM)
				.append(", PAYMENT=").append(PAYMENT).append(", TOTAL_PRICE=").append(TOTAL_PRICE).append(", PAY_YN=")
				.append(PAY_YN).append("]");
		return builder.toString();
	}
	
}






