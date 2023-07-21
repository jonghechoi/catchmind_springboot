package com.springboot.catchmind.controller;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.service.MemberServiceImpl;
import com.springboot.catchmind.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {
	
	@Autowired
	private MemberServiceImpl memberService;
	/**
	 * join_consent
	 */
	@GetMapping("join_consent")
	public String join_consent() {
		return "pages/mydining/join_consent";
	}
	
	/**
	 * join_proc
	 */
	@PostMapping("join")
	public String join_proc(MemberDto memberDto, Model model) {

		int result = memberService.getJoin(memberDto);
		if(result == 1) {
			model.addAttribute("SignUp_Complete", "ok");
			return "pages/mydining/login";
		}
		return "pages/mydining/login";
	}
		
	/**
	 * join.do
	 */
	@GetMapping("join")
	public String join() {
		
		return "pages/mydining/join";
	}
}
