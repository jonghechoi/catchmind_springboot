package com.springboot.catchmind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.catchmind.service.MapServiceImpl;
import com.springboot.catchmind.service.Scheduler;

@Controller
public class IndexController {
	
	@Autowired
	private Scheduler reviewSchedulerService;
	@Autowired
	private MapServiceImpl mapService;
	
	/**
	 *	Index
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	/**
	 *	Index mapMarker
	 */
	@RequestMapping(value = "/index_mapMarker", method = RequestMethod.GET)
	@ResponseBody
	public String index_mapMarker(@RequestParam("lat") double lat, @RequestParam("lng") double lng) {
		return mapService.mapMainToSearch(lat, lng);
	}
}
