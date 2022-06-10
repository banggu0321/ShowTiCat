package com.kos.showticat.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.main.vo.ShowVO;

/**
 * Servlet implementation class MainChartServlet
 */
@WebServlet("/bang/tab1.do")
public class MainChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("aa");
		TabShowService service = new TabShowService();
		List<ShowVO> showList1 = service.selectChartMovie();
		List<ShowVO> showList2 = service.selectChartPer();

		// System.out.println(showList);
		request.setAttribute("showList1", showList1);
		request.setAttribute("showList2", showList2);
		RequestDispatcher rd = request.getRequestDispatcher("mainTabDisplay.jsp");
		rd.forward(request, response);
	}
}
