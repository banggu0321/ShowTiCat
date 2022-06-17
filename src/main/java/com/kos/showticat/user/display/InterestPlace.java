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

@WebServlet("/jayoung/interestPlace.do")
public class InterestPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		int place_num = Integer.parseInt(request.getParameter("place_num"));
		
		MemberService service = new MemberService();
		service.updatePlace(place_num, member.getM_id());
		
		session.setAttribute("member", service.selectID(member.getM_id(), member.getM_pw()));
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('관심매장이 등록되었습니다.');  location.href='../jaeyong/memberMyPage.do';</script>");
		writer.close();

	}
}
