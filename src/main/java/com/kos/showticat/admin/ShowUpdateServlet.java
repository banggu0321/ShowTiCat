package com.kos.showticat.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kos.showticat.admin.vo.ShowVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/bang/showUpdate.do")
public class ShowUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String show_code = request.getParameter("show_code");
		
		ShowService service = new ShowService();
		ShowVO show = service.selectByCode(show_code);
		
		JSONObject obj = new JSONObject();
		obj.put("show_name", show.getShow_name());
		obj.put("director", show.getDirector());
		obj.put("trailer", show.getTrailer());
		obj.put("opening_date", show.getOpening_date().toString());
		obj.put("show_time", show.getShow_time());
		obj.put("category", show.getCategory());
		obj.put("summary", show.getSummary());
		obj.put("poster", show.getPoster());
		obj.put("price", show.getPrice());
		
		String jsonStr = obj.toJSONString();

		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String applicationPath = request.getSession().getServletContext().getRealPath(".");
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
		int result = service.updateShow(s);
		if(result > 0) {
			request.setAttribute("message","??????");
			response.sendRedirect("show.do");
		}else {
			request.setAttribute("message","??????");
			response.sendRedirect("show.do");
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
