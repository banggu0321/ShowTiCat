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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse =(HttpServletResponse) response;
		HttpSession session = hrequest.getSession(false);
		MemberVO member = (MemberVO)session.getAttribute("member");
		String path = hrequest.getContextPath();
		
		if(member==null) {
			/*response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('관리자 페이지 접근이 불가능합니다');  location.href="+path+";</script>");
			writer.close();
			*/
			hresponse.sendRedirect(path);
			
		}else {
			if(member.getM_id().equals("admin")) {
				chain.doFilter(request, response);
			}
			else {
				/*response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('관리자 페이지 접근이 불가능합니다');  location.href="+path+";</script>");
				writer.close();
				*/
				hresponse.sendRedirect(path);
			}
		}
		
		//HttpSession session = ((Object) request).getSession(false);
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
