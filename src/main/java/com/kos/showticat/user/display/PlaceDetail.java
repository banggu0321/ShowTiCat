package com.kos.showticat.user.display;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.ja0.PlaceService;
import com.kos.showticat.ja0.ScheduleService;
import com.kos.showticat.ja0.ShowService;
import com.kos.showticat.ja0.TheaterService;
import com.kos.showticat.util.DateUtil;

@WebServlet("/jayoung/placeDetail.do")
public class PlaceDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int place_num = Integer.parseInt(request.getParameter("place_num"));
		/* Date show_start = DateUtil.convertToDate(request.getParameter("date")); */

		PlaceService ps = new PlaceService();
		TheaterService ts = new TheaterService();
		ScheduleService ss = new ScheduleService();
		ShowService sss = new ShowService();

		request.setAttribute("place", ps.selectByNum(place_num)); 
		request.setAttribute("placeList", ps.selectAll()); 
		request.setAttribute("showList", sss.selectAll());
		request.setAttribute("theaterList", ts.selectByPlace(place_num));  //select * from theater where place_num=?
		request.setAttribute("list", ss.selectByTheater(place_num/* , show_start */));  
		
//		SQL_SELECT_THEATER ="SELECT SHOW_CODE,SHOW_NAME,schedule_num,theater_num,s.place_num, show_start "
//				+ " FROM schedule s JOIN show using(show_code) JOIN theater using(theater_num)"
//				+ " where s.place_num=? ORDER BY 2,4,6"

		request.setAttribute("dateList", DateUtil.dateList());  //year Calendar.DATE+1 nowDay(7)

		
		//		
		RequestDispatcher rd = request.getRequestDispatcher("placeDetail.jsp");
		rd.forward(request, response);
	}
}
