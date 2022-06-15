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

import com.kos.showticat.reservation.dao.temp.ScheduleService;
import com.kos.showticat.reservation.dao.temp.ScheduleVO;
import com.kos.showticat.reservation.dao.temp.ShowVO;

@WebServlet("/reservationFromSListUSchedule")
public class reservationFromSListUSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String showCode = String.valueOf(session.getAttribute("showCode"));
//		System.out.println(showCode);
		
		ScheduleService service = new ScheduleService();
		ShowVO svo = service.selectShowByShowcode(showCode);
		request.setAttribute("show", svo);
		
		RequestDispatcher rd = request.getRequestDispatcher("cansu/theaterListUpdateSchedule.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
