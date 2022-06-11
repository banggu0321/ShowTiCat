package com.kos.showticat.reservation.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.kos.showticat.reservation.dao.temp.ScheduleService;
import com.kos.showticat.reservation.dao.temp.ChartVO;
import com.kos.showticat.reservation.dao.temp.MembersVO;
import com.kos.showticat.reservation.dao.temp.PlaceVO;
import com.kos.showticat.reservation.dao.temp.ReservationVO;
import com.kos.showticat.reservation.dao.temp.ScheduleVO;
import com.kos.showticat.reservation.dao.temp.TheaterVO;

//import oracle.sql.CHAR;

public class temp {

	public static void main(String[] args) {
		
//		f9(); //theater select by place number
//		f8(); //theater table select all
//		f7();  //place talbe select all
		
//		f6(); //schedule table insert row
//		f5();  //reservation table ��ȸ
//		f4(); //1~2: �ο��� ����(����)
//		f3beta(); //reservation number�� ���� paymentYN update
//		f3(); 	//2(������ update).�ο�(�¼�)����, �Ѻ��(������ѹ�-> ����, �ο� ����-> �� ���) 
//		f2(); //reservation table�� (������ �ѹ��� reservation date�� ���� ����), ������(�ӽ� ��) & reservation detail table�� �ش��ϴ� row �ۼ�
		//1.[������(��ȭ, ����, ��¥, �ð� ����)->] ������ �ѹ�(reservationNum, m_id, scheduleNum, reservationDate)&������(temp ��) �Է�-> ������_detail table �ش� row �Է�
	

//		f1();  //update point in members table, select members table
		
//		f15(); //reservation table select schedule number
//		f14(); //show table select price
//		f13(); //schedule table select show_code
//		f12(); //schedule table create(3. update showTime)
//		f11();  //schedule table create(2. update theater)
//		f10();  //schedule table create(1. insert schedule number and show code)
		
//		f16();  //member table select gender
//		f17(); //reservation table select schedule number
//		f18(); //schedule table select show code
//		f19(); //chart table update (rate_M or rate_W)
//		f19beta(); //chart table select rate_m and rate_w
//		f20();  //reservation table select ID		
		f21();  //chart table select show_code
	}

	private static void f21() {
		List<ChartVO> temp = new ArrayList<>();
		
		ScheduleService service = new ScheduleService();
		temp = service.selectChartShowCode();
		
		for(ChartVO arr: temp) {
			System.out.println(arr);
			if(arr.getShowCode().equals("AA7")) {
				System.out.println("select AA7");
			}
		}		
	}

	private static void f20() {
		
		int reservationNum = 2; //reservation number �޾ƿ���
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectReservationUserIDByReservationNum(reservationNum));
	}

	private static void f19() {
		
		String gender = "W"; //select�� gender �޾ƿ���
		
		List<String> rateWM = new ArrayList<>();
		String showCode="BB34"; //select�� showcode �޾ƿ���
		
		ScheduleService service = new ScheduleService();
		rateWM = service.selectChartByShowCode(showCode);
		
		int rate = 0;  //gender�� ���� �ʱⰪ ����
		if(gender.equals("W")) {
			rate = Integer.parseInt(rateWM.get(0));			
		}else if(gender.equals("M")) {
			rate = Integer.parseInt(rateWM.get(1));	
		}
		//updateChartGenderWByCheck
		
		if(gender.equals("W")) {
			service.updateChartGenderWByCheck(rate+1, showCode);		
		}else if(gender.equals("M")) {
			service.updateChartGenderMByCheck(rate+1, showCode);
		}
	}

	private static void f19beta() {
		
		List<String> rateWM = new ArrayList<>();
		String showCode="BB34"; //select�� showcode �޾ƿ���
		
		ScheduleService service = new ScheduleService();
		rateWM = service.selectChartByShowCode(showCode);
		
		for(String arr: rateWM) {
			System.out.println(arr);
		}
	}

	private static void f18() {
		
		int scheduleNum = 16; //select�� schedule number ��������
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectScheduleByScheduleNum(scheduleNum));
	}


	private static void f17() {
		
		int reservationNum = 469540; //session�� ����� reservation number ��������
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectReservationByReservationNum(reservationNum));
	}


	private static void f16() {

		String mID = "yong";  //session�� ����� member obj���� m_id ��������
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectMemberByID(mID));
	}


	private static void f15() {
		int reservationNum = 469421;
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectReservationByReservationNum(reservationNum));
	}


	private static void f14() {
		String showCode = "AA23";
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectShowByShowCode(showCode));
	}


	private static void f13() {
		
		int scheduleNum = 10; //����� schedule number ��������
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectScheduleByScheduleNum(scheduleNum));
	}


	private static void f12() {
		int scheduleNum = 711691055; //������ schedule number �ҷ�����(session �� �����ϰ� �ҷ�����)

		String startShow = "2022-06-09 10:10:00";  //user�� �ð��� ����
		
		//string -> timestamp -> date
		Timestamp sStart = Timestamp.valueOf(startShow);
		Date sDate = new Date(sStart.getTime());
		
		ScheduleService service = new ScheduleService();
		service.updateScheduleShowstart(sDate, scheduleNum);
	}
	private Date stringToDate(String myDate, String myTime) {  //dateSampleServlet���� ���
		
		String timeTemp = myTime+":00";
//		System.out.println(timeTemp);

		
		String showStart = myDate+" "+timeTemp;
		Timestamp temp = Timestamp.valueOf(showStart);

		Date result=new Date(temp.getTime());
		return result;
	}

	private static void f11() {
		
		int scheduleNum = 711691055; //������ schedule number �ҷ�����(session �� �����ϰ� �ҷ�����)

		String theaterNum = "D2"; //user ������ �޾ƿ�
		ScheduleService service = new ScheduleService();
		int placeNum = service.selectPlaceByTheaterNum(theaterNum);  //�ش��ϴ� place number�� �޾ƿ�
//		System.out.println(placeNum);
		
		service.updateScheduleTheaterPlacenum(theaterNum, placeNum, scheduleNum);		
	}

	private static void f10() {
		
		int scheduleNum = createScheduleNumber("cansu"); //user�� ���� ���۽� ����
//		System.out.println(scheduleNum);
		String showCode = "AA9";  //user�� ��ȭ ���� ���� 
		
		ScheduleService service = new ScheduleService();
		service.insertScheduleInforNum(scheduleNum, showCode);
		
	}
	
	private static int createScheduleNumber(String mID) {
		
//		System.out.println(mID);
		int dayNum = calendartoString();
//		System.out.println(dayNum);
		String scheduleNum = eachChartoString(mID, dayNum);

		return Integer.parseInt(scheduleNum.substring(3, scheduleNum.length()));
		
	}

	private static int calendartoString() {
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);
		int nowMonth = now.get(Calendar.MONTH)+1;
		int nowDay = now.get(Calendar.DATE);
		int nowHour = now.get(Calendar.HOUR);
		int nowMinute = now.get(Calendar.MINUTE);
//		System.out.println(nowYear+"-"+nowMonth+"-"+nowDay+" "+nowHour+":"+nowMinute);
		
		String dayNum = Integer.toString(nowMonth)+Integer.toString(nowDay)+Integer.toString(nowHour)+Integer.toString(nowMinute);
//		System.out.println(dayNum);
		return Integer.parseInt(dayNum);
	}

	private static void f9() {
	
		ScheduleService service = new ScheduleService();
		List<TheaterVO> pList = new ArrayList<>();
		int placenum = 1005;
		pList = service.selectTheaterByPlaceNum(placenum);
		
		for(TheaterVO temp: pList) {
			System.out.println(temp);
		}
	}

	private static void f8() {
		
		ScheduleService service = new ScheduleService();
		List<TheaterVO> pList = new ArrayList<>();
		pList = service.selectAllTheater();
		
		for(TheaterVO temp: pList) {
			System.out.println(temp);
		}
		
	}

	private static void f7() {
		
		ScheduleService service = new ScheduleService();
		List<PlaceVO> pList = new ArrayList<>();
		pList = service.selectALLPlace();
		
		for(PlaceVO temp: pList) {
			System.out.println(temp);
		}
	}

	private static void f6() {
		
		int scheduleNum = 44;  //��Ģ�� ���� �ο�(��ȭ, �󿵰� ���)
		
		String showCode = "AA3"; //user ������ �޾Ƽ� ����
		
		String theaterNum = "B2"; //user ������ �޾Ƽ� ����
		int placeNum = 1002; //theater�� �����Ǹ鼭 ���� ����
		
		String showStartStr = "2022-06-07 16:16:00";  //�ð� ��¥ ������ �޾Ƽ� ����(DateTimeFormatter->LocalDateTime) 
													//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		
		ScheduleService service = new ScheduleService();
		service.insertScheduleInfor(scheduleNum, showCode, theaterNum, placeNum, showStartStr);
		
	}

	private static void f5() {
//		int scheduleNum = 10; 
//		String m_id="cansu"; 
//		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //������ �����ȣ�� ?
		
		
		int reservationNum = 469543;
		
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
		
		String seatNumbArr = "11 12 14 15"; //�ڸ� ������ ��� ��������
		String[] seatNum = seatNumbArr.trim().split(" ");
		int countSeat = seatNum.length;  //���� ���ϱ�
		
		//seat_num�� �Ѱ� ���� ��Ȳ		
		ScheduleService service = new ScheduleService();
		for(String arr: seatNum) {
			service.insertReservationDetailInfor(reservationNum, arr);
		}

		
		//seat_num�� ������ ���� ��Ȳ(f2���� reservation row������ �ش� reservation detail row�����ؼ� update����)
//		String seatNumb = "11 12 14 15";  //�ڸ� ����
//		int countSeat = seatNumb.trim().split(" ").length; //strip()������������(trim���� �پ��� �����ڵ� ���� ���� ����. 11v���� ����)
//		ScheduleService service = new ScheduleService();
//		service.updateReservationDetailInfor(seatNumb, reservationNum);
	}

	private static void f3() {
		
		String payment = "card"; //payment ��� ����
		int totalPrice = 2200;  //�ο��� ������  ���� �ݾ� ����(�¼� ������)
		
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //������ �����ȣ�� ?
		
		ScheduleService service = new ScheduleService();
		service.updateReservationInfor(payment, totalPrice, reservationNum);
		
	}

	private static void f2() {
		//(reservationNum, m_id, scheduleNum, reservationDate, �������� �ӽð�) reservation table insert �ϱ�
		
		int scheduleNum = 2;  //schedule ��ȣ ��������
		String m_id="cansu"; //m_id ��������
		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum));  //id�� ���� ������ ���ڷ� ��ȯ+"scheduleNumber"
		
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);
//		service.insertReservationDetailInfor(reservationNum);  //reservation table�� row������ �ش��ϴ� reservation detail table���� ����
		
	}
	
	private static String eachChartoString(String name, int number) {
		
		char[] temp = name.toCharArray();
		String result = "";
		for(char ch: temp) {
			result += (int)ch;
		}
		
//		System.out.println(result);
//		System.out.println(Integer.toString(number));
		return result.substring(0, 6)+Integer.toString(number);
	}

	private static void f1() {
		ScheduleService service = new ScheduleService();
		
		//update point
		String id = "cansu";
		service.selectMembersPointByID(id);
		int point = 100+service.selectMembersPointByID(id);;  //update value
		
		service.updatePointMembers(id, point);
		
//		//select member table
//		List<MembersVO> list = new ArrayList<>();
//		list = service.selectALLMembers();
//		
//		for(MembersVO arr: list) {
//			System.out.println(arr);
//		}
	}

}
