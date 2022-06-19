package com.kos.showticat.cansu;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;

@WebServlet("/jayoung/reservation.do")
public class rsSwitchShowTheater extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//log in check
		String logInPath = "../jayoung/login.do";
		HttpSession session = request.getSession();

		MemberVO member = new MemberVO();
		member = (MemberVO) session.getAttribute("member");
		System.out.println(member);
		if(member==null) {  //log in 
			response.sendRedirect(logInPath);
			return;
		}

		Enumeration<String> temp = request.getParameterNames();
		while(temp.hasMoreElements()) {
			String name = temp.nextElement();
			System.out.println(name);

			if (name.equals("schedule_num")) {
				String schedulNum = (String)request.getParameter("schedule_num");
				request.setAttribute("scheduleNum", schedulNum);

				RequestDispatcher rd = request.getRequestDispatcher("/reservationFromTheater");
				rd.forward(request, response);
			}

			if(name.equals("show_code")) {
				String showCode = (String)request.getParameter("show_code");
				request.setAttribute("showCode", showCode);

				RequestDispatcher rd = request.getRequestDispatcher("/reservationFromShowList");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
