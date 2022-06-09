package com.kos.showticat.cansu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.jayoung.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/seatSampleServlet")
public class seatSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//user가 클릭한 위치 값 가져오기
		Enumeration<String> seatName = request.getParameterNames();
		List<String> seatPosition = new ArrayList<>();
		
		while(seatName.hasMoreElements()) {
			seatPosition.add(request.getParameter(seatName.nextElement()));
		}
//		for(String arr: seatPosition) {
//			System.out.println(arr);
//		}
		
//이전 단계에서 작성된 schedule number, ID 가져오기
		HttpSession seesion = request.getSession();
		int scheduleNum = (int)seesion.getAttribute("scheduleNumber");
		
		MemberVO member = new MemberVO();
		member = (MemberVO) seesion.getAttribute("member");
		String m_id=member.getM_id(); 
		
//reservation number을 reservation detail table에서 row 만들면서 만들기
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum).substring(8)); //생성된 예약번호을 session에 저장
		seesion.setAttribute("reservationNumber", reservationNum);
		
//입력받은 좌석위치를 DB에 반영(seat_num에 한개 값인 상황)	
		int countSeat = seatPosition.size();  //갯수 구하기
		seesion.setAttribute("seatNumber", countSeat);
		
		//reservation table에 row만들기(임시 data 사용하기)
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);
		
		//reservation detail table에 row만들기(완성하기)
		for(String arr: seatPosition) {
			service.insertReservationDetailInfor(reservationNum, arr);
		}
		
		//위임(paymentSample.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("cansu/paymentSample.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

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

}
