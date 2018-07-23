package com.portal.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class DefaultController {
	/**
	 * 如果找不到资源则返回首页
	 * 
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public void index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException, ServletException {
		httpServletRequest.getRequestDispatcher("/note").forward(httpServletRequest, httpServletResponse);
		;
	}

	/**
	 * 返回首页
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	public ModelAndView defaultPage(@QueryParam("") HttpServletRequest httpServletRequest,
			@QueryParam("") HttpServletResponse httpServletResponse) throws IOException {
		return new ModelAndView("index");
	}
	
}
