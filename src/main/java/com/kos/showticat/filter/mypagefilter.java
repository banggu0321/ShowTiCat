package com.kos.showticat.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kos.showticat.VO.MemberVO;

/**
 * Servlet Filter implementation class mypagefilter
 */
@WebFilter({ "/mypagefilter", "/jaeyong/memberMyPage.do", "/jayoung/interestPlace.do", "/mypage/confirm.do",
		"/jayoung/insertReview.do", "/jayoung/myReview.do", "/jayoung/updateReview.do", "/jaeyong/modifyPwCheck.do",
		"/jaeyong/memberUpdate.do", "/jaeyong/deletePwCheck.do", "/jaeyong/memberDelete.do" })
public class mypagefilter implements Filter {

	public mypagefilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		HttpSession session = hrequest.getSession(false);
		String path = hrequest.getContextPath() + "/jayoung/login.do";
		System.out.println(path);

		if (session != null) {
			MemberVO member = (MemberVO) session.getAttribute("member");
			
			if (member == null) {
				hresponse.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('로그인 후 이용 가능합니다.');  location.href= \""+path+"\";</script>");
				writer.close();
				
			} else {
				chain.doFilter(request, response);
			}
		}else {
			hresponse.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용 가능합니다.');  location.href=\""+path+"\";</script>");
			writer.close();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
