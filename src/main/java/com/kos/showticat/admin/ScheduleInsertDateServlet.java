package com.kos.showticat.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kos.showticat.admin.vo.ShowVO;


@WebServlet("/bang/scheduleInsertDate.do")
public class ScheduleInsertDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String show_code = request.getParameter("show_code");
		ScheduleService sService = new ScheduleService();
		ShowVO show = sService.selectOpeningdateInsertSchedule(show_code);
		
		JSONObject obj = new JSONObject(); 
		obj.put("show_name", show.getShow_name());
		obj.put("opening_date", show.getOpening_date().toString());
		
		String jsonStr = obj.toJSONString(); 

		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonStr);
	}
}
