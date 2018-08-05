package com.portal.note.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.base.SystemParams;
import com.portal.base.utility.CommonUtils;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	private static final Logger LOGGER_ = Logger.getLogger(ResourceController.class);

	@RequestMapping("/image/{uploadDate}/{imageName}")
	public void readImage(@PathVariable("imageName") String imageName, @PathVariable("uploadDate") String uploadDate,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		LOGGER_.info("====readImage 读取图片 begin");
		if (!StringUtils.isEmpty("uploadDate") && !StringUtils.isEmpty(imageName)) {
			imageName = imageName.replace("_", ".");
			String referer = httpServletRequest.getHeader("Referer");
			if (!StringUtils.isEmpty(referer)) {
				if (referer.contains("/userCenter/publish")) {
					String uploadPath = SystemParams.getItemVal("upload_path_temp");
					String imagePath = uploadPath + "image\\" + uploadDate + "\\" + imageName;
					CommonUtils.httpWriteImage(httpServletRequest, httpServletResponse, imagePath);
				} else {
					String uploadPath = SystemParams.getItemVal("upload_path");
					String imagePath = uploadPath + "image\\" + uploadDate + "\\" + imageName;
					CommonUtils.httpWriteImage(httpServletRequest, httpServletResponse, imagePath);
				}
			} else {
				httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest, httpServletResponse);
			}
		}
		LOGGER_.info("====readImage 读取图片 end");
	}
}
