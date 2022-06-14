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
import javax.websocket.Session;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/seatSampleServlet")
public class seatSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Enumeration<String> seatName = request.getParameterNames();
		List<String> seatPosition = new ArrayList<>();
		
		while(seatName.hasMoreElements()) {
			seatPosition.add(request.getParameter(seatName.nextElement()));
		}
		for(String arr: seatPosition) {
			System.out.println(arr);
		}
		
		HttpSession session = request.getSession();
		int scheduleNum = (int)session.getAttribute("scheduleNumber"); 
		System.out.println(scheduleNum);
		
		
		MemberVO member = new MemberVO();
		member = (MemberVO) session.getAttribute("member");
		String m_id=member.getM_id(); 
		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum).substring(8));
		session.setAttribute("reservationNumber", reservationNum);
		
		int countSeat = seatPosition.size(); 
		session.setAttribute("seatNumber", countSeat);
		
		//reservation table
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);
		
		//reservation detail table
		for(String arr: seatPosition) {
			service.insertReservationDetailInfor(reservationNum, arr);
		}
				
		
//		//sample1 (paymentSample.jsp)
//		RequestDispatcher rd = request.getRequestDispatcher("cansu/paymentSample.jsp");
//		rd.forward(request, response);
		
		//sample2 (reservationResult.jsp) add seatTemp.jsp request
		RequestDispatcher rd = request.getRequestDispatcher("/reservationCompleteFromShowList");
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
