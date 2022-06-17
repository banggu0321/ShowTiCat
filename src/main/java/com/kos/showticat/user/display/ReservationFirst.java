package com.kos.showticat.user.display;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.ScheduleVO;
import com.kos.showticat.ja0.PlaceService;
import com.kos.showticat.ja0.ScheduleService;
import com.kos.showticat.ja0.ShowService;
import com.kos.showticat.ja0.TheaterService;
import com.kos.showticat.util.DateUtil;

@WebServlet("/jayoung/reservationFirst.do")
public class ReservationFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlaceService ps = new PlaceService();
		ShowService sss = new ShowService();

		request.setAttribute("showList", sss.selectAll());
		request.setAttribute("placeList", ps.selectAll()); 
		request.setAttribute("dateList", DateUtil.dateList());
		 
		RequestDispatcher rd = request.getRequestDispatcher("reservationFirst.jsp");
		rd.forward(request, response);
	}

}