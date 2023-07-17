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

import com.springboot.catchmind.dto.*;
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
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		//FacilityVo facilityVo = shopService.getShopFacilitySelect(sid);
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
