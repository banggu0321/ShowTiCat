package com.kos.showticat.jaeyong;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.ja0.PlaceService;

/**
 * Servlet implementation class MemberMyPage
 */
@WebServlet("/jaeyong/memberMyPage.do")
public class MemberMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);		
		MemberVO member = (MemberVO) session.getAttribute("member");

		if (member == null) {
			response.sendRedirect("../jayoung/login.do");
		} else {
			PlaceService ps = new PlaceService();
			
			request.setAttribute("placeList", ps.selectAll());
			request.setAttribute("myPlace", ps.selectMyPlace(member.getM_id()));
			
			RequestDispatcher rd = request.getRequestDispatcher("../jaeyong/memberMyPage.jsp");
			rd.forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

}

