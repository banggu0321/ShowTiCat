package com.kos.showticat.cansu;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;
import com.kos.showticat.reservation.dao.temp.ScheduleVO;


@WebServlet("/reservationFromTheater")
public class reservationFromTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//log in check -> get id
		String logInPath = "../jayoung/login.do";
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		member = (MemberVO) session.getAttribute("member");
//		System.out.println(member);
		if(member==null) {  
			response.sendRedirect(logInPath);
			return;
		}
		String m_id=member.getM_id();
		System.out.println(m_id);
		
		//get admin schedule
		int scheduleNumFromTheater = Integer.parseInt(request.getParameter("schedule_num"));
		ScheduleService service = new ScheduleService();
		ScheduleVO svoTemp = new ScheduleVO();
		svoTemp = service.selectScheduleByScheduleNumBeta(scheduleNumFromTheater);
		
		//session-user
		int scheduleNum = createScheduleNumber(); 
		session.setAttribute("scheduleNumber", scheduleNum);
		System.out.println("scheduleNum:"+scheduleNum);
		
//		service.insertScheduleInfor(scheduleNum, m_id, svoTemp.getTheaterNum(), svoTemp.getPlaceNum(), svoTemp.getShowStart());
		service.insertScheduleInforNum(scheduleNum, svoTemp.getShowCode());
		service.updateScheduleByScheduleNum(svoTemp.getTheaterNum(), svoTemp.getPlaceNum(), svoTemp.getShowStart(), scheduleNum);		
		
		//user schedule number -> reservation number
		int reservationNumBeta = (int)scheduleNum/4;
//		if (scheduleNum.length() > 7) {
//			reservationNumBeta = Integer.parseInt(scheduleNum.substring(0, 6))/4;
//		} else {
//			reservationNumBeta = Integer.parseInt(scheduleNum)*20;
//		}
		
		//session
		session.setAttribute("reservationNumber", reservationNumBeta);
		System.out.println("reservation number:"+reservationNumBeta);
				
		service.insertReservationInfor(reservationNumBeta, m_id, scheduleNum);
		
		//위임 seatTemp.jsp
		RequestDispatcher rd = request.getRequestDispatcher("cansu/seatTempBeta.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}
	
	private static int createScheduleNumber() {
		//random number
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());

		int dayNum = random.nextInt();
		if(dayNum<0) {
			dayNum = -dayNum;
		}
		String randTemp = String.valueOf(dayNum);
		System.out.println(randTemp.substring(0, 7));
		
		return Integer.parseInt(randTemp.substring(0, 7));
	}
	
//	private static String eachChartoStringBeta(String name) {
//		
//		char[] temp = name.toCharArray();
//		String result = "";
//		for(char ch: temp) {
//			result += (int)ch;
//		}
//		return result.substring(0, 6);
//	}
	
}
