package com.kos.showticat.mypage.confirm;

import java.io.IOException;
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
		System.out.println("result1:" + result1);
		System.out.println("result1:" + result2);
		boolean totalresult = (result1 > 0) && (result2 > 0);
		System.out.println(totalresult);
		request.setAttribute("message", totalresult == true ? 1 : 0);

		response.sendRedirect("../mypage/confirm.do");
	}

	//r의 rs삭제, rd모두삭제->개수가져오기, 그 개수만큼 남은자리 추가
	
	//예매시 남은자리 정보가져오는지 확인..
}
