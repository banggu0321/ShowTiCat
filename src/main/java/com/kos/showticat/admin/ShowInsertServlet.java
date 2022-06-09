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
 * Servlet implementation class ScheduleInsertServlet
 */
@WebServlet("/bang/showInsert.do")
public class ShowInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면보여주기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("adminShowInsert.jsp");
		rd.forward(request, response);
	}
	//입력된 data를 DB에 저장하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		ShowVO s = makeS(request);
		ShowService service = new ShowService();
		int result = service.insertShow(s);
		request.setAttribute("message", result>0?"성공":"실패");
		if(result>0) {
			response.sendRedirect("show.do");
		}else {
			response.sendRedirect("showInsert.do");
		}		
	}
	private ShowVO makeS(HttpServletRequest request) {
		ShowVO s = new ShowVO();
		
		s.setShow_code(request.getParameter("show_code"));
		s.setShow_name(request.getParameter("show_name"));
		s.setDirector(request.getParameter("director"));
		s.setTrailer(request.getParameter("trailer"));
		s.setOpening_date(readDate(request, "opening_date"));
		s.setShow_time(readInt(request, "show_time"));
		s.setCategory(request.getParameter("category"));
		s.setSummary(request.getParameter("summary"));
		s.setPoster(request.getParameter("poster"));
		s.setPrice(readInt(request, "price"));
		
		return s;
	}
	private Date readDate(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return com.kos.showticat.util.DateUtil.convertToDate(data);
	}
	private int readInt(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return Integer.parseInt(data);
	}

}