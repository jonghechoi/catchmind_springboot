package com.springboot.catchmind.controller;


import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.catchmind.service.MyDiningService;
import com.springboot.catchmind.vo.ScheduledVo;
import com.springboot.catchmind.vo.SessionVo;
import retrofit2.http.GET;
@Slf4j
@Controller
public class InformationController {
	@Autowired
	private MyDiningService myDiningService;
	
	/**
	 * information - Bookmark insert and delete
	 */
	@GetMapping("information_bookmark_proc")
	public String information_bookmark_proc(HttpSession session, String sid, String rid, RedirectAttributes redirectAttributes) {
		String viewName = "";
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();

		int count = myDiningService.getBookmarkResult(mid, sid);
		
		if(count == 1) {
			int deleteBookmark = myDiningService.getDeleteBookmark(mid, sid);
			
			if(deleteBookmark == 1) {
				redirectAttributes.addFlashAttribute("information_bookmark","delete");
				viewName = "redirect:/information?sid="+sid+"&rid="+rid;
			}
			
		}else {
			int insertBookmark = myDiningService.getInsertBookmark(mid, sid);
			
			if(insertBookmark == 1) {
				redirectAttributes.addFlashAttribute("information_bookmark","insert");
				viewName = "redirect:/information?sid="+sid+"&rid="+rid;
			}
		}
		
		
		
		return viewName;
	}
	
	
	/**
	 * cancle_reservation
	 */
	@PostMapping("cancle_reservation")
	public String cancle_reservation_proc(String rid, RedirectAttributes redirectAttributes) {
		String viewName = "";
		int result = myDiningService.getUpdateDeleteYN(rid);
		
		if(result == 1) {
			redirectAttributes.addFlashAttribute("cancle_reservation", "ok");
			viewName = "redirect:/mydining_scheduled";
		}
		
		return viewName;
	}
	
	
	/**
	 * cancle_reservation form
	 */
	@GetMapping("cancle_reservation")
	public String cancle_reservation(String rid, Model model) {
		model.addAttribute("rid", rid);

		return "/pages/mydining/cancle_reservation";
	}
	
	/**
	 * information form
	 */
	@GetMapping("information")
	public String information(HttpSession session, String sid, String rid, Model model) {
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		
		ScheduledVo scheduledVo = myDiningService.getInformation(mid, sid, rid);
		model.addAttribute("scheduledVo", scheduledVo);

		return "/pages/mydining/information";
	}
}
