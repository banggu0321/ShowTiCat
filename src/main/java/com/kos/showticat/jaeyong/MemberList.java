package com.kos.showticat.jaeyong;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/jaeyong/memberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		request.setAttribute("mlist", service.selectAll());
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("memberUpdate.jsp");
		rd.forward(request, response);
	}
}