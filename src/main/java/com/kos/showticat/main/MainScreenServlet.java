package com.kos.showticat.main;

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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aa");
		TabShowService service = new TabShowService();
		List<ShowVO> showList1 = service.selectScreenMovie();
		List<ShowVO> showList2 = service.selectScreenPer();
		List showListnone = new ArrayList();
		//showListnone = ["":"","":"","":""]; 준비중
		
		//System.out.println(showList);
		
		if (showList1 == null) {
			request.setAttribute("showList1",showListnone);
		}else if(showList2 == null){
			request.setAttribute("showList2",showListnone);
		}else {
			request.setAttribute("showList1",showList1 );
			request.setAttribute("showList2",showList2 );
		}
		RequestDispatcher rd = request.getRequestDispatcher("mainTabDisplay.jsp");
		rd.forward(request, response);
			
	}

}
