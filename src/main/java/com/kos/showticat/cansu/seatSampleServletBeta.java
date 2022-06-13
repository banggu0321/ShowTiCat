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

import com.kos.showticat.reservation.dao.temp.ScheduleService;


@WebServlet("/seatSampleServletBeta")
public class seatSampleServletBeta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Enumeration<String> seatName = request.getParameterNames();
		List<String> seatPosition = new ArrayList<>();
		
		while(seatName.hasMoreElements()) {
			seatPosition.add(request.getParameter(seatName.nextElement()));
		}
		
		HttpSession seesion = request.getSession();
		int countSeat = seatPosition.size();  
		seesion.setAttribute("seatNumber", countSeat);
		
		//reservation detail table
		int reservationNum = (int)seesion.getAttribute("reservationNumber");
		ScheduleService service = new ScheduleService();
		for(String arr: seatPosition) {
			service.insertReservationDetailInfor(reservationNum, arr);
		}
		
		
		//위임 (paymentSample.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("/reservationCompleteFromShowList");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
