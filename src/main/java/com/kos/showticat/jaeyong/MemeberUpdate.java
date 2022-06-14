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

import com.kos.showticat.util.DateUtil;

/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/jaeyong/memberUpdate.do")
public class MemeberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("memberUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String point = request.getParameter("point");

		MemberVO member = new MemberVO();
		member.setM_id(m_id);
		member.setM_pw(m_pw);
		member.setM_name(m_name);
		member.setEmail(email);
		member.setPhone(phone);
		member.setBirth(DateUtil.convertToDate(birth));
		member.setGender(gender);
		member.setPoint(Integer.parseInt(point));
		MemberService service = new MemberService();
		int result = service.memberUpdate(member);
		
		String msg = "수정실패";
		if (result > 0) {
			msg = "수정성공";
			request.setAttribute("msg", msg);
			session.setAttribute("member", member);
		}

		RequestDispatcher rd;
		rd = request.getRequestDispatcher("../");
		rd.forward(request, response);

	}
}
