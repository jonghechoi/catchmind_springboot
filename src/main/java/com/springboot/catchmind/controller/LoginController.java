package com.springboot.catchmind.controller;

import javax.servlet.http.HttpSession;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.catchmind.service.MemberService;
import com.springboot.catchmind.service.ShopService;
import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.SessionVo;
import com.springboot.catchmind.vo.ShopVo;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ShopService shopService;
	
	/**
	 * logout.do
	 */
	@RequestMapping(value= "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		
		if(sessionVo != null) {
			session.invalidate();
			
			model.addObject("logout_result", "ok");
		}
		model.setViewName("index");
		
		return model;
	}
	
	/**
	 *  login_role_proc.do
	 */
	@PostMapping("login_role")
	public ModelAndView login_role_proc(MemberVo memberVo, HttpSession session, ShopVo shopVo, RedirectAttributes redirectAttributes) 
															throws Exception{
		ModelAndView model = new ModelAndView();
		
		if(memberVo.getMemberId() != null && shopVo.getSid() == null) {
			int adminIdCheck = memberService.getRoleIdCheck(memberVo);
			
			if(adminIdCheck == 1) {
				SessionVo sessionVo = memberService.getRoleLogin(memberVo);
				session.setAttribute("sessionVo", sessionVo);
				
				redirectAttributes.addFlashAttribute("loginRole_complete", "ok");
				model.setViewName("redirect:/index");
			}else {
				redirectAttributes.addFlashAttribute("loginRole_fail", "no");
				model.setViewName("redirect:/login_role");
			}
			
		}else if(shopVo.getSid() != null && memberVo.getMid() == null) {
			System.out.println(shopVo.getRoleid());
			int shopIdCheck = shopService.getShopIdCheck(shopVo);
			
			if(shopIdCheck == 1) {
				SessionVo sessionVo = shopService.getShopLogin(shopVo);
				session.setAttribute("sessionVo", sessionVo);
				
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
	@RequestMapping(value = "/kakao_login_proc.do", method = RequestMethod.POST)
	public String kakao_login_proc(MemberVo memberVo, RedirectAttributes redirectAttributes, HttpSession session) {
		String viewName = "";
		
		int idCheck = memberService.getKakaoIdCheck(memberVo);
		System.out.println(idCheck);
		
		if(idCheck ==  1) {
			SessionVo sessionVo = memberService.getKakaoLogin(memberVo);
			session.setAttribute("sessionVo", sessionVo);
			redirectAttributes.addFlashAttribute("kakoLogin_complete", "ok");
			viewName = "redirect:/index";
			
		}else if(idCheck == 0) {
			int joinCheck = memberService.getKakaoJoin(memberVo);
			
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
	public String login_proc(MemberVo memberVo, HttpSession session, RedirectAttributes redirectAttributes) {
		
		int result = memberService.getLoginIdCheck(memberVo);
		if(result == 1) {
			SessionVo sessionVo = memberService.getMemberLogin(memberVo);
			
			if(sessionVo != null && sessionVo.getLoginResult() == 1) {
				session.setAttribute("sessionVo", sessionVo);
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
