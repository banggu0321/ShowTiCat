package com.kos.showticat.cansu;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;


@WebServlet("/reservationBeta.do")
public class reservationFromTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String scheduleNum = request.getParameter("schedule_num");
		System.out.println("scheduleNum:"+scheduleNum);

		//log in check -> get id
		String logInPath = "../jayoung/main.jsp";
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		member = (MemberVO) session.getAttribute("member");
//		System.out.println(member);
		if(member==null) {  //log in ���� ���Ž� main page�� ������
			response.sendRedirect(logInPath);
			return;
		}
		String m_id=member.getM_id();
		System.out.println(m_id);
		
		
		//schedule number -> reservation number
		int reservationNumBeta = 0;
		if (scheduleNum.length() > 7) {
			reservationNumBeta = Integer.parseInt(scheduleNum.substring(0, 6))/4;
		} else {
			reservationNumBeta = Integer.parseInt(scheduleNum)*20;
		}
		
		session.setAttribute("reservationNumber", reservationNumBeta);
		System.out.println(reservationNumBeta);
				
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNumBeta, m_id, Integer.parseInt(scheduleNum));
		
		//위임 seatTemp.jsp
		RequestDispatcher rd = request.getRequestDispatcher("cansu/seatTempBeta.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}
	
	private static String eachChartoStringBeta(String name) {
		
		char[] temp = name.toCharArray();
		String result = "";
		for(char ch: temp) {
			result += (int)ch;
		}
		
		return result.substring(0, 6);
	}
	
}
