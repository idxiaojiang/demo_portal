package com.portal.index.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.base.SystemParams;
import com.portal.base.entity.PagedVO;
import com.portal.index.dao.IIndexDao;
import com.portal.note.entity.NoteDetailVO;
import com.portal.note.service.IIndexService;

@Service
public class IndexService implements IIndexService {
	
	@Autowired
	private IIndexDao iIndexDao;

	@Override
	public List<NoteDetailVO> getNoteByHot() {
		int num = Integer.parseInt(SystemParams.getSystemItemValue("index_hot_num"));
		PagedVO pagedVO = new PagedVO();
		pagedVO.setStartRow(0);
		pagedVO.setEndRow(num);
		List<NoteDetailVO> list = iIndexDao.getNoteByHot(pagedVO);
		return list;
	}

	@Override
	public List<NoteDetailVO> getNoteByDate() {
		int num = Integer.parseInt(SystemParams.getSystemItemValue("index_new_num"));
		PagedVO pagedVO = new PagedVO();
		pagedVO.setStartRow(0);
		pagedVO.setEndRow(num);
		List<NoteDetailVO> list = iIndexDao.getNoteByDate(pagedVO);
		return list;
	}

}
