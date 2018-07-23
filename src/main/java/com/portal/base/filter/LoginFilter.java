package com.portal.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LoginFilter implements Filter {
	private static final Logger LOGGER_ = Logger.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOGGER_.info("用户登录验证 begin");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(true);
		String url = httpRequest.getRequestURL().toString();
		String contextPath = httpRequest.getContextPath();
		if (null == session.getAttribute("username")) {
			LOGGER_.info("用户未登录，跳转登录");
			httpResponse.sendRedirect(contextPath + "/login?redirectUrl=" + url);
		} else {
			LOGGER_.info("用户已登录：" + session.getAttribute("username"));
			chain.doFilter(httpRequest, httpResponse);
		}
		LOGGER_.info("用户登录验证 end");
	}

	@Override
	public void destroy() {

	}

}
