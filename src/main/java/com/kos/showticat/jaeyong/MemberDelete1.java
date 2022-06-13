package com.kos.showticat.jaeyong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowUpdateServlet
 */
@WebServlet("/jaeyong/memberDelete1.do")
public class MemberDelete1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member = request.getParameter("member");

		MemberService service = new MemberService();
		int result = service.Delete(member);
		request.setAttribute("message", result > 0 ? "삭제성공" : "삭제실패");

		response.sendRedirect("result");
	}
}
