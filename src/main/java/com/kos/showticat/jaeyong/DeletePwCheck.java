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
 * Servlet implementation class deletePwCheck
 */
@WebServlet("/jaeyong/deletePwCheck.do")
public class DeletePwCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("DeletePwCheck.jsp");
		rd.forward(request, response);
	}
}
