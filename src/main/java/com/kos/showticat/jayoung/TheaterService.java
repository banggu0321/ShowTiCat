package com.kos.showticat.jayoung;

import java.util.List;

public class TheaterService {
	TheaterDAO dao = new TheaterDAO();
	
	//극장별 스케줄 조회
	public List<TheaterVO> selectByPlace(int place_num) {
		return dao.selectByPlace(place_num);
	}
}
