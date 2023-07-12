package com.springboot.catchmind.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.catchmind.service.FindService;
import com.springboot.catchmind.service.MailSendService;
import com.springboot.catchmind.vo.MemberVo;

@Controller
@Slf4j
public class FindController {
	
	@Autowired
	private FindService findService;
	
	@Autowired
	private MailSendService mailSendService;
	
	/**
	 *find_pass_emailCheck.do
	 */
	@RequestMapping(value="/find_pass_emailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String find_pass_emailCheck(String memail) {
		log.info("Find_User_MEmail -> {}", memail);
		return mailSendService.findEmail(memail);
	}
	/**
	 * ��й�ȣ �缳�� - find_pass_update_proc.do
	 */
	@RequestMapping(value="/find_pass_update_proc.do", method = RequestMethod.POST)
	public ModelAndView find_pass_update_proc(MemberVo memberVo, RedirectAttributes redirectAttributes, HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		MemberVo beforemPass = findService.getFindPassUpdateInfo(memberVo.getMid());
		
		session.setAttribute("sessionResult", beforemPass);
		
		if(!memberVo.getMpass().equals(beforemPass.getBeforemPass())) {
			int passUpdate = findService.getPassUpdate(memberVo.getMid(), memberVo.getMpass());
			
			if(passUpdate == 1) {
				redirectAttributes.addFlashAttribute("pass_update", "ok");
				model.setViewName("redirect:/login");
			}
			
		}else if(memberVo.getMpass().equals(beforemPass.getBeforemPass())) {
			
			MemberVo sessionResult = (MemberVo)session.getAttribute("sessionResult");
			
			Map<String, String> param = new HashMap<String, String>();
			param.put("beforemPass", sessionResult.getBeforemPass());
			param.put("mid", sessionResult.getMid());
			
			model.addObject("pass_update", "no");
			model.addObject("findPassInfo", param);
			model.setViewName("pages/mydining/find_pass_info");
		}
		
		return model;
	}
	
	/**
	 * ��й�ȣ ã�� ó�� - find_pass_proc.do
	 */
	@RequestMapping(value="/find_pass_proc", method = RequestMethod.POST)
	public ModelAndView find_pass_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		
		MemberVo findPassInfo = findService.getFindPassInfo(memberVo);
		
		if(findPassInfo.getMid() != null) {
			int result = findService.getBeforeMpassUpdate(findPassInfo.getMid());
			
			if(result == 1) {
//				session.setAttribute("findPassInfo", findPassInfo);
				model.addObject("findPassInfo", findPassInfo);
				model.setViewName("pages/mydining/find_pass_info");
				
			}else {
				model.addObject("find_fail", "no");
				model.setViewName("pages/mydining/find_pass");
			}
			
		}else {
			model.addObject("find_fail", "no");
			model.setViewName("pages/mydining/find_pass");
		}
		
		return model;
	}
	/**
	 * find_id_proc.do
	 */
	@PostMapping("find_id")
	public String find_id_proc(MemberVo memberVo, Model model) {
		MemberVo findMember = findService.getFindId(memberVo);
		
		if(findMember != null) {
			model.addAttribute("findMember", findMember);
			return "pages/mydining/find_id_info";
		}else {
			model.addAttribute("find_fail", "no");
			return "pages/mydining/find_id";
		}
	}
	
	/**
	 *find_pass form
	 */
	@GetMapping("find_pass")
	public String find_pass() {
		
		return "pages/mydining/find_pass";
	}
	/**
	 *find_id form
	 */
	@GetMapping("find_id")
	public String find_id() {
		
		return "pages/mydining/find_id";
	}
}
