package com.portal.login.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portal.base.CommonUtils;
import com.portal.login.entity.UserInfoVo;

@Controller
@RequestMapping("/")
public class LoginController {
	private static final Logger LOGGER_ = Logger.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public ModelAndView getLoginPage(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView mav = new ModelAndView("/login/loginPage");
		HttpSession httpSession = httpServletRequest.getSession(true);
		if (null != httpSession.getAttribute("username")) {
			mav.setViewName("redirect:/index");
		}
		return mav;
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(UserInfoVo infoVo, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		ModelAndView mav = new ModelAndView("/login/loginPage");
		String referer = httpServletRequest.getHeader("Referer");
		String redirectUrl = "/index";
		if (!StringUtils.isEmpty(referer)) {
			HashMap<String, String> map = CommonUtils.AnalyzeURLParams(referer);
			redirectUrl = map.get("redirectUrl");
		}

		HttpSession httpSession = httpServletRequest.getSession(true);
		if (null == httpSession.getAttribute("username")) {
			httpSession.setAttribute("userinfo", infoVo);
			httpSession.setAttribute("username", infoVo.getUsername());
			mav.setViewName("redirect:" + redirectUrl);
		}
		return mav;
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse){
		ModelAndView mav = new ModelAndView("/login/register");
		HttpSession httpSession = httpServletRequest.getSession();
		if (null != httpSession.getAttribute("username")) {
			LOGGER_.info("用户已登陆，跳转到首页");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping(value="/doRegister")
	public ModelAndView doRegister(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse){
		ModelAndView mav = new ModelAndView("/login/register");
		HttpSession httpSession = httpServletRequest.getSession();
		if (null != httpSession.getAttribute("username")) {
			LOGGER_.info("用户已登陆，跳转到首页");
			mav.setViewName("index");
		}
		return mav;
	}
}
