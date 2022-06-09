package com.kos.showticat.user.display;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.ja0.ShowService;

@WebServlet("/jayoung/showAllList.do")
public class ShowAllList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowService service = new ShowService();
		request.setAttribute("showList", service.selectAll());
		
		RequestDispatcher rd = request.getRequestDispatcher("showAllList.jsp");
		rd.forward(request, response);
	}
}
