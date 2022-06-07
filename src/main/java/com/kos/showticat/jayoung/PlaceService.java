package com.kos.showticat.jayoung;

import java.util.List;

public class PlaceService {
	PlaceDAO dao = new PlaceDAO();
	
	//극장 전체조회
	public List<PlaceVO> selectAll() {
		return dao.selectAll();
	}
	
	//극장 조회
	public PlaceVO selectByNum(int place_num) {
		return dao.selectByNum(place_num);
	}
}
