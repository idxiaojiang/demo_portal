package com.portal.index.service;

import com.github.pagehelper.Page;
import com.portal.note.entity.NoteDetailVO;

public interface IPortalNoteService {
	public Page<NoteDetailVO> getNoteByHot(int noteNum);
	
	public Page<NoteDetailVO>  getNoteByDate(int noteNum);
}
