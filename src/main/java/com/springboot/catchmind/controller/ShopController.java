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



	/**
	 *	�������̹��� preview - shop_information_photoBring.do
	 */
	@RequestMapping(value = "/shop_information_photoBring.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> shop_information_photoBring(@RequestParam("sid") String sid,
															  @RequestParam("count") int count,
															  @RequestParam("photos") String photos,
															  HttpServletRequest request,
															  HttpServletResponse response) throws Exception {
		String root_path = request.getSession().getServletContext().getRealPath("/"); 
		String attach_path = "\\resources\\upload\\";
		String imgPath = root_path + attach_path;
		
		Gson gson = new Gson();
		
		Map<String, Integer> photosMap = gson.fromJson(photos, new TypeToken<HashMap<String, Integer>>() {}.getType());
		
		for(Map.Entry<String, Integer> entry : photosMap.entrySet()) {
			System.out.println("key: " + entry.getKey() + ", value : " + entry.getValue());
		}
		
		//ShopPhotoVo shopPhotoVo = shopService.getShopPhotoSelect(sid);
		ShopPhotoDto shopPhotoVo = shopService.getShopPhotoSelect(sid);
		
		List<File> imageFiles = new ArrayList<File>();
		if(photosMap.get("photo1") == 1) {
			String imgPath1 = imgPath + shopPhotoVo.getSphoto1();
		    File imageFile1 = new File(imgPath1);
		    imageFiles.add(imageFile1);
		}
		if(photosMap.get("photo2") == 1) {
			String imgPath2 = imgPath + shopPhotoVo.getSphoto2();
		    File imageFile2 = new File(imgPath2);
		    imageFiles.add(imageFile2);
		}
		if(photosMap.get("photo3") == 1) {
			String imgPath3 = imgPath + shopPhotoVo.getSphoto3();
		    File imageFile3 = new File(imgPath3);
		    imageFiles.add(imageFile3);
		}
		if(photosMap.get("photo4") == 1) {
			String imgPath4 = imgPath + shopPhotoVo.getSphoto4();
		    File imageFile4 = new File(imgPath4);
		    imageFiles.add(imageFile4);
		}
		if(photosMap.get("photo5") == 1) {
			String imgPath5 = imgPath + shopPhotoVo.getSphoto5();
		    File imageFile5 = new File(imgPath5);
		    imageFiles.add(imageFile5);
		}
	    
		List<byte[]> byteArrayList = new ArrayList<byte[]>();
		for(File imageFile : imageFiles) {
			FileInputStream fileInputStream = new FileInputStream(imageFile);
			byte[] imageData = IOUtils.toByteArray(fileInputStream);
			byteArrayList.add(imageData);
		}

		List<String> jsonStringList = new ArrayList<String>();
	    for (byte[] byteArray : byteArrayList) {
	        jsonStringList.add(Base64.getEncoder().encodeToString(byteArray));
	    }
	    
	    String json = gson.toJson(jsonStringList);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    return new ResponseEntity<String>(json, headers, HttpStatus.OK);	    
	}
	
	/**
	 *	�����������Է� - shop_information_proc.do 
	 */
	@RequestMapping(value = "/shop_information_proc.do", method = RequestMethod.POST)
	@ResponseBody
	public String shop_information_proc(ShopVo shopVo) {
		// SCONFIRMYN�� 'N'�̸� ù����̹Ƿ� INSERT, 'Y'�̸� �����̹Ƿ� UPDATE
		int InsertOrUpdate = shopService.getRegistrationCheck(shopVo);
		if(InsertOrUpdate == 0) {
			System.out.println("shop_information_proc.do�� InsertOrUpdate�� 0�϶� --> " + InsertOrUpdate);
			String.valueOf(shopService.getDetailInsert(shopVo));
		}else {
			System.out.println("shop_information_proc.do�� InsertOrUpdate�� 1�϶� --> " + InsertOrUpdate);
			String.valueOf(shopService.getDetailUpdate(shopVo));
		}
		
		return String.valueOf(shopService.getDetailInsert(shopVo));
	}
	
	/**
	 *	Facility
	 */
	@RequestMapping(value = "/shop_information_facility_proc.do", method = RequestMethod.POST)
	@ResponseBody
	public String shop_information_facility_proc(FacilityVo facilityVo) {
		return String.valueOf(shopService.getDetailFacilityUpdate(facilityVo));
	}

	@GetMapping("shop_information_facility/{sid}")
	public String shop_information_facility(HttpSession session,@PathVariable String sid, Model model) {
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		//FacilityVo facilityVo = shopService.getShopFacilitySelect(sid);
		FacilityDto facilityDto = shopService.getShopFacilitySelect(sid);
		model.addAttribute("FacilityVo", facilityDto);
		return "/pages/shop/shop_information_facility";
	}
	
	/**
	 *	Reservation
	 */
	@RequestMapping(value = "/shop_reservation.do", method = RequestMethod.GET)
	public String shop_reservation(HttpSession session, String sid, Model model) {
		String destination = "";
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		
		if(sessionVo.getSid() != null && String.valueOf(sessionVo.getSid().charAt(0)).equals("S")) {
			model.addAttribute("shopVo", shopService.getShopInfoSelect(sessionVo.getSid()));
			destination = "pages/shop/shop_reservation";
		}else {
			destination = "redirect:/login_role.do";
		}
		return destination;
	}

	@RequestMapping(value = "/shop_reservation_proc.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String shop_reservation_proc(@RequestParam("sid") String sid,
	                                    @RequestParam("startDate") String startDate,
	                                    @RequestParam("endDate") String endDate) {
	    try {
	        dateCheck(startDate, endDate);
	    } catch (Exception e) {
	    	Logger logger = LoggerFactory.getLogger(ShopController.class);
	    	logger.error("���ᳯ¥�� ���۳�¥���� �����ϴ�. ������ �߻���ŵ�ϴ�. loooooooooooooog", e);
	    }

	    Map<String, String> map = new HashMap<String, String>();
	    map.put("sid", sid);
	    map.put("startDate", startDate);
	    map.put("endDate", endDate);

	    return shopService.getShopReservationSelectGson(map);
	}

	private void dateCheck(String startDate, String endDate) throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date startDateForm = dateFormat.parse(startDate);
	    Date endDateForm = dateFormat.parse(endDate);

	    if (startDateForm.compareTo(endDateForm) > 0) {
	        throw new Exception("���ᳯ¥�� ���۳�¥���� �����ϴ�. ������ �߻���ŵ�ϴ�.");
	    }
	}
	
} 
