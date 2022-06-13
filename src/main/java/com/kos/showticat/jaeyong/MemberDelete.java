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
 * Servlet implementation class MemberDelete
 */
@WebServlet("/jaeyong/memberDelete.do")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("memberPage.jsp");
			rd.forward(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String m_id = request.getParameter("m_id"); //삭제할 아이디를 갖고옴
		
		MemberVO member = new MemberVO();
		
		member.setM_id(m_id);		
		
		System.out.println(m_id);
		
		MemberService service = new MemberService();
		int result = service.Delete(m_id); //삭제
		
		request.setAttribute("message", result>0?"삭제성공":"삭제실패");
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("memberPage.jsp");
		rd.forward(request, response);
	}
}