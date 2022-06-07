package com.kos.showticat.jayoung;

import java.util.List;

public class ScheduleService {
	ScheduleDAO dao = new ScheduleDAO();
	
	//? „ì²? ?Š¤ì¼?ì¤? ì¡°íšŒ
	public List<ScheduleVO> selectAll() {
		return dao.selectAll();
	}
	
	//ê·¹ìž¥ë³„ë¡œ ì¡°íšŒ
	public List<ScheduleVO> selectByPlace(int place_num,String show_code) {
		return dao.selectByPlace(place_num,show_code);
	}
}
