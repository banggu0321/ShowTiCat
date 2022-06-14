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
		
	}

	//r의 rs삭제, rd모두삭제->개수가져오기, 그 개수만큼 남은자리 추가
	
	//예매시 남은자리 정보가져오는지 확인..
}
