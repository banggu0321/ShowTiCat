package com.kos.showticat.cansu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;
import com.kos.showticat.reservation.dao.temp.ScheduleVO;


@WebServlet("/reservationFromShowList")
public class reservationFromShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//log in check
		String logInPath = "../jayoung/login.do";
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		member = (MemberVO) session.getAttribute("member");
		System.out.println(member);
		if(member==null) {  //log in 
			response.sendRedirect(logInPath);
			return;
		}
		String m_id=member.getM_id(); //m_id(ex)String m_id="cansu"; 

		//user
		String showCode = request.getParameter("show_code");
		System.out.println("show_code: "+showCode);
		session.setAttribute("showCode", showCode);
		
		ScheduleService service = new ScheduleService();
		// schedule number session
//		int scheduleNum = createScheduleNumber(m_id); 
//		session.setAttribute("scheduleNumber", scheduleNum);
		//session
//		service.insertScheduleInforNum(scheduleNum, showCode);
//		System.out.println("create schedule: scheduleNum("+scheduleNum+")");


		//sample 2: showCode -> relative schedule(user schedule 제외 ) 		List<ScheduleVO> sResult = new ArrayList<>();
		List<ScheduleVO> sList = new ArrayList<>();
		sList = service.selectScheduleByShowcode(showCode);
		//		System.out.println(sList.size());
		request.setAttribute("ScheduleList", sList);

		//위임
		RequestDispatcher rd = request.getRequestDispatcher("/reservationFromSListUSchedule");	
		rd.forward(request, response);
		//		}

		//sample 1
		//		RequestDispatcher rd = request.getRequestDispatcher("/placeListServilet");
		//		rd.forward(request, response);
	}
	private static int createScheduleNumber(String mID) {

		//random number
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());

		int dayNum = random.nextInt();
		if(dayNum<0) {
			dayNum = -dayNum;
		}
		String randTemp = String.valueOf(dayNum);
		System.out.println(randTemp.substring(0, 7));
		
		return Integer.parseInt(randTemp.substring(0, 7));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
