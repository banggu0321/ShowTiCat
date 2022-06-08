package com.kos.showticat.admin;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.admin.vo.ShowVO;
/**
 * Servlet implementation class ShowUpdateServlet
 */
@WebServlet("/bang/showDelete.do")
public class ShowDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show_code = request.getParameter("show_code");

		ShowService service = new ShowService();
		int result = service.deleteShow(show_code);
		request.setAttribute("message", result > 0 ? "삭제성공" : "삭제실패");

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
}
