package com.portal.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.portal.base.utility.CommUtils;
import com.portal.base.utility.VerifyCodeUtils;
import com.portal.login.entity.CurrentSessionDetail;


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
	
	/**
	 * 获取验证码
	 * @param codeType
	 * @param httpServletRequest
	 * @param httpServletResponse
	 */
	@RequestMapping("/verifyCode/{codeType}")
	public void verifyCode(@PathVariable("codeType")String codeType,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		if ("login".equals(codeType)) {
			String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		    String path = VerifyCodeUtils.outputVerifyImageRetPath(verifyCode);
		    CommUtils.httpWriteImage(httpServletRequest, httpServletResponse, path);
		    
		    CurrentSessionDetail currentSessionDetail = CommUtils.getCurrentSession(httpServletRequest);
		    currentSessionDetail.setVerifyCode(verifyCode);
		    CommUtils.setCurrentSessionDetail(httpServletRequest, currentSessionDetail);
		}
	}
	
}
