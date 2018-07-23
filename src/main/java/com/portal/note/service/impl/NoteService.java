package com.portal.note.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.note.dao.INoteProcessDao;
import com.portal.note.entity.NoteDetailVO;
import com.portal.note.service.INoteService;

@Service
public class NoteService implements INoteService {
	@Autowired
	private INoteProcessDao iNoteProcessDao;
	@Override
	public NoteDetailVO getNoteDetail(String rowId) {
		NoteDetailVO detailVO = new NoteDetailVO();
		detailVO.setRowId(rowId);
		detailVO = iNoteProcessDao.getNoteDetail(detailVO);
		return detailVO;
	}

}
