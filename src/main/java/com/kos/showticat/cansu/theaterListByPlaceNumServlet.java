package com.kos.showticat.cansu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.reservation.dao.temp.ScheduleService;
import com.kos.showticat.reservation.dao.temp.TheaterVO;

@WebServlet("/theaterListByPlaceNumServlet")
public class theaterListByPlaceNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ScheduleService service = new ScheduleService();
		List<TheaterVO> pList = new ArrayList<>();
		
		System.out.println(request.getParameter("placeNumber"));
		int placenum = Integer.parseInt(request.getParameter("placeNumber"));		
		pList = service.selectTheaterByPlaceNum(placenum);
		request.setAttribute("theaterByNumber", pList);
		
		//ю╖юс
		RequestDispatcher rd = request.getRequestDispatcher("cansu/theaterListByNumber.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
