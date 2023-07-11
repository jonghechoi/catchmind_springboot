package com.springboot.catchmind.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.catchmind.dao.ReservationDao;
import com.springboot.catchmind.dao.RestaurantPolicyDao;
import com.springboot.catchmind.dao.ShopDao;
import com.springboot.catchmind.vo.RestaurantPolicyVo;
import com.springboot.catchmind.vo.SessionVo;
import com.springboot.catchmind.vo.ShopVo;

@Controller
public class ReservationController {
	/*
	 * booking_with_payment.do  
	 */
	@RequestMapping(value="/booking_with_payment.do", method=RequestMethod.POST)
	public String booking_with_payment(@RequestParam(value="sid") String sid, 
									   @RequestParam(value="rdate") String rdate, 
									   @RequestParam(value="rtime") String rtime, 
									   @RequestParam(value="rtabletype") String rtabletype, 
									   @RequestParam(value="guestnumber") int guestnumber, 
									   @RequestParam(value="paymentAmount") int paymentAmount,
									   @RequestParam(value="rrequest") String rrequest,
									   @RequestParam(value="contact") String contact,
									   HttpSession session) throws ParseException {
		Map<String, String> param = new HashMap<String, String>();
		Map<String, Integer> param2 = new HashMap<String, Integer>();
		String route = null;
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		System.out.println(rrequest);
		System.out.println(contact);
		
		param.put("sid", sid);
		param.put("rdate", rdate);
		param.put("rtime", rtime);
		param.put("rtabletype", rtabletype);
		param.put("rrequest", rrequest);
		param.put("contact", contact);
		param.put("mid", mid);
		
		param2.put("guestnumber", guestnumber);
		param2.put("amount", paymentAmount);
		
		ReservationDao reservationDao = new ReservationDao();
		int result = reservationDao.insert_payment(param, param2);
		
		if(result == 1) {
			route = "redirect:/mydining_scheduled.do"; 		
		}
		else {
			//예약 실패 - 에러페이지 호출 필요
			System.out.println("Error - Booking with payment");
		}
		
		return route;
	}
	
	
	
	/*
	 * booking_without_payment.do 
	 */
	@RequestMapping(value="/booking_without_payment.do", method=RequestMethod.POST)
	public String booking_without_payment(String sid, String rdate, String rtabletype, int guestnumber, 
										  String rtime, String rrequest, String contact, HttpSession session) 
												  throws ParseException {
		Map<String, String> param = new HashMap<String, String>();
		String route = null;
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		//System.out.println(rrequest);
		//System.out.println(rphone);
		
		param.put("sid", sid);
		param.put("rdate", rdate);
		param.put("rtabletype", rtabletype);
		param.put("rtime", rtime);
		param.put("rrequest", rrequest);
		param.put("rphone", contact);
		param.put("mid", mid);
		
		ReservationDao reservationDao = new ReservationDao();
		int result = reservationDao.insert(param, guestnumber);
		
		if(result == 1) {
			route = "redirect:/mydining_scheduled.do"; 		
		}
		else {
			//예약 실패 - 에러페이지 호출 필요
			System.out.println("Error - Booking without payment");
		}
		
		return route;
	}
	
	
	/**
	 * reservation_proc.do - reservation values sending 
	 */
	@RequestMapping(value="/reservation_proc.do", method=RequestMethod.POST)
	public ModelAndView reservation_proc(String sid, String rdate, String rtabletype, int guestnumber, 
										 String rtime, HttpSession session) throws ParseException {
		
		ModelAndView model = new ModelAndView();
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		//System.out.println(mid);
		
		Map<String, String> param = new HashMap<String, String>();
		ShopDao shopDao = new ShopDao();
		RestaurantPolicyDao rsPolicyDao = new RestaurantPolicyDao();
		
		//System.out.println("sid ---> " + sid);
		//System.out.println("guestnumber ---> " + guestnumber);
		//System.out.println("rtime ---> " + rtime);
		param.put("sid", sid);
		param.put("rdate", rdate);
		param.put("rtabletype", rtabletype);
		param.put("rtime", rtime);
		ShopVo shopVo = shopDao.select(sid);
		ArrayList<RestaurantPolicyVo> rsPolicyList = rsPolicyDao.select(sid);
		Map<String, String> priceInStringMap = shopDao.priceInString(sid);
		int smealfee = shopVo.getSmealfee();
		int sdeposit = shopVo.getSdeposit();
		
		
		String rdate2 = param.get("rdate");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date rdate3 = transFormat.parse(rdate2);
		Calendar targetDate = Calendar.getInstance();
		targetDate.setTime(rdate3); // 시간 설정
		targetDate.add(Calendar.DAY_OF_MONTH , -3); // 시간 연산
		
		model.addObject("param", param);
		model.addObject("guestnumber", guestnumber);
		model.addObject("shopVo", shopVo);
		model.addObject("rsPolicyList", rsPolicyList);
		model.addObject("priceInStringMap", priceInStringMap);
		model.addObject("targetDate", transFormat.format(targetDate.getTime())); //예약취소가능날짜
		model.addObject("sessionVo", sessionVo); 
		
		
		if(smealfee == 0 && sdeposit == 0) {
			model.setViewName("/pages/reservation/reservation_confirm_nopayment");
		}
		else if(smealfee == 0 && sdeposit > 0) {
			model.addObject("paymentAmount", shopVo.getSdeposit());
			model.setViewName("/pages/reservation/reservation_confirm");
		}
		else if(smealfee > 0 && sdeposit == 0) {
			model.addObject("paymentAmount", shopVo.getSmealfee());
			model.setViewName("/pages/reservation/reservation_confirm");
		}
		
		return model;
	}
}
