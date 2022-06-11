package com.kos.showticat.main;

import java.io.File;
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
@WebServlet("/bang/tab2.do")
public class MainScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("aa");
		TabShowService service = new TabShowService();
		List<ShowVO> showList1 = service.selectScreenMovie();
		List<ShowVO> showList2 = service.selectScreenPer();
		// System.out.println(showList1);
		
		String filename1 = "";
		String filename2 = "";
		String image_dir = request.getSession().getServletContext().getRealPath("/") + "images"+ java.io.File.separator;
		File file1 = new File(image_dir + filename1);
		File file2 = new File(image_dir + filename2);
		String notReady = "notReady.jpg";
		// System.out.println(showList1.get(0).getPoster());

		for (int i = 0; i <= 1; i++) {
			filename1 = showList1.get(i).getPoster();
			filename2 = showList2.get(i).getPoster();
			if (file1.exists() == false) {
				showList1.get(i).setPoster(notReady);
			} else if (file2.exists() == false) {
				showList2.get(i).setPoster(notReady);
			}
		}
		/*
		 * List<ShowVO> showListnone = new ArrayList<ShowVO>(); ShowVO showListnone1 =
		 * new ShowVO("notReady", "준비중", "notReady.jpg");
		 */
		/*
		 * if (showList1.get(0).getPoster() == null) { request.setAttribute("showList1",
		 * showListnone1); } else if (showList1.get(1).getPoster() == null) {
		 * request.setAttribute("showList2", showListnone1); } else {
		 * 
		 * }
		 */

		request.setAttribute("showList1", showList1);
		request.setAttribute("showList2", showList2);

		RequestDispatcher rd = request.getRequestDispatcher("mainTabDisplay.jsp");
		rd.forward(request, response);

	}
}
