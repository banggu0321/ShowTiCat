package com.kos.showticat.jayoung;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jayoung/showList.do")
public class ShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowService service = new ShowService();
		request.setAttribute("showList", service.selectAll());
		
		RequestDispatcher rd = request.getRequestDispatcher("showList.jsp");
		rd.forward(request, response);
	}
}
