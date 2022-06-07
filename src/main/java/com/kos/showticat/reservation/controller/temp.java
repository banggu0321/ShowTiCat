package com.kos.showticat.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.reservation.service.ScheduleService;
import com.kos.showticat.reservation.vo.MembersVO;
import com.kos.showticat.reservation.vo.ScheduleVO;

import oracle.sql.CHAR;

public class temp {

	public static void main(String[] args) {
		
		
		f2(); //1.스케쥴(영화, 극장, 날짜, 시간 선택)->스케쥴 넘버(reservationNum, m_id, scheduleNum, reservationDate)&나머지(temp 값) 
		//2(나머지 update).인원(좌석)선택, 총비용(스케쥴넘버-> 가격, 인원 선택-> 총 비용) 

//		f1();  //update point in members table, select members table
	}

	private static String eachChartoString(String name, int number) {
				
		char[] temp = name.toCharArray();
		String result = "";
		for(char ch: temp) {
			result += (int)ch;
		}
		
		return result.substring(0, 3)+Integer.toString(number);
	}

	private static void f2() {
		//(reservationNum, m_id, scheduleNum, reservationDate, 나머지는 임시값) reservation table insert 하기
		
		int scheduleNum = 10;  //schedule 번호 가져오기
		String m_id="cansu"; //m_id 가져오기
		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum));  //id에 따라 일정한 숫자로 변환+"scheduleNumber"
		
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);
		
	}

	private static void f1() {
		ScheduleService service = new ScheduleService();
		
		//update point
		String id = "cansu";
		String pw = "2022";
		int point = 440;
		service.updatePointMembers(id, pw, point);
		
		//select member table
		List<MembersVO> list = new ArrayList<>();
		list = service.selectALLMembers();
		
		for(MembersVO arr: list) {
			System.out.println(arr);
		}
	}

}
