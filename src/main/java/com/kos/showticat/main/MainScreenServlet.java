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
		// System.out.println(showList2);
		// System.out.println(showList1.get(0).getPoster());
		// System.out.println(showList1.get(1).getPoster());
		// System.out.println(showList2.get(0).getPoster());
		// System.out.println(showList2.get(1).getPoster());

		String notReady = "notReady.jpg";
		String image_dir = request.getSession().getServletContext().getRealPath("/") + "images"
				+ java.io.File.separator;
		File file1 = new File(image_dir + showList1.get(0).getPoster());
		File file2 = new File(image_dir + showList1.get(1).getPoster());
		File file3 = new File(image_dir + showList2.get(0).getPoster());
		File file4 = new File(image_dir + showList2.get(1).getPoster());
		//System.out.println(file1.exists());
		//System.out.println(file2.exists());
		//System.out.println(file3.exists());
		//System.out.println(file4.exists());

		if (file1.exists() == false) {
			showList1.get(0).setPoster(notReady);
		} else{}
		if (file2.exists() == false) {
			showList1.get(1).setPoster(notReady);
		} else{}
		if (file3.exists() == false) {
			showList2.get(0).setPoster(notReady);
		} else{}
		if (file4.exists() == false) {
			showList2.get(1).setPoster(notReady);
		} else {}

		request.setAttribute("showList1", showList1);
		request.setAttribute("showList2", showList2);
		RequestDispatcher rd = request.getRequestDispatcher("mainTabDisplay.jsp");
		rd.forward(request, response);
	}
}
