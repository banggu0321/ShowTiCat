package com.kos.showticat.jaeyong;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScheduleDeleteServlet
 */
@WebServlet("/jaeyong/memberDelete.do")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id = request.getParameter("m_id");

		MemberService service = new MemberService();
		int result = service.Delete(m_id);
		String msg = "삭제실패";
		if (result > 0) {
			msg = "삭제실패";
			request.setAttribute("msg", msg);
		}

		response.sendRedirect("../");
	}
}
