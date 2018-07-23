package com.portal.note.service;

import com.portal.note.entity.NoteDetailVO;

public interface INoteService {
	public NoteDetailVO getNoteDetail(String rowId);
}
