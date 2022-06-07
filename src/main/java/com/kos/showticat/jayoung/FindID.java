package com.kos.showticat.jayoung;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FindID
 */
@WebServlet("/jayoung/findID.do")
public class FindID extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("findID.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_name = request.getParameter("m_name");
		String phone = request.getParameter("phone");
		
		MemberService service = new MemberService();
		MemberVO member = service.findID(m_name, phone);
		
		if(member == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('일치하는 회원 정보가 없습니다. 확인 후 다시 시도해주세요.');  location.href='findID.do';</script>");
			writer.close();
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("m_id", member.getM_id());
			
			response.sendRedirect("getID.jsp");
		}
	}

}
