package com.kos.showticat.mypage.confirm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/confirm.do")
public class MypageConfirmListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m_id = "bang";
		ConfirmService service = new ConfirmService();
		request.setAttribute("resevationlist", service.selectAllReservation(m_id));

		RequestDispatcher rd;
		rd = request.getRequestDispatcher("../bang/mypageConfirm.jsp");
		rd.forward(request, response);
		
		
		/*
		HttpSession session = request.getSession(false);
		MemberVO member = (MemberVO) session.getAttribute("member");

		if (member == null) {
			String path = request.getContextPath();
			response.sendRedirect(path);

		} else {
			
			String m_id = member.getM_id();
			System.out.println(m_id);
			ConfirmService service = new ConfirmService();
			request.setAttribute("resevationlist", service.selectAllReservation(m_id));
			System.out.println(request);

			RequestDispatcher rd;
			rd = request.getRequestDispatcher("../bang/mypageConfirm.jsp");
			rd.forward(request, response);
		}*/
	}


}
