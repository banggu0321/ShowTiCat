package com.kos.showticat.ja0;

import java.util.List;

import com.kos.showticat.VO.ReservationVO;

public class ReservationService {
	ReservationDAO dao = new ReservationDAO();
	//예약목록
	public List<ReservationVO> selectAll(String m_id) {
		return dao.selectAll(m_id);
	}
}
