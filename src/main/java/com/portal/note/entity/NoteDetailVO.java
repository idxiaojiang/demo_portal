package com.portal.note.entity;

import java.util.List;

import com.portal.base.entity.BaseResourceVO;

/**
 * 笔记详情VO
 * @author Administrator
 *
 */
public class NoteDetailVO extends BaseResourceVO{
	/**
	 * rowid
	 */
	private String rowId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 评论数
	 */
	private int commentNum;
	/**
	 * 阅读数
	 */
	private int readNum;
	/**
	 * 创建人ID
	 */
	private String createUserId;
	/**
	 * 资源所属模块
	 */
	private String module;
	/**
	 * 笔记类型
	 */
	private String noteType;
	/**
	 * 笔记状态 (100：草稿;200：已公开发表;300：不公开发表；400：删除）
	 */
	private int noteState;
	/**
	 * 流程状态（100:审核中；200：审核通过；300：驳回）
	 */
	private int flowState;
	/**
	 * 笔记内容ID
	 */
	private String contentId;
	/**
	 * 笔记内容（Html内容）
	 */
	private String contentHtml;
	
	/**
	 * 笔记内容（文字内容）
	 */
	private String contentText;
	
	/**
	 * 封面图集合
	 */
	private List<NoteCoverVO> coverList;
	
	/**
	 * 封面图URL
	 */
	private String coverImageUrl;
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	public int getNoteState() {
		return noteState;
	}
	public void setNoteState(int noteState) {
		this.noteState = noteState;
	}
	public int getFlowState() {
		return flowState;
	}
	public void setFlowState(int flowState) {
		this.flowState = flowState;
	}
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getContentHtml() {
		return contentHtml;
	}
	public void setContentHtml(String contentHtml) {
		this.contentHtml = contentHtml;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	public List<NoteCoverVO> getCoverList() {
		return coverList;
	}
	public void setCoverList(List<NoteCoverVO> coverList) {
		this.coverList = coverList;
	}
	public String getCoverImageUrl() {
		return coverImageUrl;
	}
	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}
	
}
