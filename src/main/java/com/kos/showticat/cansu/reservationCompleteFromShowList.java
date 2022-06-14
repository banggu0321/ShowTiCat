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


@WebServlet("/reservationCompleteFromShowList")
public class reservationCompleteFromShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		String pay = request.getParameter("pay");
		String pay = "temp";
		
		//session 
		HttpSession seesion = request.getSession();
		
		String seatNum = String.valueOf(seesion.getAttribute("seatNumber"));
		System.out.println(seatNum);

		//(reservationNum -> schedulNum -> showCode)
		int reservationNum = (int)seesion.getAttribute("reservationNumber");
		
		ScheduleService service = new ScheduleService();		
		int schedulNum = service.selectReservationByReservationNum(reservationNum);
		String showCode = service.selectScheduleByScheduleNum(schedulNum);
		
		int showPrice = service.selectShowByShowCode(showCode);
		System.out.println(showPrice);
		
		int totalPrice = Integer.parseInt(seatNum)*showPrice;
		service.updateReservationInfor(pay, totalPrice, reservationNum);
		
		//(reservationResult)
		RequestDispatcher rd = request.getRequestDispatcher("reservationResultFromShowList");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
