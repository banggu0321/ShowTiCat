package com.kos.showticat.jayoung;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FindID
 */
@WebServlet("/jayoung/findID.do")
public class FindID extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("findID.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_name = request.getParameter("m_name");
		String phone = request.getParameter("phone");
		
		MemberService service = new MemberService();
		MemberVO member = service.findID(m_name, phone);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		
		if(member == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('?ùºÏπòÌïò?äî ?öå?õê ?†ïÎ≥¥Í? ?óÜ?äµ?ãà?ã§. ?ôï?ù∏ ?õÑ ?ã§?ãú ?ãú?èÑ?ï¥Ï£ºÏÑ∏?öî.');  location.href='findID.do';</script>");
			writer.close();
		}else {
			response.sendRedirect("getID.jsp");
		}
	}

}
