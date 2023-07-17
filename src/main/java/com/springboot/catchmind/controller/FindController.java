package com.springboot.catchmind.controller;


import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.service.FindServiceImpl;
import com.springboot.catchmind.service.MailSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class FindController {
	
	@Autowired
	private FindServiceImpl findService;
	
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
	 *  Find Pass Update process
	 */
	@PostMapping("find_pass_update")
	public ModelAndView find_pass_update_proc(MemberDto memberDto, RedirectAttributes redirectAttributes, HttpSession session) {
		ModelAndView model = new ModelAndView();

		MemberDto beforemPass = findService.getFindPassUpdateInfo(memberDto.getMid());
		
		session.setAttribute("sessionResult", beforemPass);
		
		if(!memberDto.getMpass().equals(beforemPass.getBeforemPass())) {
			int passUpdate = findService.getPassUpdate(memberDto.getMid(), memberDto.getMpass());
			
			if(passUpdate == 1) {
				redirectAttributes.addFlashAttribute("pass_update", "ok");
				model.setViewName("redirect:/login");
			}
			
		}else if(memberDto.getMpass().equals(beforemPass.getBeforemPass())) {
			
			MemberDto sessionResult = (MemberDto)session.getAttribute("sessionResult");
			
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
	 * find_pass_proc
	 */
	@PostMapping(value="find_pass")
	public String find_pass_proc(MemberDto memberDto, Model model) {
		log.info("memberDto.getMemberId() -> {}" ,memberDto.getMemberId());
		log.info("memberDto.getMemail -> {}", memberDto.getMemail());

		int findPassResult = findService.getFindPassCheck(memberDto);

		if(findPassResult == 1) {
			MemberDto findPassInfo = findService.getFindPassInfo(memberDto);

			int result = findService.getBeforeMpassUpdate(findPassInfo.getMid());
			
			if(result == 1) {
				model.addAttribute("findPassInfo", findPassInfo);
				return "pages/mydining/find_pass_info";
				
			}else {
				model.addAttribute("find_fail", "no");
				return "pages/mydining/find_pass";
			}
			
		}else {
			model.addAttribute("find_fail", "no");
			return "pages/mydining/find_pass";
		}
		
	}
	/**
	 * Find id process
	 */
	@PostMapping("find_id")
	public String find_id_proc(MemberDto memberDto, Model model) {
		MemberDto findMember = findService.getFindId(memberDto);
		
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
