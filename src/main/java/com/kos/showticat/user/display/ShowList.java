package com.kos.showticat.user.display;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.jayoung.ShowService;

@WebServlet("/jayoung/showList.do")
public class ShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		HttpSession session = request.getSession();
		session.setAttribute("category", category);
		
		ShowService service = new ShowService();
		request.setAttribute("showList", service.selectCategory(category));
		
		RequestDispatcher rd = request.getRequestDispatcher("showList.jsp");
		rd.forward(request, response);
	}
}
