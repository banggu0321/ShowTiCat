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

/**
 * Servlet implementation class ScheduleDeleteServlet
 */
@WebServlet("/jaeyong/memberDelete.do")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String m_id = member.getM_id();

		MemberService service = new MemberService();
		int result = service.Delete(m_id);
		String msg = "삭제실패";
		
		
		if (result > 0) {
			msg = "삭제성공";
			request.setAttribute("msg", msg);
			session.invalidate();
			response.sendRedirect("../");
		}else {
			
		}		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
