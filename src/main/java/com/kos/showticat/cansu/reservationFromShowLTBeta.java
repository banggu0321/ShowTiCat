package com.kos.showticat.cansu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/reservationFromShowLTBeta")
public class reservationFromShowLTBeta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String theaterNum = request.getParameter("theaterNum");
		int placeNum = Integer.parseInt(request.getParameter("placeNum"));
		String showStart = request.getParameter("showStart").substring(0, 10);
//		System.out.println(theaterNum);
//		System.out.println(placeNum);		
		
		HttpSession session = request.getSession();
		int scheduleNum = (int)session.getAttribute("scheduleNumber"); 
//		System.out.println(scheduleNum);
//		
		ScheduleService service = new ScheduleService();
		service.updateScheduleByScheduleNum(theaterNum, placeNum, showStart, scheduleNum);
		
		RequestDispatcher rd = request.getRequestDispatcher("cansu/seatTemp.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
