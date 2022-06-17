package com.kos.showticat.admin;

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
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter({ "/bang/schedule.do", "/bang/scheduleInsert.do", "/bang/scheduleInsertTheater.do", "/bang/scheduleDeleteCheck.do", "/bang/scheduleDelete.do", "/bang/show.do", "/bang/showInsert.do", "/bang/showUpdate.do", "/bang/showDeleteCheck.do", "/bang/showDelete.do" })
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse =(HttpServletResponse) response;
		HttpSession session = hrequest.getSession(false);
		MemberVO member = (MemberVO)session.getAttribute("member");
		String path = hrequest.getContextPath()+"/";
		System.out.println(path);
		
		if(member==null) {
			hresponse.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('관리자 페이지 접근이 불가능합니다');  location.href=\""+path+"\";</script>");
			writer.close();
			
		}else {
			if(member.getM_id().equals("admin")) {
				chain.doFilter(request, response);
			}
			else {
				hresponse.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('관리자 페이지 접근이 불가능합니다');  location.href=\""+path+"\";</script>");
				writer.close();
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
