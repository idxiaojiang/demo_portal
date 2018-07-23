package com.portal.userCenter.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.portal.base.CommonUtils;
import com.portal.base.SystemParams;
import com.portal.base.entity.ResultDataVO;
import com.portal.note.entity.NoteDetailVO;
import com.portal.userCenter.service.IUserCenterService;

/**
 * 编辑类
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userCenter")
public class UserCenterController {
	private final Logger LOGGER_ = Logger.getLogger(UserCenterController.class);

	@Autowired
	private IUserCenterService iUserCenterService;

	@ResponseBody
	@RequestMapping(value = "/getNoteDetailList", method = RequestMethod.GET)
	public List<NoteDetailVO> getNoteDetailList() {
		return iUserCenterService.getNoteDetailList();
	}
	
	/**
	 * 跳转编辑页面
	 * 
	 * @return
	 */
	@RequestMapping(value = {"","/publish"})
	public ModelAndView editHtml() {
		LOGGER_.debug("进入用户中心编辑页面");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/userCenter/noteEditor");
		return modelAndView;
	}


	@ResponseBody
	@RequestMapping(value = "/submitContent", method = RequestMethod.POST)
	public ResultDataVO<Object> submitContent(NoteDetailVO noteDetailVO) {
		LOGGER_.info("-----------------------submitContent");
		ResultDataVO<Object> dataVO = new ResultDataVO<Object>();
		try {
			iUserCenterService.submitContent(noteDetailVO, dataVO);
		} catch (Exception e) {
			dataVO.setCode(500);
			LOGGER_.error("UserController.submitContent error 发布文章异常：", e);
		}
		return dataVO;
	}


	/**
	 * 上传图片
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	@ResponseBody
	public ResultDataVO<Map<String, String>> uploadImage(MultipartFile multipartFile, HttpServletRequest request) {
		LOGGER_.info("====uploadImage 上传图片 begin");
		ResultDataVO<Map<String, String>> dataVO = new ResultDataVO<Map<String, String>>();
		try {
			//创建目标文件夹路径
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String currDate = dateFormat.format(System.currentTimeMillis());
			String realPath = SystemParams.getSystemItemValue("upload_path_temp")+SystemParams.getSystemItemValue("note_image_path")+currDate;
			
			//创建文件前缀名
			String prefix = (int) (Math.random() * 100000) + "" + System.currentTimeMillis();
			
			//复制文件
			String newFileName = CommonUtils.uploadFile(multipartFile, realPath, prefix);
			
			//响应给前端页面,获取图片的地址
			Map<String, String> map = new HashMap<String, String>();
			String imageUrl = "/resource/image/"+currDate+"/"+newFileName.replace(".", "_");
			map.put("data", imageUrl);

			dataVO.setResult(map);
		} catch (IllegalStateException e) {
			LOGGER_.error("图片上传异常:", e);
		} catch (IOException e) {
			LOGGER_.error("图片上传异常:", e);
		} catch (Exception e) {
			LOGGER_.error("图片上传异常:", e);
		}
		LOGGER_.info("====uploadImage 上传图片 end");
		return dataVO;
	}

}
