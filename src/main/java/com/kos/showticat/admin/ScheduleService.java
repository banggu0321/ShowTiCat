package com.kos.showticat.admin;

import java.util.List;

import com.kos.showticat.admin.vo.PlaceVO;
import com.kos.showticat.admin.vo.ScheduleShowVO;
import com.kos.showticat.admin.vo.ScheduleVO;
import com.kos.showticat.admin.vo.ShowVO;
import com.kos.showticat.admin.vo.TheaterVO;

public class ScheduleService {
	ScheduleDAO scheduleDAO = new ScheduleDAO();

	// 1. 모든 스케줄 조회
	public List<ScheduleShowVO> selectAllSchedule() {
		return scheduleDAO.selectAllSchedule();
	}

	// 2. 스케줄 추가
	// 2-1. 스케줄 추가 form보여주기
	// 2-1-1 show 제목 + show 번호
	public List<ShowVO> selectShowInsertSchedule() {
		return scheduleDAO.selectShowInsertSchedule();

	}

	// 2-1-2 극장이름 + 극장번호
	public List<PlaceVO> selectPlaceInsertSchedule() {
		return scheduleDAO.selectPlaceInsertSchedule();
	}

	// 2-1-3 상영관번호
	public List<TheaterVO> selectTheaterInsertSchedule(int place_num) {
		return scheduleDAO.selectTheaterInsertSchedule(place_num);
	}

	// 2-2. 스케줄 추가
	public int insertSchedule(ScheduleVO sc) {
		return scheduleDAO.insertSchedule(sc);
	}

	// 3. 스케줄 삭제
	// 3-1. 해당 스케줄의 판매 횟수 조회 (조건조회)
	public int selectBuySchedule(int schedule_num) {
		return scheduleDAO.selectBuySchedule(schedule_num);
	}

	// 3-2. 스케줄 삭제
	public int deleteSchedule(int schedule_num) {
		return scheduleDAO.deleteSchedule(schedule_num);
	}
}
