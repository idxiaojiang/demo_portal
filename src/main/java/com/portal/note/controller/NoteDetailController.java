package com.portal.note.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.portal.note.entity.NoteDetailVO;
import com.portal.note.service.INoteService;

@Controller
@RequestMapping("/note")
public class NoteDetailController {
	
	private static Logger LOGGER_ = Logger.getLogger(NoteDetailController.class);

	@Autowired
	private INoteService iNoteServer;

	@RequestMapping("/{rowId}")
	public ModelAndView getNoteDetail(@PathVariable("rowId") String rowId) {
		LOGGER_.info("getNoteDetail begin");
		ModelAndView andView = new ModelAndView("index");
		NoteDetailVO detailVO = iNoteServer.getNoteDetail(rowId);
		if (null != detailVO) {
			andView = new ModelAndView("/note/noteDetail");
			andView.addObject("detail", detailVO);
		}
		LOGGER_.info("getNoteDetail end");
		return andView;
	}

	
	
	
}
