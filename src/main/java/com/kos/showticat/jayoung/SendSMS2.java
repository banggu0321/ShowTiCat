package com.kos.showticat.jayoung;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SendSMS2{

	public void sendMsg(String to, int randomNum) {
	    String api_key = "NCSM6JCJ07YIKIIB";
	    String api_secret = "J7YMPLUUCIC3E3OX5BNDQDGNLE1H1GDJ";
	    Message coolsms = new Message(api_key, api_secret);
	
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();	
	    params.put("to", to);
	    params.put("from", "01057562187");
	    params.put("type", "SMS");
	    params.put("text", "[Show TiCat]인증번호 "+randomNum+"를 입력하세요.");
	    params.put("app_version", "test app 1.2"); // application name and version
	
	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	}

	public int makeRandomNum() {
		return ThreadLocalRandom.current().nextInt(100000, 1000000);
	}
}