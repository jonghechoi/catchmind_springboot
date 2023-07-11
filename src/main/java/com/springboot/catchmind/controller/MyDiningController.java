package com.springboot.catchmind.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.catchmind.service.MyDiningService;
import com.springboot.catchmind.service.PagingServiceImpl;
import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.ScheduledVo;
import com.springboot.catchmind.vo.SessionVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class MyDiningController {

	@Autowired
	private MyDiningService myDiningService;
	
	@Autowired
	private PagingServiceImpl pagingService;
	
	
	/**
	 *	�湮 �Ϸ��� �Ĵ� ����Ʈ ����¡ó�� - mydining_visited_paging.do
	 */
	@RequestMapping(value = "/mydining_visited_paging.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String mydining_visited_paging(String page, HttpSession session) {
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		
		Map<String, String> param = (HashMap<String, String>)pagingService.getVisitedResult(page, "visited", mid);
		param.put("mid", mid);
		
		ArrayList<ScheduledVo> list = myDiningService.getVisitedSelect(param);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();			
		
		for(ScheduledVo scheduledVo : list) {
			JsonObject jobj = new JsonObject();
			
			jobj.addProperty("rno", scheduledVo.getRno());
			jobj.addProperty("mid", scheduledVo.getMid());
			jobj.addProperty("sid", scheduledVo.getSid());
			jobj.addProperty("rid", scheduledVo.getRid());
			jobj.addProperty("memberId", scheduledVo.getMemberId());
			jobj.addProperty("mname", scheduledVo.getMname());
			jobj.addProperty("tel", scheduledVo.getTel());
			jobj.addProperty("mphone", scheduledVo.getMphone());
			jobj.addProperty("sname", scheduledVo.getSname());
			jobj.addProperty("slocShort", scheduledVo.getSlocShort());
			jobj.addProperty("rdate", scheduledVo.getRdate());
			jobj.addProperty("rtime", scheduledVo.getRtime());
			jobj.addProperty("guestNumber", scheduledVo.getGuestNumber());
			jobj.addProperty("rphone", scheduledVo.getRphone());
			jobj.addProperty("rstatus", scheduledVo.getRstatus());
			jobj.addProperty("reviewYN", scheduledVo.getReviewYN());
			jobj.addProperty("smphoto", scheduledVo.getSmphoto());
			
			jarray.add(jobj);
		}
		
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("dbCount"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("page", param.get("page"));	
		
		return new Gson().toJson(jlist);
	}
    
	@RequestMapping(value = "/mydining_visited.do", method = RequestMethod.GET)
	public String mydining_visited() {
		return "mydining_visited";
	}
	
	
	/**
	 * ���� ���� ������ - mydining_scheduled.do
	 */
	@RequestMapping(value = "/mydining_scheduled.do", method = RequestMethod.GET)
	public ModelAndView mydining_scheduled(HttpSession session) {
		ModelAndView model = new ModelAndView();
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		
		String mid = sessionVo.getMid();
		
		ArrayList<ScheduledVo> list = myDiningService.getScheduled(mid);
//		myDiningService.getUpdateStatus();
		model.addObject("list", list);
		model.setViewName("mydining_scheduled");
			
		
		return model;
	}
}
