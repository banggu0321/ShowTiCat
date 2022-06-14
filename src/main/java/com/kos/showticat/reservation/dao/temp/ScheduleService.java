package com.kos.showticat.reservation.dao.temp;

import java.sql.Date;
import java.util.List;

import com.kos.showticat.reservation.dao.temp.ScheduleDAO;
import com.kos.showticat.reservation.dao.temp.MembersVO;
import com.kos.showticat.reservation.dao.temp.ReservationVO;
import com.kos.showticat.reservation.dao.temp.ScheduleVO;

public class ScheduleService {

	ScheduleDAO scdao = new ScheduleDAO();
	
	public ScheduleVO selectScheduleByScheduleNumBeta(int scheduleNum) {
		return scdao.selectScheduleByScheduleNumBeta(scheduleNum);
	}

	public ShowVO selectShowByShowcode(String showCode) {
		return scdao.selectShowByShowcode(showCode);
	}
	
	public void updateReservationPaymentByResNum(String payment, int reservationNum) {
		scdao.updateReservationPaymentByResNum(payment, reservationNum);
	}
	
	public void updateReservationByReserveNum(int totalPrice, int reservationNum) {
		scdao.updateReservationByReserveNum(totalPrice, reservationNum);
	}
	
	public void updateScheduleByScheduleNum(String theaterNum, int placeNum, String showStart, int scheduleNum) {
		scdao.updateScheduleByScheduleNum(theaterNum, placeNum, showStart, scheduleNum);
	}
	
	public List<ScheduleVO> selectScheduleByShowcode(String showCode){
		return scdao.selectScheduleByShowcode(showCode);
	}
	
	public List<ChartVO> selectChartShowCode(){
		return scdao.selectChartShowCode();
	}
	
	public int selectMembersPointByID(String mID) {
		return scdao.selectMembersPointByID(mID);
	}
	
	public String selectReservationUserIDByReservationNum(int reservationNum) {
		return scdao.selectReservationUserIDByReservationNum(reservationNum);
	}
	
	public void updateChartGenderWByCheck(int rate, String showCode) {
		scdao.updateChartGenderWByCheck(rate, showCode);
	}
	
	public void updateChartGenderMByCheck(int rate,String showCode) {
		scdao.updateChartGenderMByCheck(rate, showCode);
	}
	
	public List<String> selectChartByShowCode(String showCode) {
		return scdao.selectChartByShowCode(showCode);
	}
	
	public String selectMemberByID(String mID) {
		return scdao.selectMemberByID(mID);
	}
	
	public int selectReservationByReservationNum(int reservationNum) {
		return scdao.selectReservationByReservationNum(reservationNum);
	}
	
	public int selectShowByShowCode(String showCode) {
		return scdao.selectShowByShowCode(showCode);
	}
	
	public String selectScheduleByScheduleNum(int scheduleNumber) {
		return scdao.selectScheduleByScheduleNum(scheduleNumber);
	}
	
	public void updateScheduleShowstart(Date showStart, int scheduleNum) {
		scdao.updateScheduleShowstart(showStart, scheduleNum);
	}
	
	public void updateScheduleTheaterPlacenum(String theaterNum, int placeNum, int schedulNum) {
		scdao.updateScheduleTheaterPlacenum(theaterNum, placeNum, schedulNum);
	}
	
	public int selectPlaceByTheaterNum(String theaterNum) {
		return scdao.selectPlaceByTheaterNum(theaterNum);
	}

	public void insertScheduleInforNum(int scheduleNum, String showCode) {
		scdao.insertScheduleInforNum(scheduleNum, showCode);
	}

	public List<TheaterVO> selectTheaterByPlaceNum(int placeNum){
		return scdao.selectTheaterByPlaceNum(placeNum);
	}

	public List<TheaterVO> selectAllTheater(){
		return scdao.selectAllTheater();
	}

	public List<PlaceVO> selectALLPlace() {
		return scdao.selectALLPlace();
	}

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

	public void updatePointMembers(String id, int point) {
		scdao.updatePointMembers(id, point);
	}

	public List<ScheduleVO> selectALL() {
		return scdao.selectALL();
	}

	public List<MembersVO> selectALLMembers(){
		return scdao.selectALLMembers();
	}

}
