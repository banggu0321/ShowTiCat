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

import com.kos.showticat.jayoung.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/reservationCompletePayYNandRate")
public class reservationCompletePayYNandRate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession seesion = request.getSession();
		ScheduleService service = new ScheduleService();

//session에 저장된 reservation number 가져오기 -> select schedule number ->	show code
		int reservationNum = (int)seesion.getAttribute("reservationNumber");
//		System.out.println(reservationNum);

		int scheduleNum = service.selectReservationByReservationNum(reservationNum);
		String showCode = service.selectScheduleByScheduleNum(scheduleNum);		
//		System.out.println(showCode);
		
//reservation table pay_YN update		
		String yn="Y"; //check를 통해 Y or N 결정
		service.updateReservationPaymentYN(yn, reservationNum);


		//reservation number에서 select m_id -> gender 확인
		String mID = service.selectReservationUserIDByReservationNum(reservationNum);
		String gender = service.selectMemberByID(mID);
		
//		System.out.println(mID);
//		System.out.println(gender);

		List<String> rateWM = new ArrayList<>();
		rateWM = service.selectChartByShowCode(showCode);

		int rate = 0;  //gender에 따라 초기값 결정
		if(gender.equals("W")) {
			rate = Integer.parseInt(rateWM.get(0));			
		}else if(gender.equals("M")) {
			rate = Integer.parseInt(rateWM.get(1));	
		}
//		System.out.println(rate);

		if(gender.equals("W")) {
			service.updateChartGenderWByCheck(rate+1, showCode);		
		}else if(gender.equals("M")) {
			service.updateChartGenderMByCheck(rate+1, showCode);
		}
		System.out.println("ScheduleDAO.reservationCompletePayYNandRate=>update data");

		//위임(jayoung/main.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("jayoung/main.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
