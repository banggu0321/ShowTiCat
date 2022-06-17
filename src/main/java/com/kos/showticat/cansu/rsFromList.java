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

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.cansu.dao.ReservationVO;
import com.kos.showticat.cansu.ScheduleService;

@WebServlet("/reservationFromList")
public class rsFromList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//log in check -> get id
		String logInPath = "jayoung/login.do";
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		member = (MemberVO) session.getAttribute("member");
//		System.out.println(member);
		if(member==null) {  
			response.sendRedirect(logInPath);
			return;
		}
		String m_id=member.getM_id();
		System.out.println("ID: "+m_id);
		
		//id -> reservation list
		ScheduleService service = new ScheduleService();
		List<ReservationVO> rList = new ArrayList<>();
		
		rList = service.selectReservationByID(m_id);
		session.setAttribute("reservationList", rList);
		
		for(ReservationVO temp: rList) {
			System.out.println(temp);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("cansu/reservationList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
