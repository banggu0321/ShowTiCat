package com.kos.showticat.jayoung;

public class ChartService {
	ChartDAO dao = new ChartDAO();
	
	//차트 정보 가져오기
	public ChartVO selectShow(String show_code) {
		return dao.selectShow(show_code);
	}
}
