package com.kos.showticat.cansu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.cansu.dao.ReservationVO;
import com.kos.showticat.cansu.ScheduleService;

@WebServlet("/reservationResultFromShowList")
public class rstFromSLresult extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//session 
		HttpSession seesion = request.getSession();
		int reservationNum = (int)seesion.getAttribute("reservationNumber");

		ScheduleService service = new ScheduleService();
		ReservationVO rvo = service.reservationSelectByNumber(reservationNum);
		//		System.out.println(rvo);
	
		rvo.setReservationNum(reservationNum);
		request.setAttribute("reservationData", rvo);
		
		//update point
		String id = service.selectReservationUserIDByReservationNum(reservationNum);
		int pointValue = (int)seesion.getAttribute("seatNumber")*1000;
		seesion.setAttribute("pointValue", pointValue);
		System.out.println("point value: "+pointValue);
		
		//(reservationResult.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("cansu/reservationResult.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
