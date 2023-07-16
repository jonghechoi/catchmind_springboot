package com.springboot.catchmind.controller;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.FacilityDto;
import com.springboot.catchmind.dto.ShopDto;
import com.springboot.catchmind.dto.ShopPhotoDto;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.catchmind.service.FileServiceImpl;
import com.springboot.catchmind.service.ShopServiceImpl;
import com.springboot.catchmind.vo.FacilityVo;
import com.springboot.catchmind.vo.SessionVo;
import com.springboot.catchmind.vo.ShopPhotoVo;
import com.springboot.catchmind.vo.ShopVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class ShopController {

	@Autowired
	private ShopServiceImpl shopService;
	@Autowired
	private FileServiceImpl fileService;

	@GetMapping("shop_information/{sid}")
	public String shop_information(HttpSession session,@PathVariable String sid, Model model) {
		String destination = "";

		model.addAttribute("ShopVo", shopService.getShopInfoSelect(sid));
		model.addAttribute("FacilityVo", shopService.getShopFacilitySelect(sid));
		model.addAttribute("ShopPhotoVo", shopService.getShopPhotoSelect(sid));

		destination = "/pages/shop/shop_information";

		return destination;

// 	스프링부터 전환 작업하면서 현수꺼 합쳐지고 세션 인터셉터 적용 되면 아래 로직대로 다시 구성해야함!!!
//		String destination = "";
//		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
//		System.out.println("sessionVo.getSid() --> " + sessionVo.getSid());
//
//		if(sessionVo.getSid() != null && String.valueOf(sessionVo.getSid().charAt(0)).equals("S")) {
//			ShopVo shopVo = shopService.getShopInfoSelect(sessionVo.getSid());
//			FacilityVo facilityVo = shopService.getShopFacilitySelect(sessionVo.getSid());
//			ShopPhotoVo shopPhotoVo = shopService.getShopPhotoSelect(sessionVo.getSid());
//
//			model.addAttribute("FacilityVo", facilityVo);
//			model.addAttribute("ShopVo", shopVo);
//			model.addAttribute("ShopPhotoVo", shopPhotoVo);
//
//			destination = "pages/shop/shop_information";
//		}else {
//			destination = "redirect:/login_role.do";
//		}
//		return destination;
	}

	@GetMapping("shop_information_facility/{sid}")
	public String shop_information_facility(HttpSession session,@PathVariable String sid, Model model) {
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		//FacilityVo facilityVo = shopService.getShopFacilitySelect(sid);
		FacilityDto facilityDto = shopService.getShopFacilitySelect(sid);
		model.addAttribute("FacilityVo", facilityDto);
		return "/pages/shop/shop_information_facility";
	}

	@GetMapping("shop_reservation/{sid}")
	public String shop_reservation(HttpSession session,@PathVariable String sid, Model model) {
		String destination = "";
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		
//		if(sessionVo.getSid() != null && String.valueOf(sessionVo.getSid().charAt(0)).equals("S")) {
//			model.addAttribute("shopVo", shopService.getShopInfoSelect(sessionVo.getSid()));
			// session의 sid 값으로 꼭 바꾸기!!
			model.addAttribute("shopVo", shopService.getShopInfoSelect(sid));
			destination = "/pages/shop/shop_reservation";
//		}else {
//			destination = "redirect:/login_role.do";
//		}
		return destination;
	}
}
