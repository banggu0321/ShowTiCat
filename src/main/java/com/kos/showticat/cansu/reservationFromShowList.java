package com.kos.showticat.cansu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.jayoung.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;


@WebServlet("/jayoung/reservation.do")
public class reservationFromShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//log in check
		String logInPath = "../jayoung/main.jsp";
		
		MemberVO member = new MemberVO();
		HttpSession session = request.getSession();
		member = (MemberVO) session.getAttribute("member");
		System.out.println(member);
		if(member==null) {  //log in 없이 예매시 main page로 재전송
			response.sendRedirect(logInPath);
			return;
		}
		String m_id=member.getM_id(); //m_id 가져오기 (ex)String m_id="cansu"; 
				
		//user 영화선택을 받아옴
		String showCode = request.getParameter("show_code");
		System.out.println(showCode);
//		String showCode = "AA3"; //user 선택을 받아서 결정
		
		// schedule number check
		int scheduleNum = 42;  		
//		int scheduleNum = 2;  //schedule 번호 가져오기		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum));  //id에 따라 일정한 숫자로 변환+"scheduleNumber"
		
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);  //reservation table row 생성
		
		String payment = "card"; //payment 방식 선택
		int totalPrice = 2200;  //인원수 결정후  최종 금액 결정(좌석 선택후)
		service.updateReservationInfor(payment, totalPrice, reservationNum); //생성된 row의 너머지 값 update
		
	}
	private static String eachChartoString(String name, int number) {
		
		char[] temp = name.toCharArray();
		String result = "";
		for(char ch: temp) {
			result += (int)ch;
		}
		
		return result.substring(0, 6)+Integer.toString(number);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
