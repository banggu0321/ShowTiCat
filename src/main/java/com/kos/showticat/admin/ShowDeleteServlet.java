package com.kos.showticat.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bang/showDelete.do")
public class ShowDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show_code = request.getParameter("show_code");

		ShowService service = new ShowService();
		int result = service.deleteShow(show_code);
		if(result > 0) {
			response.sendRedirect("show.do");
		}else {
			return ;
		}
	}
}
