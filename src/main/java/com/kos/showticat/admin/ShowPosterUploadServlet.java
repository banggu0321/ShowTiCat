package com.kos.showticat.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kos.showticat.util.UploadFileHelper;


/**
 * Servlet implementation class ShowPosterUpload
 */
@WebServlet("/upload.do")
public class ShowPosterUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "images";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getServletContext().getRealPath(UPLOAD_DIR);
		System.out.println("웹서버의 실제 경로 : " + dir); 
		//MultipartRequest multi=new MultipartRequest(request,dir,5*1024*1024,"UTF-8",new DefaultFileRenamePolicy()); 
		//upload추가 List<String> photos = for(String
		 /* fileName:photos) { System.out.println(fileName); }
		 */
		
		 Map<String,Object> map = UploadFileHelper.uploadFile(UPLOAD_DIR, request);
		 List<String> photos = (List<String>)map.get("photos");
		 System.out.println(photos);
		 
		 Map<String,String> params = (Map<String,String>)map.get("params");
		 for(String key:params.keySet()) {
			 System.out.println(key+"---"+params.get(key));
		 }
		 //DB에 insert하는 작업
	}	

}
