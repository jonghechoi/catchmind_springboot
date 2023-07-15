package com.springboot.catchmind.controller;

import java.util.ArrayList;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.NoticeVo;
import com.springboot.catchmind.vo.ReviewVo;
import com.springboot.catchmind.vo.ShopVo;

@Controller
public class AdminController {
	@Autowired
	private MemberServiceImpl memberService;
	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private ShopServiceImpl shopService;
	@Autowired
	private NoticeServiceImpl noticeService;

	@GetMapping("admin")
	public String admin() {
		return "/admin";
	}

	/**
	 *	Admin member
	 */
	@GetMapping("admin_member_list")
	/*@RequestMapping(value = "admin_member_list", method = RequestMethod.GET)*/
	public String admin_member_list() {
		return "/pages/admin/admin_member";
	}

	@GetMapping("admin_member_info/{mid}")
	public String admin_member_info(@PathVariable String mid, Model model) {
		model.addAttribute("member", adminService.getCertainMemberSelect(mid));
		return "/pages/admin/admin_member_info";
	}

	@GetMapping("admin_member_modify/{mid}")
	public String admin_member_modify(@PathVariable String mid, Model model) {
		model.addAttribute("member", adminService.getCertainMemberSelect(mid));
		return "/pages/admin/admin_member_modify";
	}

	@RequestMapping(value = "/admin_member_modify_update.do", method = RequestMethod.POST)
	@ResponseBody
	public String admin_member_modify_update(@ModelAttribute("memberVo") MemberVo memberVo) {
		return Integer.toString(memberService.getUpdate(memberVo));
	}

	/**
	 *	Admin shop
	 */
	@GetMapping("admin_shop_information")
	public String admin_shop_information() {
		return "/pages/admin/admin_shop_information";
	}

	@RequestMapping(value = "/admin_shop_information_waiting_cancel.do", method = RequestMethod.GET)
	@ResponseBody
	public String admin_shop_information_waiting_cancel(String sid) {
		return String.valueOf(adminService.getCancelUpdate(sid));
	}

	@GetMapping("admin_shop_registeration_check")
	public String admin_shop_registeration_check() {
		return "/pages/admin/admin_shop_registeration_check";
	}	

	@GetMapping("admin_shop_registeration_enter")
	public String admin_shop_registeration_enter() {
		return "/pages/admin/admin_shop_registeration_enter";
	}

	/**
	 *	Admin review
	 */
	@GetMapping("admin_review")
	public String admin_review() {
		return "/pages/admin/admin_review";
	}

	@GetMapping("admin_review_selected")
	public String admin_review_selected(Model model) {
		model.addAttribute("review", adminService.getReviewMainList());
		return "/pages/admin/admin_review_selected";
	}

	@GetMapping("admin_review_detail/{goMain}/{rid}")
	public String admin_review_detail(@PathVariable Boolean goMain,@PathVariable String rid, Model model) {
		model.addAttribute("reviewJson", adminService.getReviewDetailSelectJson(rid));
		model.addAttribute("goMain", goMain);
		return "/pages/admin/admin_review_detail";
	}

	/**
	 *	Admin notice
	 */
	@GetMapping("admin_notice_list")
	public String admin_notice_list() {
		return "pages/admin/admin_notice_list";
	}

	@GetMapping("admin_notice_content/{nid}")
	public String admin_notice_content(@PathVariable String nid, Model model) {
		model.addAttribute("notice", adminService.getNoticeSelect(nid));
		return "/pages/admin/admin_notice_content";
	}

	@GetMapping("admin_notice_delete/{nid}")
	public String admin_notice_delete(@PathVariable String nid, Model model) {
		model.addAttribute("nid", nid);
		return "/pages/admin/admin_notice_delete";
	}

	@GetMapping("admin_notice_update/{nid}")
	public String admin_notice_update(@PathVariable String nid, Model model) {
		model.addAttribute("notice", adminService.getNoticeSelect(nid));
		return "/pages/admin/admin_notice_update";
	}

	@GetMapping("notice_write")
	public String admin_notice_write() {
		return "/pages/admin/admin_notice_write";
	}
}
