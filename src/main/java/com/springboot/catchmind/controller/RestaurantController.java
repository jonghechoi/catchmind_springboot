package com.springboot.catchmind.controller;

import com.springboot.catchmind.dto.*;
import com.springboot.catchmind.service.FacilityService;
import com.springboot.catchmind.service.ReviewServiceImpl;
import com.springboot.catchmind.service.RestaurantPolicyService;
import com.springboot.catchmind.service.ShopPhotoService;
import com.springboot.catchmind.service.ShopServiceImpl;
import com.springboot.catchmind.service.TabletypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

//import com.google.gson.Gson;
//import com.google.gson.JsonObject;


@Controller
public class RestaurantController {
	@Autowired
	ShopServiceImpl shopServiceImpl;
	@Autowired
	ReviewServiceImpl reviewServiceImpl;
	@Autowired
	ShopPhotoService shopPhotoService;
	@Autowired
	RestaurantPolicyService restaurantPolicyService;
	@Autowired
	FacilityService facilityService;
	@Autowired
	TabletypeService tabletypeService;

	
	/**
	 * restaurant
	 */
	//@RequestMapping(value="/restaurant.do", method=RequestMethod.GET)
	@GetMapping("restaurant/{sid}")
	public String restaurant(@PathVariable String sid, Model model) {
		ShopDto shopDto = shopServiceImpl.shopSelect(sid);
		int starAvg = reviewServiceImpl.getStarAvg(sid);
		int totalReviewCount = reviewServiceImpl.getTotalReviewCount(sid);
		int totalReviewPhotoCount = reviewServiceImpl.getTotalReviewPhotoCount(sid);
		ArrayList<ReviewDto> reviewList = reviewServiceImpl.reviewListSelect(sid);
		ShopPhotoDto shopPhotoDto = shopPhotoService.shopPhotoSelect(sid);
		ArrayList<RestaurantPolicyDto> rsPolicyList = restaurantPolicyService.rsPolicySelect(sid);
		ArrayList<RestaurantPolicyDto> ptitleNotNullList = restaurantPolicyService.rsPolicyNotNullList(sid);
		FacilityDto facilityDto = facilityService.facilitySelect(sid);
		TabletypeDto tabletypeDto = tabletypeService.tabletypeSelect(sid);

		model.addAttribute("shopDto", shopDto);
		model.addAttribute("starAvg", starAvg);
		model.addAttribute("totalReviewCount", totalReviewCount);
		model.addAttribute("totalReviewPhotoCount", totalReviewPhotoCount);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("shopPhotoDto", shopPhotoDto);
		model.addAttribute("rsPolicyList", rsPolicyList);
		model.addAttribute("ptitleNotNullList", ptitleNotNullList);
		model.addAttribute("facilityDto", facilityDto);
		model.addAttribute("tabletypeDto", tabletypeDto);
		
		return "/pages/restaurant/restaurant";
	}
}
