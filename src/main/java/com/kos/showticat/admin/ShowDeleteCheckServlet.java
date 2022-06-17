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

		ShowService service = new ShowService();
        int result = service.selectBuyShow(show_code);
        PrintWriter out = response.getWriter();  
        out.print(result); //0 -> 삭제가능, 1이상 -> 삭제불가
        
	}
}
