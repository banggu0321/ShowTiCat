package com.kos.showticat.user.display;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.VO.ReviewVO;
import com.kos.showticat.ja0.ReviewService;
import com.kos.showticat.ja0.ShowService;

@WebServlet("/jayoung/updateReview.do")
public class UpdateReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		
		ReviewService service = new ReviewService();
		ReviewVO review = service.selectReview(review_num);
		request.setAttribute("review", review);
		
		ShowService ss = new ShowService();
		request.setAttribute("show", ss.selectShow(review.getShow_code()));
		
		RequestDispatcher rd = request.getRequestDispatcher("updateReview.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		String content = request.getParameter("content");
		String grade = request.getParameter("grade");
		
		ReviewVO review = new ReviewVO(review_num, null, null, content, grade, null);
		ReviewService service = new ReviewService();
		
		int result = service.updateMyReview(review);
		
		if(result >= 1) {
			RequestDispatcher rd = request.getRequestDispatcher("../jaeyong/memberPage.jsp");
			rd.forward(request, response);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('리뷰 수정에 실패하였습니다. 확인 후 다시 시도해주세요.'); location.href='../';</script>");
			writer.close();
		}
	}

}
