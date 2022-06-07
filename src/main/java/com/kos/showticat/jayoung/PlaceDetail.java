package com.kos.showticat.jayoung;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jayoung/placeDetail.do")
public class PlaceDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int place_num = Integer.parseInt(request.getParameter("place_num"));

		ShowService shows = new ShowService();
		PlaceService ps = new PlaceService();
		ScheduleService ss = new ScheduleService();
		request.setAttribute("scheduleList", ss.selectByPlace(place_num));
		request.setAttribute("showList", shows.selectAll());
		request.setAttribute("placeList", ps.selectAll());
		//theaterList 추가
		request.setAttribute("place", ps.selectByNum(place_num));

		
		RequestDispatcher rd = request.getRequestDispatcher("placeDetail.jsp");
		rd.forward(request, response);
	}
}
