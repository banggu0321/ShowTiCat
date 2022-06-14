package com.kos.showticat.user.display;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.ja0.CastService;
import com.kos.showticat.ja0.ChartService;
import com.kos.showticat.ja0.ReviewService;
import com.kos.showticat.ja0.ShowService;

/**
 * Servlet implementation class ShowDetail
 */
@WebServlet("/jayoung/showDetail.do")
public class ShowDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show_code = request.getParameter("show_code");
		
		if(show_code.equals("")) {
			response.sendRedirect("../");
		} else {
			ShowService service = new ShowService();
			CastService cservice = new CastService();
			ChartService cs = new ChartService();
			ReviewService rs = new ReviewService();
			
			request.setAttribute("show", service.selectShow(show_code)); 
			request.setAttribute("castList", cservice.selectCast(show_code)); 
			request.setAttribute("chart",cs.selectShow(show_code));
			request.setAttribute("reviewList",rs.selectAll(show_code));
			
			RequestDispatcher rd = request.getRequestDispatcher("showDetail.jsp");
			rd.forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
