package com.springboot.catchmind.controller;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.dto.ShopDto;
import com.springboot.catchmind.service.MemberServiceImpl;
import com.springboot.catchmind.service.ShopService;
import com.springboot.catchmind.vo.ShopVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private ShopService shopService;
	
	/**
	 * logout.do
	 */
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");
		
		if(sessionVo != null) {
			session.invalidate();
			
			model.addObject("logout_result", "ok");
		}
		model.setViewName("/index");
		
		return model;
	}
	
	/**
	 *  login_role_proc.do
	 */
	@PostMapping("login_role")
	public ModelAndView login_role_proc(MemberDto memberDto, HttpSession session, ShopDto shopDto, RedirectAttributes redirectAttributes)
															throws Exception{
		ModelAndView model = new ModelAndView();
		
		if(memberDto.getMemberId() != null && shopDto.getSid() == null) {
			int adminIdCheck = memberService.getRoleIdCheck(memberDto);
			
			if(adminIdCheck == 1) {
				SessionDto sessionDto = memberService.getRoleLogin(memberDto);
				session.setAttribute("sessionVo", sessionDto);
				
				redirectAttributes.addFlashAttribute("loginRole_complete", "ok");
				model.setViewName("redirect:/index");
			}else {
				redirectAttributes.addFlashAttribute("loginRole_fail", "no");
				model.setViewName("redirect:/login_role");
			}
			
		}else if(shopDto.getSid() != null && memberDto.getMid() == null) {
			System.out.println(shopDto.getRoleid());
			int shopIdCheck = shopService.getShopIdCheck(shopDto);
			
			if(shopIdCheck == 1) {
				SessionDto sessionDto = shopService.getShopLogin(shopDto);
				session.setAttribute("sessionVo", sessionDto);
				
				redirectAttributes.addFlashAttribute("loginRole_complete", "ok");
				model.setViewName("redirect:/index");
			}else {
				redirectAttributes.addFlashAttribute("loginRole_fail", "no");
				model.setViewName("redirect:/login_role");
			}
		}else {
			redirectAttributes.addFlashAttribute("loginRole_fail", "no");
			model.setViewName("redirect:/login_role");
		}
		return model;
	}
	
	/**
	 *  login_role.do 
	 */
	@GetMapping("login_role")
	public String login_role() {
		return "pages/mydining/login_role";
	}
	
	/**
	 *  kakao_login_proc.do
	 */
	@PostMapping("/kakao_login")
	public String kakao_login_proc(MemberDto memberDto, RedirectAttributes redirectAttributes, HttpSession session) {
		String viewName = "";
		
		int idCheck = memberService.getKakaoIdCheck(memberDto);
		System.out.println(idCheck);
		
		if(idCheck ==  1) {
			SessionDto sessionDto = memberService.getKakaoLogin(memberDto);
			session.setAttribute("sessionVo", sessionDto);
			redirectAttributes.addFlashAttribute("kakoLogin_complete", "ok");
			viewName = "redirect:/index";
			
		}else if(idCheck == 0) {
			int joinCheck = memberService.getKakaoJoin(memberDto);
			
			if(joinCheck == 1) {
				redirectAttributes.addFlashAttribute("kakoLogin_complete", "ok");
				viewName = "redirect:/index";
				
			}else {
				System.out.println("Error");
			}
		}
		
		
		return viewName;
	}
	
	/**
	 *  login_proc.do
	 */
	@PostMapping("login")
	public String login_proc(MemberDto memberDto, HttpSession session, RedirectAttributes redirectAttributes) {
		
		int result = memberService.getLoginIdCheck(memberDto);
		if(result == 1) {
			SessionDto sessionDto = memberService.getMemberLogin(memberDto);


			if(sessionDto != null && sessionDto.getLoginResult() == 1) {
				log.info("Login_mid -> {}",sessionDto.getMid());
				session.setAttribute("sessionVo", sessionDto);

				redirectAttributes.addFlashAttribute("login_complete", "ok");
				return "redirect:/index";
			}
			
		}else {
			redirectAttributes.addFlashAttribute("login_fail", "no");
			return"redirect:/login";
		}
		
		return "redirect:/index";
	}

	/**
	 *  login.do
	 */
	@GetMapping("login")
	public String login() {
		return "/pages/mydining/login";
	}

}
