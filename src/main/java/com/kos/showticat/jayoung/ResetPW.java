package com.kos.showticat.jayoung;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jayoung/resetPW.do")
public class ResetPW extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("reserPW.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id = request.getParameter("m_id");
		String new_pw = request.getParameter("m_pw");
		
		MemberService service = new MemberService();
		int result = service.resetPW(m_id, new_pw);
		if(result > 0) {
			request.setAttribute("msg", "성공");
			
			HttpSession session = request.getSession();
			session.invalidate();
		} else {
			request.setAttribute("msg", "실패");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
