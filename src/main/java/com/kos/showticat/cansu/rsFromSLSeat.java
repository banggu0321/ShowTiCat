package com.kos.showticat.cansu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.cansu.ScheduleService;

@WebServlet("/reservationFromShowLTBeta")
public class rsFromSLSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String theaterNum = request.getParameter("theaterNum");
		int placeNum = Integer.parseInt(request.getParameter("placeNum"));
		String showStart = request.getParameter("showStart"); //
		
		String shoCode = String.valueOf(session.getAttribute("showCode"));
		request.setAttribute("showCode", shoCode);
		System.out.println("Show code: "+shoCode);
		//		System.out.println(theaterNum);
		//		System.out.println(placeNum);		

		//session
		ScheduleService service = new ScheduleService();
//		int scheduleNum = service.selectScheduleBythreeAttri(shoCode, theaterNum, placeNum);
		int scheduleNum = Integer.parseInt(request.getParameter("scheduleNum"));
		session.setAttribute("scheduleNumber", scheduleNum);
		
		//selected showcode.schedule.seat 
		List<Integer> iList = new ArrayList<>();
		iList = service.selectReservationByJoinSchedule(scheduleNum, shoCode);
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
		

		RequestDispatcher rd = request.getRequestDispatcher("cansu/seatTemp.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
