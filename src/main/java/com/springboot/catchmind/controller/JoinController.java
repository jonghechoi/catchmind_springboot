package com.springboot.catchmind.controller;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.service.MemberServiceImpl;
import com.springboot.catchmind.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {
	
	@Autowired
	private MemberServiceImpl memberService;
	/**
	 * ȸ������ ������� ������ - join_consent
	 */
	@GetMapping("join_consent")
	public String join_consent() {
		return "pages/mydining/join_consent";
	}
	
	/**
	 * ȸ������ ó�� - join_proc
	 */
	@PostMapping("join")
	public ModelAndView join_proc(MemberDto memberDto) {
		ModelAndView model = new ModelAndView();
		
		int result = memberService.getJoin(memberDto);
		
		if(result == 1) {
			model.addObject("SignUp_Complete", "ok");
			model.setViewName("pages/mydining/login");
		}
		
		return model;
	}
		
	/**
	 * ȸ������ ������ - join.do
	 */
	@GetMapping("join")
	public String join() {
		
		return "pages/mydining/join";
	}
}
