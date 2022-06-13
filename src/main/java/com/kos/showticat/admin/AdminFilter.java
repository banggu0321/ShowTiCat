package com.kos.showticat.admin;

import java.io.IOException;
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
		HttpSession session = hrequest.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		String path = hrequest.getContextPath() ;

		if(member==null) {
			HttpServletResponse hresponse =(HttpServletResponse) response;
			hresponse.sendRedirect(path);
			return;
		}
		
		//HttpSession session = ((Object) request).getSession(false);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
