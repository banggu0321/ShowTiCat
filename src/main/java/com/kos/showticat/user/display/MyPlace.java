package com.kos.showticat.user.display;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.ja0.MemberService;

@WebServlet("/jayoung/myPlace.do")
public class MyPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		int place_num = Integer.parseInt(request.getParameter("place_num"));

		if(member != null) {
			MemberService service = new MemberService();
			
			PrintWriter out = response.getWriter();
			out.print(service.updatePlace(place_num, member.getM_id()));
			
			session.setAttribute("member", service.selectID(member.getM_id(), member.getM_pw()));
		}
	}
}
