package com.kos.showticat.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;

/**
 * Servlet implementation class AdminScheduleList
 */
@WebServlet("/bang/schedule.do")
public class ScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ScheduleService service = new ScheduleService();
		request.setAttribute("schedulelist", service.selectAllSchedule());
		
		//HttpSession session = request.getSession(false);
		//System.out.println((String)session.getAttributeNames());
		//System.out.println(session.getId());
		//MemberVO member = (MemberVO)session.getAttribute("member");
		//System.out.println(member);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("adminSchedule.jsp");
		rd.forward(request, response);
	}
}
