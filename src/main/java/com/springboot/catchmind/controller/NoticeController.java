package com.springboot.catchmind.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.springboot.catchmind.service.PagingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.catchmind.service.AdminServiceImpl;
import com.springboot.catchmind.service.NoticeServiceImpl;
import com.springboot.catchmind.vo.NoticeVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeServiceImpl noticeService;
	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private PagingServiceImpl pagingService;
	
	
	/**
	 *	 notice.do
	 */
	@RequestMapping(value = "/notice.do", method = RequestMethod.GET)
	public String notice() {
		return "pages/notice/notice";
	}

	/**
	 *	notice_content.do
	 */
	@RequestMapping(value = "/notice_content.do", method = RequestMethod.GET)
	public String notice_content(String nid, Model model) {
		model.addAttribute("noticeVo", adminService.getNoticeSelect(nid));
		return "pages/notice/notice_content";
	}
}
