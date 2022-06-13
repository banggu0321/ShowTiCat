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


@WebServlet("/jayoung/reservation.do")
public class reservationFromShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//log in check
		String logInPath = "../index.jsp";
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
		System.out.println(showCode);
		
		// schedule number session
		int scheduleNum = createScheduleNumber(m_id);  		
//		System.out.println(m_id);
		session.setAttribute("scheduleNumber", scheduleNum); //session
		
		ScheduleService service = new ScheduleService();
		service.insertScheduleInforNum(scheduleNum, showCode);
		System.out.println("create schedule");
		
		//sample 1
//		RequestDispatcher rd = request.getRequestDispatcher("/placeListServilet");
//		rd.forward(request, response);

		//sample 2: showCode -> relative schedule
		List<ScheduleVO> sList = new ArrayList<>();
		sList = service.selectScheduleByShowcode(showCode);		
		request.setAttribute("ScheduleList", sList);		

		//위임
		RequestDispatcher rd = request.getRequestDispatcher("/reservationFromSListUSchedule");	
		rd.forward(request, response);
	}
	private static int createScheduleNumber(String mID) {
		
//		System.out.println(mID);
//		int dayNum = calendartoString();
//		System.out.println(dayNum);
		
		//random number
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		int dayNum = random.nextInt();
		if(dayNum<0) {
			dayNum = -dayNum;
		}
//		System.out.println(dayNum);
		String scheduleNum = eachChartoString(mID, dayNum);
		System.out.println(scheduleNum);

		return Integer.parseInt(scheduleNum.substring(3, scheduleNum.length()));
		
	}

//	private static int calendartoString() {
//		Calendar now = Calendar.getInstance();
////		int nowYear = now.get(Calendar.YEAR);
//		int nowMonth = now.get(Calendar.MONTH)+1;
//		int nowDay = now.get(Calendar.DATE);
//		int nowHour = now.get(Calendar.HOUR);
////		int nowMinute = now.get(Calendar.MINUTE);
////		System.out.println(nowYear+"-"+nowMonth+"-"+nowDay+" "+nowHour+":"+nowMinute);
//		
//		String dayNum = Integer.toString(nowMonth)+Integer.toString(nowDay)+Integer.toString(nowHour);
////		String dayNum = Integer.toString(nowMonth)+Integer.toString(nowDay)+Integer.toString(nowHour)+Integer.toString(nowMinute);
////		System.out.println(dayNum);
//		return Integer.parseInt(dayNum);
//	}

	private static String eachChartoString(String name, int number) {
		
		char[] temp = name.toCharArray();
		String result = "";
		for(char ch: temp) {
			result += (int)ch;
		}
		
		String numberTemp = String.valueOf(number);
		System.out.println(numberTemp);
		return result.substring(0, 6)+numberTemp.substring(0, 2);
		
//		return result.substring(0, 6)+Integer.toString(number);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
