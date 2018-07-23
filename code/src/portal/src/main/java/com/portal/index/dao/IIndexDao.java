package com.portal.index.dao;

import java.util.List;

import com.portal.base.entity.PagedVO;
import com.portal.note.entity.NoteDetailVO;

public interface IIndexDao {
	List<NoteDetailVO> getNoteByHot(PagedVO pagedVO);
	List<NoteDetailVO> getNoteByDate(PagedVO pagedVO);
}
