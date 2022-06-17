package com.kos.showticat.mypage.confirm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MypageConfirmDeleteServlet
 */
@WebServlet("/mypage/confirmDelete.do")
public class MypageConfirmDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reservation_num = Integer.parseInt(request.getParameter("reservation_num"));

		ConfirmService service = new ConfirmService();
		int result1 = service.updateReservation(reservation_num);
		int result2 = service.DeleteSeat(reservation_num);
		//System.out.println("result1:" + result1); 
		//System.out.println("result2:" + result2);

		PrintWriter out = response.getWriter();
        out.print((result1 > 0) && (result2 > 0) ? 1 : 0);//1이상 삭제가능 0 삭제불가 
	}
}
