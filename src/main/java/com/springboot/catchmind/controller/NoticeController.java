package com.springboot.catchmind.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.springboot.catchmind.service.PagingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("notice")
	public String notice() {
		return "/pages/notice/notice";
	}

	@GetMapping("notice_content/{nid}")
	public String notice_content(@PathVariable String nid, Model model) {
		model.addAttribute("noticeDto", adminService.getNoticeSelect(nid));
		return "/pages/notice/notice_content";
	}
}
