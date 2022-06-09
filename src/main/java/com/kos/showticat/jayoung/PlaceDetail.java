package com.kos.showticat.jayoung;

import java.io.IOException;
import java.util.List;

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

		PlaceService ps = new PlaceService();
		TheaterService ts = new TheaterService();
		ScheduleService ss = new ScheduleService();
		ShowService sss = new ShowService();

		request.setAttribute("place", ps.selectByNum(place_num)); //
		request.setAttribute("placeList", ps.selectAll()); //
		request.setAttribute("showList", sss.selectAll());
		request.setAttribute("theaterList", ts.selectByPlace(place_num));
		request.setAttribute("list", ss.selectByTheater(place_num)); //
		
		RequestDispatcher rd = request.getRequestDispatcher("placeDetail.jsp");
		rd.forward(request, response);
	}
}
