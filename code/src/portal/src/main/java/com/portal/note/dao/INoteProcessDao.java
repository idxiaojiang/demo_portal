package com.portal.note.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.portal.note.entity.NoteDetailVO;

public interface INoteProcessDao {
	public NoteDetailVO getNoteDetail(NoteDetailVO detailVO);
}
