package com.springboot.catchmind.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.springboot.catchmind.dto.ScheduledDto;
import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.service.MyDiningServiceImpl;
import com.springboot.catchmind.service.PagingServiceImpl;
import com.springboot.catchmind.vo.SessionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyDiningController {

	@Autowired
	private MyDiningServiceImpl myDiningService;
	

	@GetMapping("mydining_visited")
	public String mydining_visited() {
		return "mydining_visited";
	}
	
	
	/**
	 * ���� ���� ������ - mydining_scheduled
	 */
	@GetMapping("mydining_scheduled")
	public String mydining_scheduled(HttpSession session, Model model) {
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");
		
		String mid = sessionVo.getMid();
		
		ArrayList<ScheduledDto> list = myDiningService.getScheduled(mid);
//		myDiningService.getUpdateStatus();
		model.addAttribute("list", list);

		return "mydining_scheduled";
	}
}
