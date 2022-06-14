package com.kos.showticat.jaeyong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScheduleDeleteServlet
 */
@WebServlet("/jaeyong/memberDelete.do")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id = request.getParameter("m_id");

		MemberService service = new MemberService();
		int result = service.Delete(m_id);
		request.setAttribute("msg", result > 0 ? "삭제성공" : "삭제실패");

		response.sendRedirect("memberDetail.do");
	}
}
