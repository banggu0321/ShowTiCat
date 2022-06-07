package com.kos.showticat.jayoung;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jayoung/idCheck.do")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id = request.getParameter("m_id");
		
		MemberService service = new MemberService();
		PrintWriter out = response.getWriter();
		out.print(service.checkID(m_id));
	}

}
