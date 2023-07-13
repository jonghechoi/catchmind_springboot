package com.springboot.catchmind.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.catchmind.service.MyDiningService;
import com.springboot.catchmind.vo.ScheduledVo;
import com.springboot.catchmind.vo.SessionVo;

@Controller
public class InformationController {
	@Autowired
	private MyDiningService myDiningService;
	
	/**
	 * �ϸ�ũ üũ �� �߰� ����
	 */
	@RequestMapping(value = "/information_bookmark_proc", method = RequestMethod.GET)
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
	 * ���� ��� ó�� - cancle_reservation_proc
	 */
	@RequestMapping(value = "/cancle_reservation_proc", method = RequestMethod.POST)
	public ModelAndView cancle_reservation_proc(String rid, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView();
		
		int result = myDiningService.getUpdateDeleteYN(rid);
		
		if(result == 1) {
			redirectAttributes.addFlashAttribute("cancle_reservation", "ok");
			model.setViewName("redirect:/mydining_scheduled");
		}
		
		return model;
	}
	
	
	/**
	 * ���� ��� - cancle_reservation
	 */
	@RequestMapping(value = "/cancle_reservation", method = RequestMethod.GET)
	public ModelAndView cancle_reservation(String rid) {
		ModelAndView model = new ModelAndView();
		model.addObject("rid", rid);
		model.setViewName("pages/mydining/cancle_reservation");
		return model;
	}
	
	/**
	 * ���� �Ĵ� ���� - information
	 */
	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public ModelAndView information(HttpSession session, String sid, String rid) {
		ModelAndView model = new ModelAndView();
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		
		ScheduledVo scheduledVo = myDiningService.getInformation(mid, sid, rid);
		model.addObject("scheduledVo", scheduledVo);
		model.setViewName("pages/mydining/information");
		
		return model;
	}
}
