package com.kos.showticat.ja0;

import java.util.List;

import com.kos.showticat.VO.PlaceVO;

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
	
	//관심매장 조회
	public String selectMyPlace(String m_id) {
		return dao.selectMyPlace(m_id);
	}
}
