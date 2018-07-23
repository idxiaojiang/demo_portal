package com.portal.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.portal.base.entity.PagedVO;
import com.portal.index.dao.IIndexDao;
import com.portal.index.service.IPortalNoteService;
import com.portal.note.entity.NoteDetailVO;

@Service
public class PortalNoteService implements IPortalNoteService {
	@Autowired
	private IIndexDao iIndexDao;

	@Override
	public Page<NoteDetailVO> getNoteByHot(int noteNum) {
		List<NoteDetailVO> list = iIndexDao.getNoteByDate(new PagedVO());
		Page<NoteDetailVO> info = (Page<NoteDetailVO>) list;
		return info;
	}

	@Override
	public Page<NoteDetailVO> getNoteByDate(int noteNum) {
		List<NoteDetailVO> list = iIndexDao.getNoteByDate(new PagedVO());
		Page<NoteDetailVO> info = (Page<NoteDetailVO>) list;
		return info;
	}

}
