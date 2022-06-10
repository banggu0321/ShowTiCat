package com.kos.showticat.jaeyong;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.jaeyong.MemberService;
import com.kos.showticat.jaeyong.MemberVO;

/**
 * Servlet implementation class BoardlistServlet
 */
@WebServlet("/member/memberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService service = new MemberService();
//		List<MemberVO> blist = service.memberSelectAll();
		
//		request.setAttribute("memberDatas", blist);
//		request.setAttribute("memberSize", blist.size());
		//위임 (요청을 받은것은 Servletw인데 응단은 JSP가 하도록한다)
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("MemberList.jsp");
		rd.forward(request, response);
	}

	

}
