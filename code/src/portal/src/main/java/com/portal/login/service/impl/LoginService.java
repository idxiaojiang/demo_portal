package com.portal.login.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.login.dao.ILoginDao;
import com.portal.login.entity.UserAccountDetailVO;
import com.portal.login.entity.UserInfoDetailVO;
import com.portal.login.service.IloginService;

@Service
public class LoginService implements IloginService{

	@Autowired
	private ILoginDao iLoginDao;
	
	@Override
	public UserAccountDetailVO doLogin(HttpServletRequest httpServletRequest, UserInfoDetailVO infoDetailVO) {
		infoDetailVO.setPassword(DigestUtils.md5Hex(infoDetailVO.getPassword()));
		UserAccountDetailVO accountDetailVO = iLoginDao.getUserLoginAccount(infoDetailVO);
		
		return accountDetailVO;
	}
	
}
