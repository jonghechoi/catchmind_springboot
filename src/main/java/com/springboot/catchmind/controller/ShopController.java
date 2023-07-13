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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	/**
	 *	����������Ȯ�������� - shop_information 
	 */
	@RequestMapping(value = "/shop_information", method = RequestMethod.GET)
	public String shop_information(HttpSession session, String sid, Model model) {
		String destination = "";
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		System.out.println("sessionVo.getSid() --> " + sessionVo.getSid());
		
		if(sessionVo.getSid() != null && String.valueOf(sessionVo.getSid().charAt(0)).equals("S")) {
			ShopVo shopVo = shopService.getShopInfoSelect(sessionVo.getSid());
			FacilityVo facilityVo = shopService.getShopFacilitySelect(sessionVo.getSid());
			ShopPhotoVo shopPhotoVo = shopService.getShopPhotoSelect(sessionVo.getSid());
			
			model.addAttribute("FacilityVo", facilityVo);
			model.addAttribute("ShopVo", shopVo);
			model.addAttribute("ShopPhotoVo", shopPhotoVo);
			
			destination = "pages/shop/shop_information"; 
		}else {
			destination = "redirect:/login_role";
		}
		return destination;
	}

	/**
	 *	�������̹������ε� �� ������Ʈ - shop_imformation *** form ���� ***
	 */
	@RequestMapping(value = "/shop_information_photo", method = RequestMethod.POST)
	@ResponseBody
	public String shop_information_photo(@RequestParam("sid") String sid,
										 @RequestParam("files") String files,
									     @ModelAttribute ShopPhotoVo shopPhotoVo, 
			                             HttpServletRequest request) throws Exception {

		Gson gson = new Gson();
		Type type = new TypeToken<HashMap<String, Integer>>(){}.getType();
		HashMap<String, Integer> map = gson.fromJson(files, type);
		
		int result = -1;
		int insertOrUpdate = shopService.getPhotoSelectCheck(sid);
		if(insertOrUpdate == 0) {
			result = shopService.getPhotoInsert(sid, fileService.multiFileCheck(shopPhotoVo));
		}else {
			fileService.multiFileDelete(sid, map, request);
			result = shopService.getPhotoUpdate(sid, fileService.multiFileUpdateCheck(shopPhotoVo, map));
		}
		
		if(result == 1) {
			if(!shopPhotoVo.getPhotos()[0].equals("")) {
				fileService.multiFilesave(shopPhotoVo, request);
			}else {
				result = 0;
			}
		}else {
			result = 0;
		}
		return String.valueOf(result);
	}

	/**
	 *	�������̹��� preview - shop_information_photoBring
	 */
	@RequestMapping(value = "/shop_information_photoBring", method = RequestMethod.GET)
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
		
		ShopPhotoVo shopPhotoVo = shopService.getShopPhotoSelect(sid);
		
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
	 *	�����������Է� - shop_information_proc 
	 */
	@RequestMapping(value = "/shop_information_proc", method = RequestMethod.POST)
	@ResponseBody
	public String shop_information_proc(ShopVo shopVo) {
		// SCONFIRMYN�� 'N'�̸� ù����̹Ƿ� INSERT, 'Y'�̸� �����̹Ƿ� UPDATE
		int InsertOrUpdate = shopService.getRegistrationCheck(shopVo);
		if(InsertOrUpdate == 0) {
			System.out.println("shop_information_proc�� InsertOrUpdate�� 0�϶� --> " + InsertOrUpdate);
			String.valueOf(shopService.getDetailInsert(shopVo));
		}else {
			System.out.println("shop_information_proc�� InsertOrUpdate�� 1�϶� --> " + InsertOrUpdate);
			String.valueOf(shopService.getDetailUpdate(shopVo));
		}
		
		return String.valueOf(shopService.getDetailInsert(shopVo));
	}
	
	/**
	 *	�����������Է�(facility) - shop_information_facility_proc 
	 */
	@RequestMapping(value = "/shop_information_facility_proc", method = RequestMethod.POST)
	@ResponseBody
	public String shop_information_facility_proc(FacilityVo facilityVo) {
		return String.valueOf(shopService.getDetailFacilityUpdate(facilityVo));
	}
	
	/**
	 *	�����������Է� - �� facility �Է� �˾�
	 */
	@RequestMapping(value = "/shop_information_facility", method = RequestMethod.GET)
	public String shop_information_facility(HttpSession session, String sid, Model model) {
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		FacilityVo facilityVo = shopService.getShopFacilitySelect(sid);
		model.addAttribute("FacilityVo", facilityVo);
		return "pages/shop/shop_information_facility";
	}
	
	/**
	 *	��������������Ȯ�������� - shop_reservation
	 */
	@RequestMapping(value = "/shop_reservation", method = RequestMethod.GET)
	public String shop_reservation(HttpSession session, String sid, Model model) {
		String destination = "";
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		
		if(sessionVo.getSid() != null && String.valueOf(sessionVo.getSid().charAt(0)).equals("S")) {
			model.addAttribute("shopVo", shopService.getShopInfoSelect(sessionVo.getSid()));
			destination = "pages/shop/shop_reservation";
		}else {
			destination = "redirect:/login_role";
		}
		return destination;
	}
	
	/**
	 *	��������������Ȯ�������� ������ - shop_reservation_proc
	 */
	@RequestMapping(value = "/shop_reservation_proc", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
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
