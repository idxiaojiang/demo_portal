package com.portal.userCenter.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.portal.note.entity.NoteDetailVO;

/**
 * 笔记处理Dao
 * @author Administrator
 *
 */
@MapperScan
public interface IUserCenterDao {
	public List<NoteDetailVO> getNoteDetailList();
	
	public void insertNoteDetail(NoteDetailVO noteDetailVO);
}
