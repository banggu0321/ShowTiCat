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

@WebServlet("/jayoung/insertReview.do")
public class InsertReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show_code = request.getParameter("show_code");
		
		ShowService service = new ShowService();
		request.setAttribute("show", service.selectShow(show_code));
		
		RequestDispatcher rd = request.getRequestDispatcher("insertReview.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewVO review = makeReview(request);
		ReviewService service = new ReviewService();
		
		int result = service.insertReview(review);
		
		if(result >= 1) {
			RequestDispatcher rd = request.getRequestDispatcher("myReview.do");
			rd.forward(request, response);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('리뷰 등록에 실패하였습니다. 확인 후 다시 시도해주세요.'); location.href='../';</script>");
			writer.close();
		}
	}


	private ReviewVO makeReview(HttpServletRequest request) {
		ReviewVO review = new ReviewVO();
		
		String show_code = request.getParameter("show_code");
		String m_id = request.getParameter("m_id");
		String content = request.getParameter("content");
		String grade = request.getParameter("grade");
		
		review.setContent(content);
		review.setGrade(grade);;
		review.setM_id(m_id);
		review.setShow_code(show_code);

		return review;
	}

}
