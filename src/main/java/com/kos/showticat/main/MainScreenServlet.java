package com.kos.showticat.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/bang/tab2.do")
public class MainScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("aa");
		TabShowService service = new TabShowService();
		List<ShowVO> showList1 = service.selectScreenMovie();
		List<ShowVO> showList2 = service.selectScreenPer();
		System.out.println(showList1);

		File file = new File("");

		String notReady = "notReady.jpg";
		List<ShowVO> showListnone = new ArrayList<ShowVO>();
		ShowVO showListnone1 = new ShowVO("notReady", "준비중", "notReady.jpg");

		System.out.println(showList1.get(0).getPoster());

		for (int i = 1; i <= 2; i++) {
			if (showList1.get(i).getPoster() == null) {
				showList1.get(i).getPoster().compareTo(notReady) ;
			}else if(showList2.get(i).getPoster() == null) {
				showList2.get(i).setPoster(notReady) ;
			}
		}

		if (showList1.get(0).getPoster() == null) {
			request.setAttribute("showList1", showListnone1);
		} else if (showList1.get(1).getPoster() == null) {
			request.setAttribute("showList2", showListnone1);
		} else {
			request.setAttribute("showList1", showList1);
			request.setAttribute("showList2", showList2);
		}
		RequestDispatcher rd = request.getRequestDispatcher("mainTabDisplay.jsp");
		rd.forward(request, response);

	}
}
