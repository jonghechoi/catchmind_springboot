package com.springboot.catchmind.controller;


import javax.servlet.http.HttpSession;

import com.springboot.catchmind.dto.ScheduledDto;
import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.service.MyDiningServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.catchmind.service.MyDiningService;
import retrofit2.http.GET;
@Slf4j
@Controller
public class InformationController {
	@Autowired
	private MyDiningServiceImpl myDiningService;
	
	/**
	 * information - Bookmark insert and delete
	 */
	@GetMapping("information_bookmark/{sid}/{rid}")
	public String information_bookmark_proc(HttpSession session, @PathVariable String sid, @PathVariable String rid,
											RedirectAttributes redirectAttributes) {
		String viewName = "";
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();

		int count = myDiningService.getBookmarkResult(mid, sid);
		
		if(count == 1) {
			int deleteBookmark = myDiningService.getDeleteBookmark(mid, sid);
			
			if(deleteBookmark == 1) {
				redirectAttributes.addFlashAttribute("information_bookmark","delete");
				viewName = "redirect:/information/"+sid+"/"+rid;
			}
			
		}else {
			int insertBookmark = myDiningService.getInsertBookmark(mid, sid);
			
			if(insertBookmark == 1) {
				redirectAttributes.addFlashAttribute("information_bookmark","insert");
				viewName = "redirect:/information/"+sid+"/"+rid;
			}
		}
		
		
		
		return viewName;
	}
	
	
	/**
	 * cancle_reservation
	 */
	@PostMapping("cancle_reservation")
	public String cancle_reservation_proc(@RequestParam String rid, @RequestParam String rdate, RedirectAttributes redirectAttributes) {
		String viewName = "";
		int result = myDiningService.getUpdateDeleteYN(rid);
		int cancelResult = myDiningService.getUpdateCancelNoshow(rid, rdate);

		if(cancelResult == 1) {
			if(result == 1) {
				log.info("Cancel RID Number ->", rid);

				redirectAttributes.addFlashAttribute("cancle_reservation", "ok");
				viewName = "redirect:/mydining_cancel_noshow";
			}
		}
		return viewName;
	}
	
	
	/**
	 * cancle_reservation form
	 */
	@GetMapping("cancle_reservation/{rid}/{rdate}")
	public String cancle_reservation(@PathVariable String rid, @PathVariable String rdate, Model model) {
		model.addAttribute("rid", rid);
		model.addAttribute("rdate", rdate);

		return "/pages/mydining/cancle_reservation";
	}
	
	/**
	 * information form
	 */
	@GetMapping("information/{sid}/{rid}")
	public String information(HttpSession session, @PathVariable String sid, @PathVariable String rid, Model model) {
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		log.info("sid -> {}", sid);
		log.info("rid -> {}", rid);
		ScheduledDto scheduledDto = myDiningService.getInformation(mid, sid, rid);
		model.addAttribute("scheduledVo", scheduledDto);

		return "/pages/mydining/information";
	}
}
