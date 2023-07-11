package com.springboot.catchmind.controller;

import java.util.ArrayList;

import com.springboot.catchmind.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.NoticeVo;
import com.springboot.catchmind.vo.ReviewVo;
import com.springboot.catchmind.vo.ShopVo;

@Controller
public class AdminController {

//	@Autowired
//	private PagingServiceImpl pagingService;
	@Autowired
	private MemberServiceImpl memberService;
	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private ShopServiceImpl shopService;
	@Autowired
	private NoticeServiceImpl noticeService;
	
	@RequestMapping(value = "/admin.do", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value = "/admin_member_list.do", method = RequestMethod.GET)
	public String admin_member_list() {
		return "pages/admin/member";
	}
	
	@RequestMapping(value = "/member_list_paging.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String admin_member_list_paging(String page) {
		return adminService.getMemberSelectGson(page);
	}
	
	@RequestMapping(value = "/member_info.do", method = RequestMethod.GET)
	public String admin_member_info(String mid, Model model) {
		model.addAttribute("memberVo", adminService.getCertainMemberSelect(mid));
		//model.addAttribute("memberVo", pagingService.getCertainMemberSelect(mid));
		return "pages/admin/member_info";
	}

	@RequestMapping(value = "/member_modify.do", method = RequestMethod.GET)
	public String admin_member_modify(String mid, Model model) {
		model.addAttribute("memberVo", adminService.getCertainMemberSelect(mid));
		//model.addAttribute("memberVo", pagingService.getCertainMemberSelect(mid));
		return "pages/admin/member_modify";
	}
	

	@RequestMapping(value = "/member_modify_data.do", method = RequestMethod.GET)
	@ResponseBody 
	public String admin_member_modify_data(String mid, Model model) {
		return mid;
	}

	@RequestMapping(value = "/member_modify_update.do", method = RequestMethod.POST)
	@ResponseBody
	public String admin_member_modify_update(@ModelAttribute("memberVo") MemberVo memberVo) {
		return Integer.toString(memberService.getUpdate(memberVo));
	}
	
	@RequestMapping(value = "/admin_shop_information.do", method = RequestMethod.GET)
	public String admin_shop_information() {
		return "pages/admin/admin_shop_information";
	}
	
	@RequestMapping(value = "/admin_shop_information_List.do", method = RequestMethod.GET)
	@ResponseBody
	public String admin_shop_information_waiting_List(@RequestParam("sconfirm") boolean sconfirm, @RequestParam("aconfirmfinal") boolean aconfirmfinal) {
		return adminService.getShopSelectGson(sconfirm, aconfirmfinal);
	}
	
	@RequestMapping(value = "/admin_shop_information_waiting_confirm.do", method = RequestMethod.GET)
	@ResponseBody
	public String admin_shop_information_waiting_confirm(String sid) {
		return String.valueOf(adminService.getConfirmUpdate(sid));
	}
	
	@RequestMapping(value = "/admin_shop_information_waiting_cancel.do", method = RequestMethod.GET)
	@ResponseBody
	public String admin_shop_information_waiting_cancel(String sid) {
		return String.valueOf(adminService.getCancelUpdate(sid));
	}

	@RequestMapping(value = "/admin_shop_registeration_check.do", method = RequestMethod.GET)
	public String admin_shop_registeration_check() {
		return "pages/admin/admin_shop_registeration_check";
	}	
	
	@RequestMapping(value = "/admin_shop_registeration_enter.do", method = RequestMethod.GET)
	public String admin_shop_registeration_enter() {
		return "pages/admin/admin_shop_registeration_enter";
	}

	@RequestMapping(value = "/admin_shop_registeration_proc.do", method = RequestMethod.POST)
	@ResponseBody 
	public String admin_shop_registeration_proc(ShopVo shopVo) {
		return String.valueOf(shopService.getInsert(shopVo));
	}

	@RequestMapping(value = "/admin_review.do", method = RequestMethod.GET)
	public String admin_review() {
		return "pages/admin/admin_review";
	}
	
	@RequestMapping(value = "/admin_review_list.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String admin_review_list(String page) {
		return adminService.getReviewSelectGson(page);
	}
	
	@RequestMapping(value = "/admin_review_detail.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String admin_review_detail(Boolean goMain, String rid, Model model) {
		model.addAttribute("reviewJson", adminService.getReviewDetailSelectGson(rid));
		model.addAttribute("goMain", goMain);
		return "pages/admin/admin_review_detail";
	}
	
	@RequestMapping(value = "/admin_review_selected.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String admin_review_selected(Model model) {
		ArrayList<ReviewVo> list =  adminService.getReviewMainList();
		model.addAttribute("reviewVo", list);
		return "pages/admin/admin_review_selected";
	}

	@RequestMapping(value = "/admin_review_detail_data.do", method = RequestMethod.GET)
	@ResponseBody
	public String admin_review_detail_data(String rid) {
		return String.valueOf(adminService.getReviewMainUpdate(rid));
	}
	
	@RequestMapping(value = "/admin_review_detail_delete_data.do", method = RequestMethod.GET)
	@ResponseBody
	public String admin_review_detail_delete_data(String rid) {
		return String.valueOf(adminService.getReviewMainDelete(rid));
	}
	
	@RequestMapping(value = "/notice_list.do", method = RequestMethod.GET)
	public String admin_notice_list() {
		return "pages/admin/notice_list";
	}
	
	@RequestMapping(value = "/notice_list_paging.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String admin_notice_list_paging(String page) {
		return adminService.getNoticeSelectGson(page);
	}
	
	@RequestMapping(value = "/admin_notice_content.do", method = RequestMethod.GET)
	public String admin_notice_content(String nid, Model model) {
		model.addAttribute("noticeVo", adminService.getNoticeSelect(nid));
		return "pages/admin/admin_notice_content";
	}
	
	@RequestMapping(value = "/notice_delete.do", method = RequestMethod.GET)
	public String admin_notice_delete(String nid, Model model) {
		model.addAttribute("nid", nid);
		return "pages/admin/notice_delete";
	}

	@RequestMapping(value = "/notice_delete_proc.do", method = RequestMethod.GET)
	@ResponseBody
	public String admin_notice_delete_proc(String nid) {
		return String.valueOf(adminService.getNoticeDelete(nid));
	}

	@RequestMapping(value = "/notice_update.do", method = RequestMethod.GET)
	public String admin_notice_update(String nid, Model model) {
		model.addAttribute("noticeVo", adminService.getNoticeSelect(nid));
		return "pages/admin/notice_update";
	}

	@RequestMapping(value = "/notice_update_proc.do", method = RequestMethod.POST)
	@ResponseBody 
	public String admin_notice_update_proc(NoticeVo noticeVo) {
		return String.valueOf(adminService.getNoticeUpdate(noticeVo));
	}
	
	@RequestMapping(value = "/notice_write.do", method = RequestMethod.GET)
	public String admin_notice_write() {
		return "pages/admin/notice_write";
	}
}
