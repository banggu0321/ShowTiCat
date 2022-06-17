package com.kos.showticat.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bang/scheduleDeleteCheck.do")
public class ScheduleDeleteCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schedule_num = request.getParameter("schedule_num");
        if(schedule_num==null)  return ;
        int i_schedule_num = Integer.parseInt(schedule_num);
		
		ScheduleService service = new ScheduleService();
        int result = service.selectBuySchedule(i_schedule_num);
        PrintWriter out = response.getWriter();
        out.print(result);//0 -> 삭제가능, 1이상 -> 삭제불가    
	}
}
