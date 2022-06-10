package com.kos.showticat.cansu;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/dateSampleServlet")
public class dateSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String myDate = request.getParameter("myDate");
		String myTime = request.getParameter("myTime");
		
		Date showStart = stringToDate(myDate, myTime);  //입력할 Date만들기
//		System.out.println(showStart);
		
		HttpSession session = request.getSession(); 
		int scheduleNum = (int)session.getAttribute("scheduleNumber");  //session 에 저장된 schedule number 가져오기
		System.out.println("scheduleNum: "+scheduleNum);
		
		ScheduleService service = new ScheduleService();
		service.updateScheduleShowstart(showStart, scheduleNum);
		
		RequestDispatcher rd = request.getRequestDispatcher("cansu/seatTemp.jsp");
		rd.forward(request, response);
	}

	private Date stringToDate(String myDate, String myTime) {
		
		String timeTemp = myTime+":00";
//		System.out.println(timeTemp);

		
		String showStart = myDate+" "+timeTemp;
		Timestamp temp = Timestamp.valueOf(showStart);

		Date result=new Date(temp.getTime());
		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
