package com.kos.showticat.admin;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.admin.vo.ScheduleVO;

/**
 * Servlet implementation class ScheduleInsertServlet
 */
@WebServlet("/bang/scheduleInsert.do")
public class ScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScheduleService sService = new ScheduleService();
		
		
		// 화면보여주기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("adminScheduleInsert.jsp");
		rd.forward(request, response);
	}
	//입력된 data를 DB에 저장하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ScheduleVO sc = makeSc(request);
		ScheduleService service = new ScheduleService();
		int result = service.insertSchedule(sc);
		request.setAttribute("message", result>0?"성공":"실패");
		response.sendRedirect("schedule.do");
	}
	private ScheduleVO makeSc(HttpServletRequest request) {
		ScheduleVO sc = new ScheduleVO();
		
		sc.setShow_code(request.getParameter("show_code"));
		sc.setTheater_num(request.getParameter("theater_num"));
		sc.setPlace_num(readInt(request, "place_num"));
		sc.setShow_start(readDate(request, "show_start"));
		
		return sc;
	}
	private Date readDate(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return com.kos.showticat.util.DateUtil.convertToDate(data);
	}
	private int readInt(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return Integer.parseInt(data);
	}

}
