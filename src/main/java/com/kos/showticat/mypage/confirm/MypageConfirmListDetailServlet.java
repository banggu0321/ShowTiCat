package com.kos.showticat.mypage.confirm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kos.showticat.mypage.confirm.vo.ConfirmVO;

@WebServlet("/mypage/confirmdetail.do")
public class MypageConfirmListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int reservation_num = Integer.parseInt(request.getParameter("reservation_num"));
		//System.out.println(reservation_num);
		
		ConfirmService service = new ConfirmService();
		ConfirmVO detail = service.selectDetailReservation(reservation_num);
		
		//JSON 객체 만들기
		JSONObject obj = new JSONObject(); //{}
		obj.put("reservation_num", detail.getReservation_num());
		obj.put("place_name", detail.getPlace_name());
		obj.put("theater_num", detail.getTheater_num());
		obj.put("theater_type", detail.getTheater_type());
		obj.put("price", detail.getPrice());
		obj.put("payment", detail.getPayment());
		obj.put("total_price", detail.getTotal_price());
		
		String jsonStr = obj.toJSONString(); //문자로

		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonStr);
	}

}
