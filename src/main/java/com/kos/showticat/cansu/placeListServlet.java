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
import javax.servlet.http.HttpSession;

import com.kos.showticat.reservation.dao.temp.PlaceVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/placeListServilet")
public class placeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ScheduleService service = new ScheduleService();
		List<PlaceVO> pList = new ArrayList<>();
		pList = service.selectALLPlace();
		
//		HttpSession session = request.getSession();
//		session.setAttribute("placeList", pList);
		request.setAttribute("placeList", pList);
		
		//ю╖юс(placeList.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("cansu/placeList.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
