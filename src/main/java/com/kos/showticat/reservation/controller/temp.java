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
//		f5();  //reservation table 조회
//		f4(); //1~2: 인원수 선택(수정)
//		f3beta(); //reservation number에 따른 paymentYN update
//		f3(); 	//2(나머지 update).인원(좌석)선택, 총비용(스케쥴넘버-> 가격, 인원 선택-> 총 비용) 
//		f2(); //reservation table의 (스케쥴 넘버와 reservation date을 먼저 결정), 나머지(임시 값) & reservation detail table의 해당하는 row 작성
		//1.[스케쥴(영화, 극장, 날짜, 시간 선택)->] 스케쥴 넘버(reservationNum, m_id, scheduleNum, reservationDate)&나머지(temp 값) 입력-> 스케쥴_detail table 해당 row 입력
	

		f1();  //update point in members table, select members table
		
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
	}

	private static void f20() {
		
		int reservationNum = 2; //reservation number 받아오기
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectReservationUserIDByReservationNum(reservationNum));
	}

	private static void f19() {
		
		String gender = "W"; //select된 gender 받아오기
		
		List<String> rateWM = new ArrayList<>();
		String showCode="BB34"; //select된 showcode 받아오기
		
		ScheduleService service = new ScheduleService();
		rateWM = service.selectChartByShowCode(showCode);
		
		int rate = 0;  //gender에 따라 초기값 결정
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
		String showCode="BB34"; //select된 showcode 받아오기
		
		ScheduleService service = new ScheduleService();
		rateWM = service.selectChartByShowCode(showCode);
		
		for(String arr: rateWM) {
			System.out.println(arr);
		}
	}

	private static void f18() {
		
		int scheduleNum = 16; //select된 schedule number 가져오기
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectScheduleByScheduleNum(scheduleNum));
	}


	private static void f17() {
		
		int reservationNum = 469540; //session에 저장된 reservation number 가져오기
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectReservationByReservationNum(reservationNum));
	}


	private static void f16() {

		String mID = "yong";  //session에 저장된 member obj에서 m_id 가져오기
		
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
		
		int scheduleNum = 10; //저장된 schedule number 가져오기
		
		ScheduleService service = new ScheduleService();
		System.out.println(service.selectScheduleByScheduleNum(scheduleNum));
	}


	private static void f12() {
		int scheduleNum = 711691055; //생성한 schedule number 불러오기(session 에 저장하고 불러오기)

		String startShow = "2022-06-09 10:10:00";  //user가 시간을 선택
		
		//string -> timestamp -> date
		Timestamp sStart = Timestamp.valueOf(startShow);
		Date sDate = new Date(sStart.getTime());
		
		ScheduleService service = new ScheduleService();
		service.updateScheduleShowstart(sDate, scheduleNum);
	}
	private Date stringToDate(String myDate, String myTime) {  //dateSampleServlet에서 사용
		
		String timeTemp = myTime+":00";
//		System.out.println(timeTemp);

		
		String showStart = myDate+" "+timeTemp;
		Timestamp temp = Timestamp.valueOf(showStart);

		Date result=new Date(temp.getTime());
		return result;
	}

	private static void f11() {
		
		int scheduleNum = 711691055; //생성한 schedule number 불러오기(session 에 저장하고 불러오기)

		String theaterNum = "D2"; //user 선택을 받아옴
		ScheduleService service = new ScheduleService();
		int placeNum = service.selectPlaceByTheaterNum(theaterNum);  //해당하는 place number을 받아옴
//		System.out.println(placeNum);
		
		service.updateScheduleTheaterPlacenum(theaterNum, placeNum, scheduleNum);		
	}

	private static void f10() {
		
		int scheduleNum = createScheduleNumber("cansu"); //user가 예매 시작시 생성
//		System.out.println(scheduleNum);
		String showCode = "AA9";  //user의 영화 선택 받음 
		
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
		
		int scheduleNum = 44;  //규칙에 따라 부여(영화, 상영관 고려)
		
		String showCode = "AA3"; //user 선택을 받아서 결정
		
		String theaterNum = "B2"; //user 선택을 받아서 결정
		int placeNum = 1002; //theater가 결정되면서 따라서 결정
		
		String showStartStr = "2022-06-07 16:16:00";  //시간 날짜 선택을 받아서 결정(DateTimeFormatter->LocalDateTime) 
													//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		
		ScheduleService service = new ScheduleService();
		service.insertScheduleInfor(scheduleNum, showCode, theaterNum, placeNum, showStartStr);
		
	}

	private static void f5() {
//		int scheduleNum = 10; 
//		String m_id="cansu"; 
//		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //생성된 예약번호을 ?
		
		
		int reservationNum = 469543;
		
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
		
		String seatNumbArr = "11 12 14 15"; //자리 선택한 결과 가져오기
		String[] seatNum = seatNumbArr.trim().split(" ");
		int countSeat = seatNum.length;  //갯수 구하기
		
		//seat_num에 한개 값인 상황		
		ScheduleService service = new ScheduleService();
		for(String arr: seatNum) {
			service.insertReservationDetailInfor(reservationNum, arr);
		}

		
		//seat_num에 여러개 값인 상황(f2에서 reservation row생성시 해당 reservation detail row생성해서 update했음)
//		String seatNumb = "11 12 14 15";  //자리 선택
//		int countSeat = seatNumb.trim().split(" ").length; //strip()양측공백제거(trim보다 다양한 유니코드 공백 제거 가능. 11v에서 제공)
//		ScheduleService service = new ScheduleService();
//		service.updateReservationDetailInfor(seatNumb, reservationNum);
	}

	private static void f3() {
		
		String payment = "card"; //payment 방식 선택
		int totalPrice = 2200;  //인원수 결정후  최종 금액 결정(좌석 선택후)
		
		int scheduleNum = 10; 
		String m_id="cansu"; 
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum)); //생성된 예약번호을 ?
		
		ScheduleService service = new ScheduleService();
		service.updateReservationInfor(payment, totalPrice, reservationNum);
		
	}

	private static void f2() {
		//(reservationNum, m_id, scheduleNum, reservationDate, 나머지는 임시값) reservation table insert 하기
		
		int scheduleNum = 2;  //schedule 번호 가져오기
		String m_id="cansu"; //m_id 가져오기
		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum));  //id에 따라 일정한 숫자로 변환+"scheduleNumber"
		
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);
//		service.insertReservationDetailInfor(reservationNum);  //reservation table에 row생성후 해당하는 reservation detail table에도 생성
		
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
