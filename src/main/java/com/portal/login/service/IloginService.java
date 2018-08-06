package com.portal.login.service;

import javax.servlet.http.HttpServletRequest;

import com.portal.base.entity.ResultDataVO;
import com.portal.login.entity.UserAccountDetailVO;
import com.portal.login.entity.UserInfoDetailVO;

public interface IloginService {
	/**
	 * 用户登陆
	 * @param httpServletRequest
	 * @param accountDetailVO
	 * @return
	 */
	UserAccountDetailVO doLogin(HttpServletRequest httpServletRequest,UserInfoDetailVO infoDetailVO);
}
