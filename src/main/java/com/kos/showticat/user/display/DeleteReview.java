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
import com.kos.showticat.ja0.ReviewService;

@WebServlet("/jayoung/deleteReview.do")
public class DeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		
		ReviewService service = new ReviewService();
		MemberService ms = new MemberService();
		
		PrintWriter out = response.getWriter();
		out.print(service.deleteMyReview(review_num)+ ms.updatePoint(member.getPoint()-500, member.getM_id()));
		
		session.setAttribute("member", ms.selectID(member.getM_id(), member.getM_pw()));
	}
}
