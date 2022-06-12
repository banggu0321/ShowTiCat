package com.kos.showticat.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class ShowPosterUpload
 */
@WebServlet("/bang/upload.do")
public class ShowPosterUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String UPLOAD_DIR = "images";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		
		String image_dir = "/images/";
		File currentDirPath = new File(image_dir);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			for(int i = 0; i<items.size();i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString(encoding));
				}else {
					System.out.println("매개변수이름:"+fileItem.getFieldName());
					System.out.println("파일이름:"+fileItem.getName());
					System.out.println("파일크기:"+fileItem.getSize());
					if(fileItem.getSize()>0) {
						int index = fileItem.getName().lastIndexOf("\\");
						if(index == -1) {
							index = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(index+1);
						File uploadFile = new File(currentDirPath+ java.io.File.separator+fileName);
						fileItem.write(uploadFile);
						System.out.println(uploadFile.getPath());
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	

}
