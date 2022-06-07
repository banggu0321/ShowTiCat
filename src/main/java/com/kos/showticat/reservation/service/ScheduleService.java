package com.kos.showticat.reservation.service;

import java.util.List;

import com.kos.showticat.reservation.dao.temp.ScheduleDAO;
import com.kos.showticat.reservation.vo.MembersVO;
import com.kos.showticat.reservation.vo.ScheduleVO;

public class ScheduleService {
	
	ScheduleDAO scdao = new ScheduleDAO();
	
	public void insertReservationInfor(int reserNum, String mID, int schedNum) {
		scdao.insertReservationInfor(reserNum, mID, schedNum);
	}
	
	public void updatePointMembers(String id, String pw, int point) {
		scdao.updatePointMembers(id, pw, point);
	}
	
	public List<ScheduleVO> selectALL() {
		return scdao.selectALL();
	}
	
	public List<MembersVO> selectALLMembers(){
		return scdao.selectALLMembers();
	}

}
