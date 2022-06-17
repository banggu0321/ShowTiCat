package com.kos.showticat.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.admin.vo.PlaceVO;
import com.kos.showticat.admin.vo.ScheduleVO;
import com.kos.showticat.admin.vo.ShowVO;

/**
 * Servlet implementation class ScheduleInsertServlet
 */
@WebServlet("/bang/scheduleInsert.do")
public class ScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ScheduleService sService = new ScheduleService();
		List<ShowVO> slist = sService.selectShowInsertSchedule();
		List<PlaceVO> plist = sService.selectPlaceInsertSchedule();
		
		request.setAttribute("slist", slist);
		request.setAttribute("plist", plist);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("adminScheduleInsert.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ScheduleVO sc = makeSc(request);
		System.out.println(sc);
		ScheduleService service = new ScheduleService(); //2022-06-24T00:19
		int result = service.insertSchedule(sc);
		
		if(result>0) {
			response.sendRedirect("schedule.do");
		}else {
			response.sendRedirect("scheduleInsert.do");
		}	
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
		return com.kos.showticat.util.DateUtil.convertToDateTime(data); //localdate=>date로 
	}
	private int readInt(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return Integer.parseInt(data);
	}

}
