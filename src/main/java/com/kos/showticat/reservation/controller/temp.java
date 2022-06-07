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
		
//		f5();  //reservation table ��ȸ
		
//		f4(); //1~2: �ο��� ����
		
//		f3beta(); //reservation number�� ���� paymentYN update
//		f3(); 	//2(������ update).�ο�(�¼�)����, �Ѻ��(������ѹ�-> ����, �ο� ����-> �� ���) 
		
//		f2(); //1.������(��ȭ, ����, ��¥, �ð� ����)->������ �ѹ�(reservationNum, m_id, scheduleNum, reservationDate)&������(temp ��) �Է�-> ������_detail table �ش� row �Է�
	

//		f1();  //update point in members table, select members table
	}

	private static void f6() {
		
		int scheduleNum = 22;  //��Ģ�� ���� �ο�(��ȭ, �󿵰� ���)
		
		String showCode = "AA3"; //user ������ �޾Ƽ� ����
		String theaterNum = "B2"; //user ������ �޾Ƽ� ����
		int placeNum = 1002; //theater�� �����Ǹ鼭 ���� ����
		
		String showStartStr = "2022-06-07 16:16:00";  //�ð� ��¥ ������ �޾Ƽ� ����(DateTimeFormatter->LocalDateTime) 
													//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		
		ScheduleService service = new ScheduleService();
		service.insertScheduleInfor(scheduleNum, showCode, theaterNum, placeNum, showStartStr);
		
	}

	private static void f5() {
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //������ �����ȣ�� ?
		
		ScheduleService service = new ScheduleService();
		ReservationVO rvo = service.reservationSelectByNumber(reservationNum);
		System.out.println(rvo);
		
	}

	private static void f3beta() {
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //������ �����ȣ�� ?
		
		String yn="Y"; //check�� ���� Y or N ����
		
		ScheduleService service = new ScheduleService();
		service.updateReservationPaymentYN(yn, reservationNum);
		
	}

	private static void f4() {
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //������ �����ȣ�� ?
		
		String seatNumb = "11 12";  //�ڸ� ����
		int countSeat = seatNumb.trim().split(" ").length; //strip()������������(trim���� �پ��� �����ڵ� ���� ���� ����. 11v���� ����)
		ScheduleService service = new ScheduleService();
		service.updateReservationDetailInfor(seatNumb, reservationNum);
		
	}

	private static void f3() {
		
		String payment = "card"; //payment ��� ����
		int totalPrice = 1100;  //�ο��� ������  ���� �ݾ� ����(�¼� ������)
		
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //������ �����ȣ�� ?
		
		ScheduleService service = new ScheduleService();
		service.updateReservationInfor(payment, totalPrice, reservationNum);
		
	}

	private static void f2() {
		//(reservationNum, m_id, scheduleNum, reservationDate, �������� �ӽð�) reservation table insert �ϱ�
		
		int scheduleNum = 10;  //schedule ��ȣ ��������
		String m_id="cansu"; //m_id ��������
		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum));  //id�� ���� ������ ���ڷ� ��ȯ+"scheduleNumber"
		
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);
		service.insertReservationDetailInfor(reservationNum);  //reservation table�� row������ �ش��ϴ� reservation detail table���� ����
		
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
