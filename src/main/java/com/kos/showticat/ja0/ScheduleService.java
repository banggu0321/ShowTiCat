package com.kos.showticat.ja0;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.kos.showticat.VO.ScheduleVO;

public class ScheduleService {
	ScheduleDAO dao = new ScheduleDAO();
	
	//전체 스케줄 조회
	public List<ScheduleVO> selectAll() {
		return dao.selectAll();
	}
	
	//극장별로 조회
	public List<ScheduleVO> selectByPlace(int place_num) {
		return dao.selectByPlace(place_num);
	}
	
	//영화별로 조회
	public List<ScheduleVO> selectByShow(int place_num, String show_code) {
		return dao.selectByShow(place_num, show_code);
	}

	//상영관별로 조회
	public List<ScheduleVO> selectByTheater(int place_num, Date show_date) {
		return dao.selectByTheater(place_num , show_date);
	}
	
	//상영관별로 조회(오늘)
	public List<ScheduleVO> selectByIfSysdate(int place_num) {
		return dao.selectByIfSysdate(place_num);
	}
	
	//상영관, 영화별로 조회
	public List<ScheduleVO> selectShow(int place_num , Date show_date, String show_code) {
		return dao.selectShow(place_num, show_date, show_code);
	}
	
	//상영관, 영화별로 조회(오늘)
	public List<ScheduleVO> selectShowIfSysdate(int place_num, String show_code) {
		return dao.selectShowIfSysdate(place_num, show_code);
	}
	
	//예약된 좌석
	public Map<Integer, Integer> reservCnt(int place_num) {
		return dao.reservCnt(place_num);
	}
}
