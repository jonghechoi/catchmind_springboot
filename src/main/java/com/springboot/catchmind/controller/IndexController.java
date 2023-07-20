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
	@GetMapping("index")
	public String index() {
		return "/index";
	}
}
