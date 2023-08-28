package com.springboot.catchmind.controller;

import javax.servlet.http.HttpSession;

import com.springboot.catchmind.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.catchmind.service.ShopServiceImpl;

@Controller
public class ShopController {

	@Autowired
	private ShopServiceImpl shopService;

	@GetMapping("shop_information")
	public String shop_information(HttpSession session, Model model) {
		String destination = "";
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");

		String sid = sessionVo.getSid();
		if(sid != null && String.valueOf(sid.charAt(0)).equals("S")) {
			model.addAttribute("ShopVo", shopService.getShopInfoSelect(sid));
			model.addAttribute("FacilityVo", shopService.getShopFacilitySelect(sid));
			model.addAttribute("ShopPhotoVo", shopService.getShopPhotoSelect(sid));

			destination = "pages/shop/shop_information";
		}else {
			session.invalidate();
			destination = "redirect:/login_role";
		}
		return destination;
	}

	@GetMapping("shop_information_facility/{sid}")
	public String shop_information_facility(HttpSession session,@PathVariable String sid, Model model) {
//		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		FacilityDto facilityDto = shopService.getShopFacilitySelect(sid);
		model.addAttribute("FacilityVo", facilityDto);
		return "/pages/shop/shop_information_facility";
	}

	@GetMapping("shop_reservation")
	public String shop_reservation(HttpSession session, Model model) {
		String destination = "";
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");

		String sid = sessionVo.getSid();
		if(sid != null && String.valueOf(sid.charAt(0)).equals("S")) {
			model.addAttribute("shopVo", shopService.getShopInfoSelect(sid));
			destination = "/pages/shop/shop_reservation";
		}else {
			session.invalidate();
			destination = "redirect:/login_role";
		}
		return destination;
	}
}
