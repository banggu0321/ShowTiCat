package com.kos.showticat.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import com.kos.showticat.reservation.service.ScheduleService;
import com.kos.showticat.reservation.vo.MembersVO;
import com.kos.showticat.reservation.vo.ScheduleVO;

import oracle.sql.CHAR;

public class temp {

	public static void main(String[] args) {
		
		
		f2(); //1.������(��ȭ, ����, ��¥, �ð� ����)->������ �ѹ�(reservationNum, m_id, scheduleNum, reservationDate)&������(temp ��) 
		//2(������ update).�ο�(�¼�)����, �Ѻ��(������ѹ�-> ����, �ο� ����-> �� ���) 

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
		//(reservationNum, m_id, scheduleNum, reservationDate, �������� �ӽð�) reservation table insert �ϱ�
		
		int scheduleNum = 10;  //schedule ��ȣ ��������
		String m_id="cansu"; //m_id ��������
		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum));  //id�� ���� ������ ���ڷ� ��ȯ+"scheduleNumber"
		
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
