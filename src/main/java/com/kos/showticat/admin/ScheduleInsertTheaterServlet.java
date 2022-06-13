package com.kos.showticat.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.admin.vo.TheaterVO;

/**
 * Servlet implementation class ScheduleInsertTheaterServlet
 */
@WebServlet("/bang/scheduleInsertTheater.do")
public class ScheduleInsertTheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println(request.getParameter("place_num").getClass().getName());
		int place_num = Integer.parseInt(request.getParameter("place_num"));
		//System.out.println(show_code);
		
		ScheduleService sService = new ScheduleService();
		List<TheaterVO> tlist = sService.selectTheaterInsertSchedule(place_num);
		request.setAttribute("tlist", tlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("adminScheduleInsertTheater.jsp");
		rd.forward(request, response);
	}
}
