package com.kos.showticat.jaeyong;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.jaeyong.MemberService;
import com.kos.showticat.util.DateUtil;

/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/jaeyong/memberDelete.do")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m_id = request.getParameter("m_id");
		
		MemberService service = new MemberService();
		int result = service.Delete(m_id);
		request.setAttribute("message", result>0?
				"삭제성공"
				:"삭제실패");
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
}