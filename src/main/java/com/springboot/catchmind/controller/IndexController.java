package com.springboot.catchmind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.catchmind.service.MapServiceImpl;
import com.springboot.catchmind.service.Scheduler;

@Controller
public class IndexController {
	
	@Autowired
	private Scheduler reviewSchedulerService;
	@Autowired
	private MapServiceImpl mapService;
	
	/**
	 *	���������� - index.do
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	/**
	 *	���������� - ��� ���� ������Ʈ
	 */
	@RequestMapping(value = "/index_review.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String index_review(Model model) {
		return reviewSchedulerService.reviewMainChange();
	}	
	
	/**
	 *	���������� - ��Ŀ ���� ����
	 */
	@RequestMapping(value = "/index_mapMarker.do", method = RequestMethod.GET)
	@ResponseBody
	public String index_mapMarker(@RequestParam("lat") double lat, @RequestParam("lng") double lng) {
		return mapService.mapMainToSearch(lat, lng);
	}
}
