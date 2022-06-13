package com.kos.showticat.user.display;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.ja0.ReservationService;

/**
 * Servlet implementation class ReservationList
 */
@WebServlet("/jayoung/reservationList.do")
public class ReservationList extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		if(member == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용 가능합니다.');  location.href='../';</script>");
			writer.close();
			return;
		} else {
			ReservationService service = new ReservationService();
			request.setAttribute("reservationList", service.selectAll(member.getM_id()));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("reservationList.jsp");
		rd.forward(request, response);
	}

}
