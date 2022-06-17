package com.kos.showticat.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bang/scheduleDelete.do")
public class ScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int schedule_num = Integer.parseInt(request.getParameter("schedule_num"));
		ScheduleService service = new ScheduleService();
		int result = service.deleteSchedule(schedule_num);
		if(result >0) {
			response.sendRedirect("schedule.do");
		}else {
			return ;
		}
	}
}
