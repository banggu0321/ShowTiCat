package com.kos.showticat.admin;

import java.util.List;

import com.kos.showticat.admin.vo.ShowVO;

public class ShowService {
	ShowDAO showDAO = new ShowDAO();

	// 1. 모든 스케줄 조회
	public List<ShowVO> selectAllShow() {
		return showDAO.selectAllShow();
	}

	// 2-2. 스케줄 추가
	public int insertShow(ShowVO sc) {
		return showDAO.insertShow(sc);
	}
	
	
/*	
	// 3. 공연 수정
	public int updateShow(ShowVO sc){
		return 0;
	}
	// 4. 공연 삭제
	// 4-1. 해당 공연의 판매 횟수 조회 (조건조회)
	public int selectBuyShow() {
		return 0;
	}

	// 4-2. 공연 삭제
	public int deleteShow(int show_code) {
		return scheduleDAO.deleteSchedule(schedule_num);
	}
	*/
}
