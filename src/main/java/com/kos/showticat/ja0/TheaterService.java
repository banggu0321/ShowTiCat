package com.kos.showticat.ja0;

import java.util.List;

import com.kos.showticat.VO.TheaterVO;

public class TheaterService {
	TheaterDAO dao = new TheaterDAO();
	
	//극장별 스케줄 조회
	public List<TheaterVO> selectByPlace(int place_num) {
		return dao.selectByPlace(place_num);
	}
}
