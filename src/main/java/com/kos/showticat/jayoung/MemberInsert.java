package com.kos.showticat.jayoung;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.jayoung.DateUtil;

@WebServlet("/jayoung/insert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = makeMember(request);
		MemberService service = new MemberService();

		request.setAttribute("msg", service.memberInsert(member)>0?"?���?":"?��?��");
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

	private MemberVO makeMember(HttpServletRequest request) {
		MemberVO m = new MemberVO();
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		m.setBirth(DateUtil.convertToDate(birth));
		m.setEmail(email);
		m.setGender(gender);
		m.setM_id(m_id);
		m.setM_name(m_name);
		m.setM_pw(m_pw);
		m.setPhone(phone);
		
		return m;
	}

}
