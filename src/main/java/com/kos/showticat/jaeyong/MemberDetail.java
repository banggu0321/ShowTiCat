package com.kos.showticat.jaeyong;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.jaeyong.MemberService;
import com.kos.showticat.jaeyong.MemberVO;

/**
 * Servlet implementation class MemberDetail
 */
@WebServlet("/jaeyong/memberDetail.do")
public class MemberDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s_memberid = request.getParameter("boardid");
		int i_member = Integer.parseInt(s_memberid);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("memberDetail.jsp");
		rd.forward(request, response);
	}

}
