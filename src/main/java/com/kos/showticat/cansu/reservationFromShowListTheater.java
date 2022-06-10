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

@WebServlet("/reservationFromShowListTheater")
public class reservationFromShowListTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	    String theaterNumber = request.getParameter("theaterNum");
//	    String placeNumber = request.getParameter("placeNum");
	    
//	    System.out.println(theaterNumber);
//	    System.out.println(placeNumber);
	    
	    String theaterNum = request.getParameter("theaterNum"); //user 선택을 받아옴
		ScheduleService service = new ScheduleService();
		int placeNum = service.selectPlaceByTheaterNum(theaterNum);  //해당하는 place number을 받아옴
		System.out.println("placeNum: "+placeNum);
		
		HttpSession session = request.getSession();
		int scheduleNum = (int)session.getAttribute("scheduleNumber");
		System.out.println("scheduleNum: "+scheduleNum);
		
		service.updateScheduleTheaterPlacenum(theaterNum, placeNum, scheduleNum);		
		
		//위임(dateTemp.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("cansu/dateTemp.jsp");
		rd.forward(request, response);   
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
