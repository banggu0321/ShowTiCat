package com.kos.showticat.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bang/showDeleteCheck.do")
public class ShowDeleteCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show_code = request.getParameter("show_code");
        if(show_code==null) return ;
        System.out.println("show_code:" + show_code);
        //DB에 직원id가 존재하는지 체크한다. ???empService->empDAO-->DB
        ShowService service = new ShowService();
        int result = service.selectBuyShow(show_code);
        PrintWriter out = response.getWriter();
        out.print(result);//0이면 등록가능 1이면 등록불가 
        
	}
}
