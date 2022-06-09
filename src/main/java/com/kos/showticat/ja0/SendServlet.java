package com.kos.showticat.ja0;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jayoung/randomNumCheck.do")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		//System.out.println(phone);

		int randomNum = makeRandomNum();
		/*try {
			randomNum = SendSMS.send(phone);
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}*/
		//System.out.println(randomNum);
		
		PrintWriter out = response.getWriter();
		out.print(randomNum);
	
	}
	private static int makeRandomNum() {
		return ThreadLocalRandom.current().nextInt(100000, 1000000);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
