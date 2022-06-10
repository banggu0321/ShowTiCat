package com.kos.showticat.cansu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.reservation.dao.temp.ReservationVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/reservationResultFromShowList")
public class reservationResultFromShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//session 에 저장된 reservationNumber 가져오기
		HttpSession seesion = request.getSession();
		int reservationNum = (int)seesion.getAttribute("reservationNumber");

		
		ScheduleService service = new ScheduleService();
		ReservationVO rvo = service.reservationSelectByNumber(reservationNum);
		rvo.setReservationNum(reservationNum);
		
		request.setAttribute("reservationData", rvo);
		
		//update point
//		String id = "cansu";
//		int point = Integer.parseInt(rvo.getTotalPrice())+service.selectMembersPointByID(id);  //update value = point + select value
//		
//		service.updatePointMembers(id, point);
		
//		System.out.println(rvo);
		
		//위임(reservationResult.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("cansu/reservationResult.jsp");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
