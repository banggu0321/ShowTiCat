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

@WebServlet("/bang/tab1.do")
public class MainChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TabShowService service = new TabShowService();
		List<ShowVO> showList1 = service.selectChartMovie(); //chartMovie
		List<ShowVO> showList2 = service.selectChartPer(); //chartShow
		
		String notReady = "notReady.jpg";
		ShowVO noneshow = new ShowVO("#", "준비중", notReady); //ShowVO("show_code", "show_name", "poster")
		String image_dir = request.getSession().getServletContext().getRealPath("/") + "images"
				+ java.io.File.separator;

		//통계결과가 없을경우, 1개일 경우 noneshow추가
		if (showList1.size() == 0) {
			showList1.add(noneshow);
			showList1.add(noneshow);
		} else if (showList1.size() == 1) {
			showList1.add(noneshow);
		} else {}
		
		if (showList2.size() == 0) {
			showList2.add(noneshow);
			showList2.add(noneshow);
		} else if (showList2.size() == 1) {
			showList2.add(noneshow);
		} else {}

		//poster가 (실행환경)images파일에 없을 경우 notReady출력
		File file1 = new File(image_dir + showList1.get(0).getPoster());
		File file2 = new File(image_dir + showList1.get(1).getPoster());
		File file3 = new File(image_dir + showList2.get(0).getPoster());
		File file4 = new File(image_dir + showList2.get(1).getPoster());
		
		if (file1.exists() == false) {
			showList1.get(0).setPoster(notReady);
		} else {}
		if (file2.exists() == false) {
			showList1.get(1).setPoster(notReady);
		} else {}
		if (file3.exists() == false) {
			showList2.get(0).setPoster(notReady);
		} else {}
		if (file4.exists() == false) {
			showList2.get(1).setPoster(notReady);
		} else {}

		request.setAttribute("showList1", showList1);
		request.setAttribute("showList2", showList2);
		RequestDispatcher rd = request.getRequestDispatcher("mainTabDisplay.jsp");
		rd.forward(request, response);
	}
}
