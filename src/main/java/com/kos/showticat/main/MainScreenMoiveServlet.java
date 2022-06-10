package com.kos.showticat.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainChartServlet
 */
@WebServlet("/bang/screenMovie.do")
public class MainScreenMoiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TabShowService service = new TabShowService();
		request.setAttribute("screenmovielist", service.selectScreenMovie());
		
	}

}
