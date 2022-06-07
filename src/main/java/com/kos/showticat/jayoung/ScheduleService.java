package com.kos.showticat.jayoung;

import java.util.List;

public class ScheduleService {
	ScheduleDAO dao = new ScheduleDAO();
	
	//전체 스케줄 조회
	public List<ScheduleVO> selectAll() {
		return dao.selectAll();
	}
	
	//극장별로 조회
	public List<ScheduleVO> selectByPlace(int place_num,String show_code) {
		return dao.selectByPlace(place_num,show_code);
	}
}
