package com.kos.showticat.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.admin.vo.ShowVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ScheduleInsertServlet
 */
@WebServlet("/bang/showInsert.do")
public class ShowInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 화면보여주기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("adminShowInsert.jsp");
		rd.forward(request, response);
	}

	// 입력된 data를 DB에 저장하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String applicationPath = request.getSession().getServletContext().getRealPath(".");
		//String applicationPathStr = applicationPath.substring(0,30);
		
		//int index = applicationPath.indexOf(".");
		//System.out.println(index);
		//String dstr  = 
		//String tstr = applicationPath.substring(30,);
		//System.out.println(dstr);
		//System.out.println(tstr);
		
		
		String UPLOAD_DIR = "images";
		String location = applicationPath + File.separator + UPLOAD_DIR + File.separator;
		//System.out.println(applicationPath);
		System.out.println(location);
		int maxSize = 1024 * 1024 * 5;
		
		MultipartRequest multi = new MultipartRequest(request, location, maxSize, "utf-8",
				new DefaultFileRenamePolicy());
		String fileName = multi.getFilesystemName("file");
		System.out.println(fileName);

		ShowVO s = makeS(multi, fileName);
		ShowService service = new ShowService();
		int result = service.insertShow(s);
		request.setAttribute("message", result > 0 ? "성공" : "실패");
		if (result > 0) {
			response.sendRedirect("show.do");
		} else {
			response.sendRedirect("showInsert.do");
		}
	}

	private ShowVO makeS(MultipartRequest request, String fileName) {
		ShowVO s = new ShowVO();
		//System.out.println(fileName);
		s.setShow_code(request.getParameter("show_code"));
		s.setShow_name(request.getParameter("show_name"));
		s.setDirector(request.getParameter("director"));
		s.setTrailer(request.getParameter("trailer"));
		s.setOpening_date(readDate(request, "opening_date"));
		s.setShow_time(readInt(request, "show_time"));
		s.setCategory(request.getParameter("category"));
		s.setSummary(request.getParameter("summary"));
		s.setPoster(fileName);
		// s.setPoster(request.getParameter("poster"));
		s.setPrice(readInt(request, "price"));

		return s;
	}

	private Date readDate(MultipartRequest request, String column) {
		String data = request.getParameter(column);
		return com.kos.showticat.util.DateUtil.convertToDate(data);
	}

	private int readInt(MultipartRequest request, String column) {
		String data = request.getParameter(column);
		return Integer.parseInt(data);
	}

}