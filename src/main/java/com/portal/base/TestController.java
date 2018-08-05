package com.portal.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.base.utility.CommonUtils;
import com.portal.base.utility.VerifyCodeUtils;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/verifyCode/{codeType}")
	public void verifyCode(@PathVariable("codeType")String codeType,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		if ("login".equals(codeType)) {
			String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		    String path = VerifyCodeUtils.outputVerifyImageRetPath(verifyCode);
		    CommonUtils.httpWriteImage(httpServletRequest, httpServletResponse, path);
		}
	}
}
