package com.kos.showticat.cansu;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;
import com.kos.showticat.reservation.dao.temp.ScheduleService;


@WebServlet("/jayoung/reservation.do")
public class reservationFromShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//log in check
		String logInPath = "../jayoung/main.jsp";
		HttpSession session = request.getSession();
		
		MemberVO member = new MemberVO();
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
		
		// schedule number�� session�� ����
		int scheduleNum = createScheduleNumber(m_id);  		
		session.setAttribute("scheduleNumber", scheduleNum); //session�������� �ڽ��� scheduleNumberã��
		
		ScheduleService service = new ScheduleService();
		service.insertScheduleInforNum(scheduleNum, showCode);
		System.out.println("create schedule");
		
		//����(���弱��)
		RequestDispatcher rd = request.getRequestDispatcher("/placeListServilet");
		rd.forward(request, response);
		
	}
	private static int createScheduleNumber(String mID) {
		
//		System.out.println(mID);
		int dayNum = calendartoString();
//		System.out.println(dayNum);
		String scheduleNum = eachChartoString(mID, dayNum);

		return Integer.parseInt(scheduleNum.substring(3, scheduleNum.length()));
		
	}

	private static int calendartoString() {
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);
		int nowMonth = now.get(Calendar.MONTH)+1;
		int nowDay = now.get(Calendar.DATE);
		int nowHour = now.get(Calendar.HOUR);
		int nowMinute = now.get(Calendar.MINUTE);
//		System.out.println(nowYear+"-"+nowMonth+"-"+nowDay+" "+nowHour+":"+nowMinute);
		
		String dayNum = Integer.toString(nowMonth)+Integer.toString(nowDay)+Integer.toString(nowHour)+Integer.toString(nowMinute);
//		System.out.println(dayNum);
		return Integer.parseInt(dayNum);
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
