package com.portal.note.service;

import java.util.List;

import com.portal.note.entity.NoteDetailVO;

public interface IIndexService {
	public List<NoteDetailVO> getNoteByHot();
	public List<NoteDetailVO> getNoteByDate();
}
