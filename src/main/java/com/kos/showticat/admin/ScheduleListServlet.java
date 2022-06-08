package com.kos.showticat.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminScheduleList
 */
@WebServlet("/bang/show.do")
public class ScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowService service = new ShowService();
		request.setAttribute("showlist", service.selectAllShow());
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("adminShow.jsp");
		rd.forward(request, response);
	}
}
