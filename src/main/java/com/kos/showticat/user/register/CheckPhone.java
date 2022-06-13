package com.kos.showticat.user.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.ja0.MemberService;

@WebServlet("/jayoung/phoneCheck.do")
public class CheckPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		
		MemberService service = new MemberService();
		PrintWriter out = response.getWriter();
		out.print(service.checkPhone(phone));
	}

}
