package com.springboot.catchmind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.service.MemberService;
import com.springboot.catchmind.vo.MemberVo;

@Controller
public class JoinController {
	
	@Autowired
	private MemberService memberService;
	/**
	 * ȸ������ ������� ������ - join_consent.do
	 */
	@RequestMapping(value = "/join_consent.do", method = RequestMethod.GET)
	public String join_consent() {
		return "pages/mydining/join_consent";
	}
	
	/**
	 * ȸ������ ó�� - join_proc.do
	 */
	@RequestMapping(value = "/join_proc.do", method = RequestMethod.POST)
	public ModelAndView join_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		int result = memberService.getJoin(memberVo);
		
		if(result == 1) {
			model.addObject("SignUp_Complete", "ok");
			model.setViewName("pages/mydining/login");
		}
		
		return model;
	}
		
	/**
	 * ȸ������ ID �ߺ�üũ - id_check.do
	 */
	@RequestMapping(value = "/id_check.do", method = RequestMethod.GET)
	@ResponseBody
	public String id_check(String memberId) {
		int result = memberService.getIdCheck(memberId);
		return String.valueOf(result);
	}
	
	/**
	 * ȸ������ ������ - join.do
	 */
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		
		return "pages/mydining/join";
	}
}
