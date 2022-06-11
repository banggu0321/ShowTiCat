package com.kos.showticat.user.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


@WebServlet("/jayoung/sendSMS.do")
public class SendSMS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		//System.out.println(phone);

		int randomNum = makeRandomNum();
		System.out.println(randomNum);
		
		try {
			sendMsg(phone,randomNum);
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.print(randomNum);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private static void sendMsg(String to, int randomNum) throws CoolsmsException{
	    String api_key = "NCSM6JCJ07YIKIIB";
	    String api_secret = "J7YMPLUUCIC3E3OX5BNDQDGNLE1H1GDJ";
	    Message coolsms = new Message(api_key, api_secret);

	    HashMap<String, String> params = new HashMap<String, String>();	
	    params.put("to", to);
	    params.put("from", "1111");
	    params.put("type", "SMS");
	    params.put("text", "[Show TiCat]�씤利앸쾲�샇 "+randomNum+"瑜� �엯�젰�븯�꽭�슂.");
	    params.put("app_version", "test app 1.2"); // application name and version
	
//	    try {
//	      JSONObject obj = (JSONObject) coolsms.send(params);
//	      System.out.println(obj.toString());
//	    } catch (CoolsmsException e) {
//	      System.out.println(e.getMessage());
//	      System.out.println(e.getCode());
//	    }
	    
	}
	
	private static int makeRandomNum() {
		return ThreadLocalRandom.current().nextInt(100000, 1000000);
	}
}
