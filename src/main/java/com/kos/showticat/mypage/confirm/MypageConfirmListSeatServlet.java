package com.kos.showticat.mypage.confirm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.mypage.confirm.vo.ReservDetailVO;


@WebServlet("/mypage/confirmSeat.do")
public class MypageConfirmListSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reservation_num = Integer.parseInt(request.getParameter("reservation_num"));
		System.out.println(reservation_num);
		ConfirmService service = new ConfirmService();
		List<ReservDetailVO> list = service.selectSeatNum(reservation_num);
		request.setAttribute("seatlist", list);
		
		//response.
		//Writer().append("Served at: ").append(request.getContextPath());
		//Response.
	}
}
