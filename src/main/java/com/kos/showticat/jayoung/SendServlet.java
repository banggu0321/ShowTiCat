package com.kos.showticat.jayoung;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.nurigo.java_sdk.exceptions.CoolsmsException;

@WebServlet("/jayoung/randomNumCheck.do")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String phone = request.getParameter("phone");

		int randomNum = 0;
		try {
			randomNum = SendSMS.send(phone);
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.print(randomNum);
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
