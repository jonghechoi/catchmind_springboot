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
	 *	 notice
	 */
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice() {
		return "pages/notice/notice";
	}
	
	/**
	 *	notice_list_paging
	 */
	@RequestMapping(value = "/notice_list_paging", method = RequestMethod.GET)
	@ResponseBody
	public String notice(String page) {
		Map<String, Integer> param = (HashMap<String, Integer>)pagingService.getPageResult(page, "notice");
		ArrayList<NoticeVo> list = noticeService.getNoticeSelect(param);

		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();

		for(NoticeVo noticeVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", noticeVo.getRno());
			jobj.addProperty("ntitle", noticeVo.getNtitle());
			jobj.addProperty("nhits", noticeVo.getNhits());
			jobj.addProperty("ncreatedate", noticeVo.getNcreatedate());
			jobj.addProperty("nid", noticeVo.getNid());

			jarray.add(jobj);
		}

		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("dbCount"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("page", param.get("page"));

		return new Gson().toJson(jlist);
	}

	
	/**
	 *	notice_content
	 */
	@RequestMapping(value = "/notice_content", method = RequestMethod.GET)
	public String notice_content(String nid, Model model) {
		model.addAttribute("noticeVo", adminService.getNoticeSelect(nid));
		return "pages/notice/notice_content";
	}
	
	/**
	 *	notice_upload
	 */
	@RequestMapping(value = "/notice_upload", method = RequestMethod.POST)
	@ResponseBody
	public String notice_upload(NoticeVo noticeVo, Model model) {
		return String.valueOf(noticeService.getNoticeUpload(noticeVo));
	}
}
