package com.kos.showticat.cansu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.jayoung.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;


@WebServlet("/jayoung/reservation.do")
public class reservationFromShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//log in check
		String logInPath = "../jayoung/main.jsp";
		
		MemberVO member = new MemberVO();
		HttpSession session = request.getSession();
		member = (MemberVO) session.getAttribute("member");
		System.out.println(member);
		if(member==null) {  //log in ���� ���Ž� main page�� ������
			response.sendRedirect(logInPath);
			return;
		}
		String m_id=member.getM_id(); //m_id �������� (ex)String m_id="cansu"; 
				
		//user ��ȭ������ �޾ƿ�
		String showCode = request.getParameter("show_code");
		System.out.println(showCode);
//		String showCode = "AA3"; //user ������ �޾Ƽ� ����
		
		// schedule number check
		int scheduleNum = 42;  		
//		int scheduleNum = 2;  //schedule ��ȣ ��������		
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum));  //id�� ���� ������ ���ڷ� ��ȯ+"scheduleNumber"
		
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);  //reservation table row ����
		
		String payment = "card"; //payment ��� ����
		int totalPrice = 2200;  //�ο��� ������  ���� �ݾ� ����(�¼� ������)
		service.updateReservationInfor(payment, totalPrice, reservationNum); //������ row�� �ʸ��� �� update
		
	}
	private static String eachChartoString(String name, int number) {
		
		char[] temp = name.toCharArray();
		String result = "";
		for(char ch: temp) {
			result += (int)ch;
		}
		
		return result.substring(0, 6)+Integer.toString(number);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
