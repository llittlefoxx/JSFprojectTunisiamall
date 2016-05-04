package customerBean;

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

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/pages/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		AuthenticationBean loginBean = (AuthenticationBean) ((HttpServletRequest) request).getSession()
				.getAttribute("authenticationBean");

		HttpServletRequest reqt = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession ses = reqt.getSession(false);

		String reqURI = reqt.getRequestURI();
		String contextPath = reqt.getContextPath();

		if (loginBean == null || !loginBean.isLoggedIn()) {
			
			resp.sendError(403);

		} else {

			if (reqURI.contains("customer") && !loginBean.getUserType().equalsIgnoreCase("customer")) {
				
				resp.sendError(403);
				loginBean.setLoggedIn(false);
				
			} else if (reqURI.contains("admin") && !loginBean.getUserType().equalsIgnoreCase("shopowenr")) {
				
				resp.sendError(403);
				loginBean.setLoggedIn(false);
				
			} else {
				
				chain.doFilter(request, response);
			}

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}