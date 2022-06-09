package com.kos.showticat.user.findMember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.jayoung.MemberService;

@WebServlet("/jayoung/resetPW.do")
public class ResetPW extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("resetPW.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m_id = request.getParameter("m_id");
		String new_pw = request.getParameter("m_pw");
		
		MemberService service = new MemberService();
		int result = service.resetPW(m_id, new_pw);
		
		if(result == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('비밀번호 수정에 실패하였습니다. 확인 후 다시 시도해주세요.'); location.href='resetPW.do';</script>");
			writer.close();
		}else {		
			RequestDispatcher rd = request.getRequestDispatcher("resetPWResult.jsp");
			rd.forward(request, response);
		}
	}

}
