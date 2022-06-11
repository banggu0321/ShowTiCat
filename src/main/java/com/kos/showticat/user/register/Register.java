package com.kos.showticat.user.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.ja0.MemberService;
import com.kos.showticat.util.DateUtil;

@WebServlet("/jayoung/insert.do")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO member = makeMember(request);
		MemberService service = new MemberService();
		
		int result = service.memberInsert(member);
		
		if(result == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('회원가입에 실패하였습니다. 확인 후 다시 시도해주세요.'); location.href='insert.do';</script>");
			writer.close();
		}else {
			request.setAttribute("m_id", member.getM_id());
			
			RequestDispatcher rd = request.getRequestDispatcher("registerResult.jsp");
			rd.forward(request, response);
		}
	}

	private MemberVO makeMember(HttpServletRequest request) {
		MemberVO m = new MemberVO();
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String email = request.getParameter("email1")+"@"+request.getParameter("email2");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
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