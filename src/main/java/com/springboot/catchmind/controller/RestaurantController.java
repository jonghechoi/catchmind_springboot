package com.springboot.catchmind.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.catchmind.dao.FacilityDao;
import com.springboot.catchmind.dao.ReservationDao;
import com.springboot.catchmind.dao.RestaurantPolicyDao;
import com.springboot.catchmind.dao.ReviewDao;
import com.springboot.catchmind.dao.ShopDao;
import com.springboot.catchmind.dao.ShopPhotoDao;
import com.springboot.catchmind.dao.TabletypeDao;
import com.springboot.catchmind.vo.FacilityVo;
import com.springboot.catchmind.vo.ReservationVo;
import com.springboot.catchmind.vo.RestaurantPolicyVo;
import com.springboot.catchmind.vo.ReviewVo;
import com.springboot.catchmind.vo.ShopPhotoVo;
import com.springboot.catchmind.vo.ShopVo;
import com.springboot.catchmind.vo.TabletypeVo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Controller
public class RestaurantController {
	/*
	 * select_guestnumber -  select guest number
	 * */
	@RequestMapping(value="/select_rtime", method=RequestMethod.POST)
	@ResponseBody
	public String select_rtime(@RequestParam(value="sid") String sid,
							   @RequestParam(value="rdate") String rdate,
							   @RequestParam(value="rtabletype") String rtabletype,
							   @RequestParam(value="guestnumber") int guestnumber) throws ParseException {
		//System.out.println(sid);
		//System.out.println(rdate);
		//System.out.println(rtabletype);
		//System.out.println(guestnumber);
		Map<String, String> param = new HashMap<String, String>();
		Map<String, Integer> param2 = new HashMap<String, Integer>();
		ShopDao shopDao = new ShopDao();
		ShopVo shopVo = shopDao.select(sid);
		ReservationDao reservationDao = new ReservationDao();
		TabletypeDao tabletypeDao = new TabletypeDao();

		int rtabletypeNum = tabletypeDao.selectRtabletypeNum(sid, rtabletype);
		
		param.put("sid", sid);
		param.put("rdate", rdate);
		param.put("rtabletype", rtabletype);
		param.put("sopeninghour", shopVo.getSopeninghour());
		param.put("sclosinghour", shopVo.getSclosinghour());
		
		param2.put("rtabletypeNum", rtabletypeNum);
		param2.put("guestnumber", guestnumber);
		
		JsonObject jobj = reservationDao.selectRtime(param, param2);
		//System.out.println("jobj --> " + jobj.getAsString());
		
		return new Gson().toJson(jobj);		
	}
	
	
	/*
	 * select_guestnumber -  select guest number
	 * */
	@RequestMapping(value="/select_guestnumber", method=RequestMethod.POST)
	@ResponseBody
	public String select_guestnumber(@RequestParam(value="sid") String sid,
							   	   @RequestParam(value="rdate") String rdate,
								   @RequestParam(value="rtabletype") String rtabletype) throws ParseException {
		//System.out.println(sid);
		//System.out.println(rdate);
		//System.out.println(rtabletype);
		Map<String, String> param = new HashMap<String, String>();
		ShopDao shopDao = new ShopDao();
		ShopVo shopVo = shopDao.select(sid);
		ReservationDao reservationDao = new ReservationDao();
		TabletypeDao tabletypeDao = new TabletypeDao();

		JsonObject jobj = new JsonObject(); 
		
		param.put("sid", sid);
		param.put("rdate", rdate);
		param.put("rtabletype", rtabletype);
		param.put("sopeninghour", shopVo.getSopeninghour());
		param.put("sclosinghour", shopVo.getSclosinghour());
		jobj.addProperty("minOccupiedTableNum", reservationDao.selectGuestnumber(param)); 
		jobj.addProperty("rtabletypeNum", tabletypeDao.selectRtabletypeNum(sid, rtabletype)); 
		//System.out.println("rtabletypeNum --> " + tabletypeDao.selectRtabletypeNum(sid, rtabletype));
		
		return new Gson().toJson(jobj);	
	}
	
	
	/*
	 * select_rtabletype -  select table type
	 * */
	@RequestMapping(value="/select_rtabletype", method=RequestMethod.POST)
	@ResponseBody
	public String select_rtabletype(@RequestParam(value="sid") String sid,
								   	@RequestParam(value="rdate") String rdate) {
		
		//System.out.println(sid);
		//System.out.println(rdate);
		TabletypeDao tabletypeDao = new TabletypeDao();
		TabletypeVo tabletypeVo = tabletypeDao.select(sid);
		
		JsonObject jobj = new JsonObject(); 
		jobj.addProperty("sid", tabletypeVo.getSid()); 
		jobj.addProperty("rooftop", tabletypeVo.getRooftop()); 
		jobj.addProperty("terrace", tabletypeVo.getTerrace()); 
		jobj.addProperty("bar", tabletypeVo.getBar()); 
		jobj.addProperty("dininghall", tabletypeVo.getDininghall()); 
		jobj.addProperty("windowseat", tabletypeVo.getWindowseat()); 
		jobj.addProperty("privateroom", tabletypeVo.getPrivateroom()); 
		jobj.addProperty("rental", tabletypeVo.getRental()); 
		
		return new Gson().toJson(jobj);	
	}
	
	
	/**
	 * restaurant - �젅�뒪�넗�옉 �뤌
	 */
	@RequestMapping(value="/restaurant", method=RequestMethod.GET)
	public ModelAndView restaurant(String sid) {

		ModelAndView model = new ModelAndView();
		ShopDao shopDao = new ShopDao();
		ReviewDao reviewDao = new ReviewDao();
		ShopPhotoDao shopPhotoDao = new ShopPhotoDao();
		RestaurantPolicyDao rsPolicyDao = new RestaurantPolicyDao();
		FacilityDao facilityDao = new FacilityDao();
		TabletypeDao tabletypeDao = new TabletypeDao();
		

		ShopVo shopVo = shopDao.select(sid);
		int starAvg = reviewDao.starAvg(sid);
		int totalReviewCount = reviewDao.totalReviewCount(sid);
		Map<String, String> priceInStringMap = shopDao.priceInString(sid);
		ShopPhotoVo shopPhotoVo = shopPhotoDao.select(sid);
		ArrayList<RestaurantPolicyVo> rsPolicyList = rsPolicyDao.select(sid);
		int totalReviewPhotoCount = reviewDao.totalReviewPhotoCount(sid);
		ArrayList<ReviewVo> reviewList = reviewDao.select(sid);
		ArrayList<RestaurantPolicyVo> ptitleNotNullList = rsPolicyDao.ptitleNotNullList(sid);
		FacilityVo facilityVo = facilityDao.select(sid);
		TabletypeVo tabletypeVo = tabletypeDao.select(sid);
		
		model.addObject("shopVo", shopVo);
		model.addObject("starAvg", starAvg);
		model.addObject("totalReviewCount", totalReviewCount);
		model.addObject("priceInStringMap", priceInStringMap);
		model.addObject("shopPhotoVo", shopPhotoVo);
		model.addObject("rsPolicyList", rsPolicyList);
		model.addObject("totalReviewPhotoCount", totalReviewPhotoCount);
		model.addObject("reviewList", reviewList);
		model.addObject("ptitleNotNullList", ptitleNotNullList);
		model.addObject("facilityVo", facilityVo);
		model.addObject("tabletypeVo", tabletypeVo);
		
		//System.out.println("tabletypeVo.rooftop===>" + tabletypeVo.getRooftop());
		
		model.setViewName("/pages/restaurant/restaurant");
		
//		System.out.println(facilityList.get(0).getFacilityicon());
//		System.out.println(facilityList.get(1).getFacilityicon());
		
		return model;
	}
}
