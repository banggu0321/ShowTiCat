package com.kos.showticat.cansu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;

@WebServlet("/seatSampleServlet")
public class seatSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//user�� Ŭ���� ��ġ �� ��������
		Enumeration<String> seatName = request.getParameterNames();
		List<String> seatPosition = new ArrayList<>();
		
		while(seatName.hasMoreElements()) {
			seatPosition.add(request.getParameter(seatName.nextElement()));
		}
//		for(String arr: seatPosition) {
//			System.out.println(arr);
//		}
		
//���� �ܰ迡�� �ۼ��� schedule number, ID ��������
		HttpSession seesion = request.getSession();
		int scheduleNum = (int)seesion.getAttribute("scheduleNumber");
		
		MemberVO member = new MemberVO();
		member = (MemberVO) seesion.getAttribute("member");
		String m_id=member.getM_id(); 
		
//reservation number�� reservation detail table���� row ����鼭 �����
		int reservationNum = Integer.parseInt(eachChartoString(m_id, scheduleNum).substring(8)); //������ �����ȣ�� session�� ����
		seesion.setAttribute("reservationNumber", reservationNum);
		
//�Է¹��� �¼���ġ�� DB�� �ݿ�(seat_num�� �Ѱ� ���� ��Ȳ)	
		int countSeat = seatPosition.size();  //���� ���ϱ�
		seesion.setAttribute("seatNumber", countSeat);
		
		//reservation table�� row�����(�ӽ� data ����ϱ�)
		ScheduleService service = new ScheduleService();
		service.insertReservationInfor(reservationNum, m_id, scheduleNum);
		
		//reservation detail table�� row�����(�ϼ��ϱ�)
		for(String arr: seatPosition) {
			service.insertReservationDetailInfor(reservationNum, arr);
		}
		
		//����(paymentSample.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("cansu/paymentSample.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}
	
	private static String eachChartoString(String name, int number) {
		
		char[] temp = name.toCharArray();
		String result = "";
		for(char ch: temp) {
			result += (int)ch;
		}
		
//		System.out.println(result);
//		System.out.println(Integer.toString(number));
		return result.substring(0, 6)+Integer.toString(number);
	}

}
