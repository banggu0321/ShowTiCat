package com.kos.showticat.reservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kos.showticat.reservation.dao.temp.ScheduleService;
import com.kos.showticat.reservation.dao.temp.MembersVO;
import com.kos.showticat.reservation.dao.temp.ReservationVO;
import com.kos.showticat.reservation.dao.temp.ScheduleVO;

import oracle.sql.CHAR;

public class temp {

	public static void main(String[] args) {
		
		f6(); //schedule table insert row
		
//		f5();  //reservation table 조회
		
//		f4(); //1~2: 인원수 선택
		
//		f3beta(); //reservation number에 따른 paymentYN update
//		f3(); 	//2(나머지 update).인원(좌석)선택, 총비용(스케쥴넘버-> 가격, 인원 선택-> 총 비용) 
		
//		f2(); //1.스케쥴(영화, 극장, 날짜, 시간 선택)->스케쥴 넘버(reservationNum, m_id, scheduleNum, reservationDate)&나머지(temp 값) 입력-> 스케쥴_detail table 해당 row 입력
	

//		f1();  //update point in members table, select members table
	}

	private static void f6() {
		
		int scheduleNum = 22;  //규칙에 따라 부여(영화, 상영관 고려)
		
		String showCode = "AA3"; //user 선택을 받아서 결정
		String theaterNum = "B2"; //user 선택을 받아서 결정
		int placeNum = 1002; //theater가 결정되면서 따라서 결정
		
		String showStartStr = "2022-06-07 16:16:00";  //시간 날짜 선택을 받아서 결정(DateTimeFormatter->LocalDateTime) 
													//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		
		ScheduleService service = new ScheduleService();
		service.insertScheduleInfor(scheduleNum, showCode, theaterNum, placeNum, showStartStr);
		
	}

	private static void f5() {
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //생성된 예약번호을 ?
		
		ScheduleService service = new ScheduleService();
		ReservationVO rvo = service.reservationSelectByNumber(reservationNum);
		System.out.println(rvo);
		
	}

	private static void f3beta() {
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //생성된 예약번호을 ?
		
		String yn="Y"; //check를 통해 Y or N 결정
		
		ScheduleService service = new ScheduleService();
		service.updateReservationPaymentYN(yn, reservationNum);
		
	}

	private static void f4() {
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //생성된 예약번호을 ?
		
		String seatNumb = "11 12";  //자리 선택
		int countSeat = seatNumb.trim().split(" ").length; //strip()양측공백제거(trim보다 다양한 유니코드 공백 제거 가능. 11v에서 제공)
		ScheduleService service = new ScheduleService();
		service.updateReservationDetailInfor(seatNumb, reservationNum);
		
	}

	private static void f3() {
		
		String payment = "card"; //payment 방식 선택
		int totalPrice = 1100;  //인원수 결정후  최종 금액 결정(좌석 선택후)
		
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //생성된 예약번호을 ?
		
		ScheduleService service = new ScheduleService();
		service.updateReservationInfor(payment, totalPrice, reservationNum);
		
	}

	private static void f2() {
		//(reservationNum, m_id, scheduleNum, reservationDate, 나머지는 임시값) reservation table insert 하기
		
		int scheduleNum = 10;  //schedule 번호 가져오기
		String m_id="cansu"; //m_id 가져오기
		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum));  //id에 따라 일정한 숫자로 변환+"scheduleNumber"
		
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);
		service.insertReservationDetailInfor(reservationNum);  //reservation table에 row생성후 해당하는 reservation detail table에도 생성
		
	}
	
	private static String eachChartoString(String name, int number) {
		
		char[] temp = name.toCharArray();
		String result = "";
		for(char ch: temp) {
			result += (int)ch;
		}
		
		return result.substring(0, 6)+Integer.toString(number);
	}

	private static void f1() {
		ScheduleService service = new ScheduleService();
		
		//update point
		String id = "cansu";
		String pw = "2022";
		int point = 440;
		service.updatePointMembers(id, pw, point);
		
//		//select member table
//		List<MembersVO> list = new ArrayList<>();
//		list = service.selectALLMembers();
//		
//		for(MembersVO arr: list) {
//			System.out.println(arr);
//		}
	}

}
