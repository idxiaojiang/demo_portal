package com.portal.userCenter.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.portal.base.CommConst;
import com.portal.base.SystemParams;
import com.portal.base.entity.ResultDataVO;
import com.portal.base.utility.CommUtils;
import com.portal.note.entity.NoteDetailVO;
import com.portal.userCenter.dao.IUserCenterDao;
import com.portal.userCenter.service.IUserCenterService;

@Service("userCenterService")
public class UserCenterService implements IUserCenterService {
	private static Logger LOGGER_ = Logger.getLogger(UserCenterService.class);

	@Autowired
	private IUserCenterDao iUserCenterDao;
	
	@Override
	public List<NoteDetailVO> getNoteDetailList() {
		return iUserCenterDao.getNoteDetailList();
	}
	
	@Override
	public void submitContent(NoteDetailVO noteDetailVO, ResultDataVO<Object> dataVO) throws IOException {
		LOGGER_.info("=====submitContent begin");
		//1.校验数据
		if (!this.verifyInputData(noteDetailVO, dataVO)) {
			return;
		}
		//2.解析html中的图片资源信息
		List<String> imgNameList = this.resolveImgName(noteDetailVO);
		
		//3.copy资源文件从临时目录拷贝到正式目录
		String imagePaht = SystemParams.getItemVal("note_image_path");
		String sourcePath = SystemParams.getItemVal("upload_path_temp") + imagePaht+"/";
		String targetPath = SystemParams.getItemVal("upload_path") + imagePaht+"/";
		for (String fileName : imgNameList) {
			fileName = fileName.replace("_", ".");
			CommUtils.copyFileNoDel(sourcePath+fileName, targetPath+fileName);
		}
		noteDetailVO.setRowId(CommUtils.createRowId());
		noteDetailVO.setFlowState(200);
		noteDetailVO.setNoteState(200);
		iUserCenterDao.insertNoteDetail(noteDetailVO);
		LOGGER_.info("=====submitContent end");
	}
	
	/**
	 * 解析html中的img图片
	 * @param noteDetailVO
	 * @return
	 */
	private List<String> resolveImgName(NoteDetailVO noteDetailVO){
		String regex = "(<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher=pattern.matcher(noteDetailVO.getContentHtml());
		List<String> imgList = new ArrayList<String>();
		while(matcher.find()){
			String htmlEle = matcher.group(0);
			String imgUrl = htmlEle.substring(htmlEle.indexOf("\"")+1,htmlEle.lastIndexOf("\""));
			imgList.add(imgUrl.substring(imgUrl.lastIndexOf(SystemParams.getItemVal("note_image_path"))+6));
//			imgList.add(imgUrl);
		}
		return imgList;
	}
	
	/**
	 * 校验输入数据
	 * @param noteDetailVO
	 * @param dataVO
	 * @return
	 */
	private boolean verifyInputData(NoteDetailVO noteDetailVO, ResultDataVO<Object> dataVO){
		String contentHtml = noteDetailVO.getContentHtml();
		String title = noteDetailVO.getTitle();
		if (!StringUtils.isEmpty(title) && title.length() > CommConst.AppConf.NOTE_TITLE_LENGTH) {
			dataVO.setCode(CommConst.HttpRespCode.INPUT_EXCEPTION);
			dataVO.setMessage("必须填写标题，且标题不能多于50个字");
			return false;
		}
		if (StringUtils.isEmpty(contentHtml) || StringUtils.isEmpty(noteDetailVO.getContentText())) {
			dataVO.setCode(CommConst.HttpRespCode.INPUT_EXCEPTION);
			dataVO.setMessage("必须填写文章内容");
			return false;
		}
		
		return true;
	}
}
