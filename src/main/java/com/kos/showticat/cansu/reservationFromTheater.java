package com.kos.showticat.cansu;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
		System.out.println("ID: "+m_id);
		
		//get admin schedule
		int scheduleNumFromTheater = Integer.parseInt(request.getParameter("schedule_num"));
		ScheduleService service = new ScheduleService();
		ScheduleVO svoTemp = new ScheduleVO();
		String showCode = service.selectScheduleByScheduleNum(scheduleNumFromTheater);
		session.setAttribute("showCode", showCode);
		System.out.println("schedule number: "+scheduleNumFromTheater);
		
		//selected showcode.schedule.seat 
		List<Integer> iList = new ArrayList<>();
		iList = service.selectReservationByJoinSchedule(scheduleNumFromTheater, showCode);
//		System.out.println(iList);
		
		List<String> temp = new ArrayList<>();
		List<String> seatList = new ArrayList<>();
		for(Integer arr: iList) {
			temp = service.selectReservationDetailByNumber(arr);
//			System.out.println(temp);
			
			for(String seatTemp: temp) {
				seatList.add(seatTemp);
			}
		}
		
		System.out.println("selected seat number: "+seatList);
		request.setAttribute("seatList", seatList);
		System.out.println(seatList);
		
		//create reservation number
		int reservationNumBeta = createScheduleNumber();
		
		//session
		session.setAttribute("reservationNumber", reservationNumBeta);
		System.out.println("reservation number:"+reservationNumBeta);
				
		service.insertReservationInfor(reservationNumBeta, m_id, scheduleNumFromTheater);
		
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
}
