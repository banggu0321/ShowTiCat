package com.kos.showticat.user.display;

import java.io.IOException;
import java.sql.Date;
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

@WebServlet("/jayoung/userReservation.do")
public class UserReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show_code = request.getParameter("show_code");
		int place_num = Integer.parseInt(request.getParameter("place_num"));
		Date show_start = DateUtil.convertToDate(request.getParameter("date"));

		HttpSession session = request.getSession();
		session.setAttribute("show_code", show_code);
		session.setAttribute("place_num", place_num);
		session.setAttribute("show_start", show_start);
		
		PlaceService ps = new PlaceService();
		TheaterService ts = new TheaterService();
		ScheduleService ss = new ScheduleService();
		ShowService sss = new ShowService();

		request.setAttribute("showList", sss.selectAll());
		request.setAttribute("placeList", ps.selectByShow(show_code)); 
		request.setAttribute("theaterList", ts.selectByPlace(place_num));
		request.setAttribute("dateList", DateUtil.dateList());
		
		Map<Integer, Integer> cntMap = cntList(ss.reservCnt(place_num),ss.selectByTheater(place_num, show_start));
		request.setAttribute("cntList", cntMap);
		
		
		if(show_start.equals(DateUtil.sysdate())) { 
			request.setAttribute("list",ss.selectShowIfSysdate(place_num, show_code)); 
		} else {
			request.setAttribute("list",ss.selectShow(place_num, show_start, show_code)); 
		}
		 
		RequestDispatcher rd = request.getRequestDispatcher("userReservation.jsp");
		rd.forward(request, response);
	}
	
	private Map<Integer, Integer> cntList(Map<Integer, Integer> cntMap, List<ScheduleVO> schedule) {
		
		for(ScheduleVO s: schedule) {
			if(!cntMap.containsKey(s.getSchedule_num())) {
				cntMap.put(s.getSchedule_num(), 0);
			}
		}
		return cntMap;
	}
}