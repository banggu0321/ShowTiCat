package com.kos.showticat.jaeyong;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.util.DateUtil;

/**
 * Servlet implementation class MemberMyPage
 */
@WebServlet("/jaeyong/memberMyPage.do")
public class MemberMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String m_id = request.getParameter("m_id");
		
		MemberVO member = new MemberVO();
		member.setM_id(m_id);

		if (member == null) {
			response.sendRedirect("../jaeyong/memberMyPage.do");
		} else {
			response.sendRedirect("../jayoung/login.do");
		}

	}

}

