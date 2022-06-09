package com.kos.showticat.user.display;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.ja0.ShowService;
import com.kos.showticat.ja0.ShowVO;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/jayoung/result.do")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("search");
		request.setAttribute("word", word);
		
		ShowService service = new ShowService();
		List<ShowVO> sList = service.selectSearch(word);
		
		if(!sList.isEmpty()) request.setAttribute("result", sList);
		
		RequestDispatcher rd = request.getRequestDispatcher("searchResult.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
