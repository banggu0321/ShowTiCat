package com.kos.showticat.jaeyong;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;

/**
 * Servlet implementation class MemberPWCheck
 */
@WebServlet("/jaeyong/memberPwCheck.do")
public class MemberPWCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String m_pw = request.getParameter("m_pw");
		PrintWriter out = response.getWriter();
		//System.out.println(m_pw);
		
		if (member.getM_pw().equals(m_pw)) {
			out.print("Y");
		} else {
			out.print("N");
		}
	}

}
