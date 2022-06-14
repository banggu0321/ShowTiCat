package com.kos.showticat.mypage.confirm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/confirmDeletMovieCheck.do")
public class MypageConfirmDeleteMovieCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reservation_num = Integer.parseInt(request.getParameter("reservation_num"));
		ConfirmService service = new ConfirmService();
		int result = service.CheckMovieReservation(reservation_num);

		PrintWriter out = response.getWriter();
        out.print(result);//1이면 삭제가능 0 삭제불가 
        
	}

}
