package com.kos.showticat.reservation.service;

import java.util.List;

import com.kos.showticat.reservation.dao.temp.ScheduleDAO;
import com.kos.showticat.reservation.vo.ScheduleVO;

public class ScheduleService {
	
	ScheduleDAO scdao = new ScheduleDAO();
	
	public List<ScheduleVO> selectALL() {
		return scdao.selectALL();
	}

}
