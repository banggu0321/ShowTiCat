package com.kos.showticat.mypage.confirm;

import java.util.List;

import com.kos.showticat.mypage.confirm.vo.ConfirmVO;
import com.kos.showticat.mypage.confirm.vo.ReservDetailVO;

public class ConfirmService {
	ConfirmDAO confirmDAO = new ConfirmDAO();

	// 1. 예매내역
	// 1-1-1 전체
	public List<ConfirmVO> selectAllReservation(String m_id) {
		return confirmDAO.selectAllReservation(m_id);
	}

	// 1-1-2 Detail RESERVATION_NUM
	public ConfirmVO selectDetailReservation(int reservation_num) {
		return confirmDAO.selectDetailReservation(reservation_num);
	}

	// 1-2. pay Y
	public List<ConfirmVO> selectPayYReservation(String m_id) {
		return confirmDAO.selectPayYReservation(m_id);
	}

	// 1-3. pay N
	public List<ConfirmVO> selectPayNReservation(String m_id) {
		return confirmDAO.selectPayNReservation(m_id);
	}

	// 1-4. 자리확인
	public List<ReservDetailVO> selectSeatNum(int reservation_num) {
		return confirmDAO.selectSeatNum(reservation_num);
	}

	// 2. 예매취소
	// 2-1. 공연 - 취소가능한 날짜인지 확인 (해당 sc.num -> sc.showstart)
	public int CheckShowReservation(int reservation_num) {
		return confirmDAO.CheckShowReservation(reservation_num);
	}

	// 2-2. 영화 - 취소가능한 날짜인지 확인 (해당 sc.num -> sc.showstart)
	public int CheckMovieReservation(int reservation_num) {
		return confirmDAO.CheckMovieReservation(reservation_num);
	}

	// 2-3. 취소하기(pay_y->n으로 변경)
	public int updateReservation(int reservation_num) {
		return confirmDAO.updateReservation(reservation_num);
	}

	// 2-4. rd 모두삭제SQL_DELETE_SEAT
	public int DeleteSeat(int reservation_num) {
		return confirmDAO.DeleteSeat(reservation_num);
	}
}
