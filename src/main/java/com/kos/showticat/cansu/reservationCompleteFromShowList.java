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
		String pay = request.getParameter("pay");
		System.out.println(pay);
		
		//session 에 저장된 seatNumber 가져오기
		HttpSession seesion = request.getSession();
		
		String seatNum = String.valueOf(seesion.getAttribute("seatNumber"));
		System.out.println(seatNum);

		//session 에 저장된 reservationNumber 가져오기(reservationNum -> schedulNum -> showCode)
		int reservationNum = (int)seesion.getAttribute("reservationNumber");
		
		ScheduleService service = new ScheduleService();		
		int schedulNum = service.selectReservationByReservationNum(reservationNum);
		String showCode = service.selectScheduleByScheduleNum(schedulNum);
		
		int showPrice = service.selectShowByShowCode(showCode);
		System.out.println(showPrice);
		
		int totalPrice = Integer.parseInt(seatNum)*showPrice;  //인원수 결정후  최종 금액 결정(좌석 선택후)
		service.updateReservationInfor(pay, totalPrice, reservationNum);
		
		//위임(reservationResult에 예약 결과 출력)
		RequestDispatcher rd = request.getRequestDispatcher("cansu/reservationResult.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
