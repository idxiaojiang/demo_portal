package com.portal.login.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.portal.base.CommConst;
import com.portal.base.entity.ResultDataVO;
import com.portal.base.utility.CommUtils;
import com.portal.login.entity.CurrentSessionDetail;
import com.portal.login.entity.UserAccountDetailVO;
import com.portal.login.entity.UserInfoDetailVO;
import com.portal.login.service.IloginService;

@Controller
@RequestMapping("/")
public class LoginController {
	private static final Logger LOGGER_ = Logger.getLogger(LoginController.class);

	@Autowired
	private IloginService iLoginService;

	@RequestMapping("/login")
	public ModelAndView getLoginPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ModelAndView mav = new ModelAndView("/login/loginPage");
		ResultDataVO<Object> resultData = new ResultDataVO<Object>(200);
		// 判断是否已经登录，如已登陆直接返回
		CurrentSessionDetail currentSessionDetail = CommUtils.getCurrentSession(httpServletRequest);
		if (null != currentSessionDetail.getCurrUserName()) {
			mav.setViewName("redirect:/index");
		}
		mav.addObject(resultData);
		return mav;
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(UserInfoDetailVO infoDetailVO, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		ModelAndView mav = new ModelAndView("/login/loginPage");
		ResultDataVO<Object> resultData = new ResultDataVO<Object>();
		String referer = httpServletRequest.getHeader("Referer");
		String redirectUrl = "/index";

		try {
			// 设置登陆后的返回地址
			if (!StringUtils.isEmpty(referer)) {
				HashMap<String, String> map = CommUtils.AnalyzeURLParams(referer);
				redirectUrl = map.get("redirectUrl");
			}
			
			// 判断是否已经登录，如已登陆直接返回
			CurrentSessionDetail currentSessionDetail = CommUtils.getCurrentSession(httpServletRequest);
			//判断是否需要验证码
			if (currentSessionDetail.getLoginFailureNum() >= CommConst.AppConf.LOGIN_FAILURE_VERIFYCODE) {
				String verifyCode = infoDetailVO.getVerifyCode();
				
				//如果验证码为空
				if (StringUtils.isEmpty(verifyCode)) {
					currentSessionDetail.setLoginFailureNum(currentSessionDetail.getLoginFailureNum()+1);
					resultData.setCode(CommConst.HttpRespCode.INPUT_EXCEPTION);
					resultData.setMessage("请填写验证码");
					
					mav.addObject(resultData);
					return mav;
				}
				
				if (!verifyCode.toUpperCase().equals(currentSessionDetail.getVerifyCode().toUpperCase())) {
					currentSessionDetail.setLoginFailureNum(currentSessionDetail.getLoginFailureNum()+1);
					resultData.setCode(CommConst.HttpRespCode.INPUT_EXCEPTION);
					resultData.setMessage("验证码填写错误");
					
					mav.addObject(resultData);
					return mav;
				}
				
			}
			
			if (null == currentSessionDetail.getCurrUserName()) {
				UserAccountDetailVO accountDetail = iLoginService.doLogin(httpServletRequest, infoDetailVO);
				if (null != accountDetail && null != accountDetail.getUserName()) {
					currentSessionDetail.setCurrAccount(accountDetail.getAccount());
					currentSessionDetail.setCurrUserName(accountDetail.getUserName());
					currentSessionDetail.setLoginFailureNum(0);
					CommUtils.setCurrentSessionDetail(httpServletRequest, currentSessionDetail);
					resultData.setCode(CommConst.HttpRespCode.SESSION);
				} else {
					int failureNum = currentSessionDetail.getLoginFailureNum()+1;
					if (failureNum >= CommConst.AppConf.LOGIN_FAILURE_VERIFYCODE) {
						resultData.setOperate("verifyCode");
					}
					currentSessionDetail.setLoginFailureNum(currentSessionDetail.getLoginFailureNum()+1);
					resultData.setCode(CommConst.HttpRespCode.INPUT_EXCEPTION);
					resultData.setMessage("账号或密码错误");
				}
			}
		} catch (Exception e) {
			resultData.setCode(CommConst.HttpRespCode.SERVER_EXCEPTION);
			resultData.setMessage("登陆服异常，请联系系统管理员");
			LOGGER_.error("登陆异常:", e);
		}

		mav.addObject(resultData);
		mav.setViewName("redirect:" + redirectUrl);
		return mav;
	}

	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ModelAndView mav = new ModelAndView("/login/register");
		HttpSession httpSession = httpServletRequest.getSession();
		if (null != httpSession.getAttribute("username")) {
			LOGGER_.info("用户已登陆，跳转到首页");
			mav.setViewName("index");
		}
		return mav;
	}

	@RequestMapping(value = "/doRegister")
	public ModelAndView doRegister(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		ModelAndView mav = new ModelAndView("/login/register");
		HttpSession httpSession = httpServletRequest.getSession();
		if (null != httpSession.getAttribute("username")) {
			LOGGER_.info("用户已登陆，跳转到首页");
			mav.setViewName("index");
		}
		return mav;
	}
	
}
