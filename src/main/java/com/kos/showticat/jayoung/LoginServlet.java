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

@WebServlet("/jayoung/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		MemberService service = new MemberService();
		MemberVO member = service.selectID(m_id, m_pw);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		String path = (String)session.getAttribute("reqPath");
		
		if(member == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('?ïÑ?ù¥?îî/ÎπÑÎ?Î≤àÌò∏ ?ôï?ù∏ ?õÑ ?ã§?ãú Î°úÍ∑∏?ù∏?ï¥Ï£ºÏÑ∏?öî.');  location.href='login.do';</script>");
			writer.close();
		}else {
			if(path==null) path = request.getContextPath() + "/jayoung/main.jsp";
			response.sendRedirect(path);
		}
	}
}
