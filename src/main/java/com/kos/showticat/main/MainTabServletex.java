package com.kos.showticat.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.main.vo.ShowVO;

/**
 * Servlet implementation class MainChartServlet
 */

//@WebServlet("/bang/tab.do")
public class MainTabServletex extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aa");
		TabShowService service = new TabShowService();
		List<ShowVO> showList = service.selectChartMovie();
		System.out.println(showList);
		request.setAttribute("showList",showList );
		RequestDispatcher rd = request.getRequestDispatcher("tab_Input.jsp");
		rd.forward(request, response);
		
		/*.
		ShowVO chartmovie1 = service.selectChartMovie1();
		ShowVO chartmovie2 = service.selectChartMovie2();
		ShowVO chartper1 = service.selectChartPer1();
		ShowVO chartper2 = service.selectChartPer2();
		ShowVO screenmovie1 = service.selectScreenMovie1();
		ShowVO screenmovie2 = service.selectScreenMovie2();
		ShowVO screenper1 = service.selectScreenPer1();
		ShowVO screenper2 = service.selectScreenPer2();
		
		String js1 = makeJson(chartmovie1,response);
		String js2 = makeJson(chartmovie2,response);
		String js3 = makeJson(chartper1,response);
		String js4 = makeJson(chartper2,response);
		String js5 = makeJson(screenmovie1,response);
		String js6 = makeJson(screenmovie2,response);
		String js7 = makeJson(screenper1,response);
		String js8 = makeJson(screenper2,response);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		switch(a) {
		  case 1:
			  writer.print(js1);
		    break;
		  case 2:  
			  writer.print(js2);
		    break;
		  case 3:
			  writer.print(js3);
		    break;
		  case 4:
			  writer.print(js4);
		    break;
		  case 5:
			  writer.print(js5);
		    break;
		  case 6:
			  writer.print(js6);
		    break;
		  case 7:
			  writer.print(js7);
		    break;
		  case 8:
			  writer.print(js8);
		    break;
		  default:
		    break;
		}
		*/
		
	}
	/*
	private String makeJson(ShowVO show,HttpServletResponse response) throws IOException {
		JSONObject obj = new JSONObject(); //{}
		obj.put("show_name", show.getShow_name());
		obj.put("director", show.getDirector());
		obj.put("trailer", show.getTrailer());
		obj.put("opening_date", show.getOpening_date().toString());
		obj.put("show_time", show.getShow_time());
		obj.put("category", show.getCategory());
		obj.put("summary", show.getSummary());
		obj.put("poster", show.getPoster());
		obj.put("price", show.getPrice());
		
		String jsonStr = obj.toJSONString(); //문자로
		
		return jsonStr;

	}
	 */
}
