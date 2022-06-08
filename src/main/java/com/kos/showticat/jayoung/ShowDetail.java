package com.kos.showticat.jayoung;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDetail
 */
@WebServlet("/jayoung/showDetail.do")
public class ShowDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show_code = request.getParameter("show_code");
		
		ShowService service = new ShowService();
		CastService cservice = new CastService();
		request.setAttribute("show", service.selectShow(show_code)); 
		request.setAttribute("castList", cservice.selectCast(show_code)); 
		
		
		RequestDispatcher rd = request.getRequestDispatcher("showDetail.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}