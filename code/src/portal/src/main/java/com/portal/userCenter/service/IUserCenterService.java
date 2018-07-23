package com.portal.userCenter.service;

import java.util.List;

import com.portal.base.entity.ResultDataVO;
import com.portal.note.entity.NoteDetailVO;

public interface IUserCenterService {
	public List<NoteDetailVO> getNoteDetailList();
	public void submitContent(NoteDetailVO noteDetailVO,ResultDataVO<Object> dataVO) throws Exception;
}
