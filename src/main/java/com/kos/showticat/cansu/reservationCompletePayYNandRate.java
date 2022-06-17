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

import com.kos.showticat.reservation.dao.temp.ChartVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/reservationCompletePayYNandRate")
public class reservationCompletePayYNandRate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession seesion = request.getSession();
		ScheduleService service = new ScheduleService();
		
		//session reservation number -> select schedule number ->	show code
		int reservationNum = (int)seesion.getAttribute("reservationNumber");
		//		System.out.println(reservationNum);
		String id = service.selectReservationUserIDByReservationNum(reservationNum);
				
		//update payment		
		String payment = request.getParameter("pay");
		System.out.println(payment);		
		service.updateReservationPaymentByResNum(payment, reservationNum);
		
		int pointYN = Integer.parseInt(request.getParameter("pointYN"));
		System.out.println(pointYN);
		if(pointYN <0)
		{
			pointYN = 0;
		}
		
		int pointValue = (int)seesion.getAttribute("pointValue");
		int totalPrice = service.selectReservationTpriceByNum(reservationNum);

		//if Y
		//total price - point
		if((pointYN>0)&&(pointValue>pointYN)) {
			int point = service.selectMembersPointByID(id) + (pointValue-pointYN);  //before+(new-request)
			if(point > totalPrice) {
				point -= totalPrice;  
				service.updatePointMembers(id, point);
				System.out.println("ScheduleDAO.reservationResultFromShowList=>update data(point-totalPrice)");
			}
			if(point<totalPrice) {
				point = service.selectMembersPointByID(id)+pointValue; 
				service.updatePointMembers(id, point);
				System.out.println("ScheduleDAO.reservationResultFromShowList=>update data(point < total Price)");
			}
		}
		
		//if 0==N
		if((pointYN==0)||(pointValue<pointYN)) {
			int point = service.selectMembersPointByID(id)+pointValue; 
			service.updatePointMembers(id, point);
			System.out.println("ScheduleDAO.reservationResultFromShowList=>update data");
		}


		int scheduleNum = service.selectReservationByReservationNum(reservationNum);
		String showCode = service.selectScheduleByScheduleNum(scheduleNum);		
		//		System.out.println(showCode);

		//reservation table pay_YN update		
		String yn="Y"; //check Y or N 
		service.updateReservationPaymentYN(yn, reservationNum);


		//reservation number select m_id -> gender 
		String mID = service.selectReservationUserIDByReservationNum(reservationNum);
		String gender = service.selectMemberByID(mID);

		//		System.out.println(mID);
		//		System.out.println(gender);

		Boolean tempBoo = false;
		
		//show code 있는 여부 확인 -> 있으면 rate과정 진행
		List<ChartVO> temp = new ArrayList<>();
		temp = service.selectChartShowCode();

		for(ChartVO arr: temp) {
			if(arr.getShowCode().equals(showCode)) {
				tempBoo = true;
			}
		}	

		if(tempBoo) {
			List<String> rateWM = new ArrayList<>();
			rateWM = service.selectChartByShowCode(showCode);

			int rate = 0;  //gender
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
		}

		//(index.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
