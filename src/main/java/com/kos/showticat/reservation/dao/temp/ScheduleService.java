package com.kos.showticat.reservation.dao.temp;

import java.util.List;

import com.kos.showticat.reservation.dao.temp.ScheduleDAO;
import com.kos.showticat.reservation.dao.temp.MembersVO;
import com.kos.showticat.reservation.dao.temp.ReservationVO;
import com.kos.showticat.reservation.dao.temp.ScheduleVO;

public class ScheduleService {
	
	ScheduleDAO scdao = new ScheduleDAO();
	
	public void insertScheduleInfor(int scheduleNum, String showCode, String theaterNum, int placeNum, String showStart) {
		scdao.insertScheduleInfor(scheduleNum, showCode, theaterNum, placeNum, showStart);
	}
	
	public ReservationVO reservationSelectByNumber(int reservatioNum) {
		return scdao.reservationSelectByNumber(reservatioNum);
	}
	
	public void updateReservationPaymentYN(String paymentYN, int reservatioNum) {
		scdao.updateReservationPaymentYN(paymentYN, reservatioNum);
	}
	
	public void updateReservationDetailInfor(String seatNum, int reservationNum) {
		scdao.updateReservationDetailInfor(seatNum, reservationNum);
	}
	
	public void insertReservationDetailInfor(int reserNum, String seatNumb) {
		scdao.insertReservationDetailInfor(reserNum,seatNumb);
	}
	
	public void updateReservationInfor(String payment, int totalPrice, int reservationNum) {
		scdao.updateReservationInfor(payment, totalPrice,reservationNum);
	}
	
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
