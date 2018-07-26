package com.portal.index.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.portal.base.entity.SmsParamsVO;
import com.portal.base.utility.SmsClient;
import com.portal.note.entity.NoteDetailVO;
import com.portal.note.service.IIndexService;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final Logger LOGGER_ = Logger.getLogger(IndexController.class);

	@Autowired
	private IIndexService iIndexService;

	/**
	 * 默认访问界面,首页
	 * 
	 * @return
	 */
	@RequestMapping(value={"/","/index"})
	public ModelAndView getIndexMessage() {
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			List<NoteDetailVO> hotList = iIndexService.getNoteByHot();
			List<NoteDetailVO> newList = iIndexService.getNoteByDate();
			modelAndView.addObject("hotList", hotList);
			modelAndView.addObject("newList", newList);
		} catch (Exception e) {
			LOGGER_.error("getDefaultArticle error:", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value={"/sendSms"})
	public void sendSms() {
		try {
			for (int i = 0; i < 10; i++) {
				SmsParamsVO paramsVO = new SmsParamsVO();
				paramsVO.setPhoneNumbers("15986746869");
				paramsVO.setTemplateParam("{\"code\":\""+System.currentTimeMillis()+"\"}");
				SmsClient.getInstance().sendMessage(paramsVO);
			}
		} catch (Exception e) {
			LOGGER_.error("sendSms error:", e);
		}
	}
	
}
