package com.springboot.catchmind.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.springboot.catchmind.dto.ReviewDto;
import lombok.extern.slf4j.Slf4j;
import com.springboot.catchmind.dto.ShopPhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.catchmind.dao.ShopPhotoDao;
import com.springboot.catchmind.vo.ShopPhotoVo;

@Service("fileService")
@Slf4j
public class FileServiceImpl {
	
	@Autowired
	private ShopServiceImpl shopService;
	@Autowired
	private ShopPhotoDao shopPhotoDao;

	/**
	 * FileSave
	 */
	public void fileSave(ReviewDto reviewDto) throws Exception {
		String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\upload\\";

		if(reviewDto.getReviewfile1().getOriginalFilename() != null && !reviewDto.getReviewfile1().getOriginalFilename().equals("")) {
			File saveFile = new File(projectPath + reviewDto.getReviewsphoto());
			reviewDto.getReviewfile1().transferTo(saveFile);
		}
	}

	/**
	 * FileChecK
	 */
	public Object fileCheck(ReviewDto reviewDto) throws Exception {

		if(reviewDto.getReviewfile1().getOriginalFilename() != null
				&& !reviewDto.getReviewfile1().getOriginalFilename().equals("")) {

			UUID uuid = UUID.randomUUID();
			String reviewphoto = reviewDto.getReviewfile1().getOriginalFilename();
			String reviewsphoto = uuid +"_"+ reviewphoto;

			reviewDto.setReviewphoto(reviewphoto);
			reviewDto.setReviewsphoto(reviewsphoto);

			log.info("reviewVo.getReviewphoto() -> {}", reviewDto.getReviewphoto());
			log.info("reviewVo.getReviewsphoto() -> {}", reviewDto.getReviewsphoto());
		}else {
			System.out.println("No File Upload");
		}

		return reviewDto;
	}

	/**
	 *	multiFileCheck
	 */
	public ShopPhotoDto multiFileCheck(ShopPhotoDto shopPhotoDto) throws Exception {
		for(MultipartFile file : shopPhotoDto.getPhotos()) {
			if(!file.getOriginalFilename().equals("")) {
				UUID uuid = UUID.randomUUID();
				shopPhotoDto.getSphotos().add(file.getOriginalFilename());
				shopPhotoDto.getSUuidPhotos().add(uuid + "_" + file.getOriginalFilename());
			}else {
				shopPhotoDto.getSphotos().add(null);
				shopPhotoDto.getSUuidPhotos().add(null);
			}
		}
		
		if(shopPhotoDto.getPhotos().length == 1) {
			shopPhotoDto.setPhoto1(shopPhotoDto.getSphotos().get(0));
			shopPhotoDto.setSphoto1(shopPhotoDto.getSUuidPhotos().get(0));
		}else if(shopPhotoDto.getPhotos().length == 2) {
			shopPhotoDto.setPhoto1(shopPhotoDto.getSphotos().get(0));
			shopPhotoDto.setSphoto1(shopPhotoDto.getSUuidPhotos().get(0));
			shopPhotoDto.setPhoto2(shopPhotoDto.getSphotos().get(1));
			shopPhotoDto.setSphoto2(shopPhotoDto.getSUuidPhotos().get(1));
		}else if(shopPhotoDto.getPhotos().length == 3) {
			shopPhotoDto.setPhoto1(shopPhotoDto.getSphotos().get(0));
			shopPhotoDto.setSphoto1(shopPhotoDto.getSUuidPhotos().get(0));
			shopPhotoDto.setPhoto2(shopPhotoDto.getSphotos().get(1));
			shopPhotoDto.setSphoto2(shopPhotoDto.getSUuidPhotos().get(1));
			shopPhotoDto.setPhoto3(shopPhotoDto.getSphotos().get(2));
			shopPhotoDto.setSphoto3(shopPhotoDto.getSUuidPhotos().get(2));
		}else if(shopPhotoDto.getPhotos().length == 4) {
			shopPhotoDto.setPhoto1(shopPhotoDto.getSphotos().get(0));
			shopPhotoDto.setSphoto1(shopPhotoDto.getSUuidPhotos().get(0));
			shopPhotoDto.setPhoto2(shopPhotoDto.getSphotos().get(1));
			shopPhotoDto.setSphoto2(shopPhotoDto.getSUuidPhotos().get(1));
			shopPhotoDto.setPhoto3(shopPhotoDto.getSphotos().get(2));
			shopPhotoDto.setSphoto3(shopPhotoDto.getSUuidPhotos().get(2));
			shopPhotoDto.setPhoto4(shopPhotoDto.getSphotos().get(3));
			shopPhotoDto.setSphoto4(shopPhotoDto.getSUuidPhotos().get(3));
		}else if(shopPhotoDto.getPhotos().length == 5) {
			shopPhotoDto.setPhoto1(shopPhotoDto.getSphotos().get(0));
			shopPhotoDto.setSphoto1(shopPhotoDto.getSUuidPhotos().get(0));
			shopPhotoDto.setPhoto2(shopPhotoDto.getSphotos().get(1));
			shopPhotoDto.setSphoto2(shopPhotoDto.getSUuidPhotos().get(1));
			shopPhotoDto.setPhoto3(shopPhotoDto.getSphotos().get(2));
			shopPhotoDto.setSphoto3(shopPhotoDto.getSUuidPhotos().get(2));
			shopPhotoDto.setPhoto4(shopPhotoDto.getSphotos().get(3));
			shopPhotoDto.setSphoto4(shopPhotoDto.getSUuidPhotos().get(3));
			shopPhotoDto.setPhoto5(shopPhotoDto.getSphotos().get(4));
			shopPhotoDto.setSphoto5(shopPhotoDto.getSUuidPhotos().get(4));
		}
		return shopPhotoDto;
	}

	public ShopPhotoDto multiFileUpdateCheck(ShopPhotoDto shopPhotoDto,HashMap<String, Integer> map) throws Exception {
		for(MultipartFile file : shopPhotoDto.getPhotos()) {
			if(!file.getOriginalFilename().equals("")) {
				UUID uuid = UUID.randomUUID();
				shopPhotoDto.getSphotos().add(file.getOriginalFilename());
				shopPhotoDto.getSUuidPhotos().add(uuid + "_" + file.getOriginalFilename());
			}else {
				shopPhotoDto.getSphotos().add(null);
				shopPhotoDto.getSUuidPhotos().add(null);
			}
		}
		
		int count = 0;
		if(map.get("file1") == 1) {
			shopPhotoDto.setPhoto1(shopPhotoDto.getSphotos().get(count));
			shopPhotoDto.setSphoto1(shopPhotoDto.getSUuidPhotos().get(count));
			count++;
		}
		if(map.get("file2") == 1) {
			shopPhotoDto.setPhoto2(shopPhotoDto.getSphotos().get(count));
			shopPhotoDto.setSphoto2(shopPhotoDto.getSUuidPhotos().get(count));
			count++;
		}
		if(map.get("file3") == 1) {
			shopPhotoDto.setPhoto3(shopPhotoDto.getSphotos().get(count));
			shopPhotoDto.setSphoto3(shopPhotoDto.getSUuidPhotos().get(count));
			count++;
		}
		if(map.get("file4") == 1) {
			shopPhotoDto.setPhoto4(shopPhotoDto.getSphotos().get(count));
			shopPhotoDto.setSphoto4(shopPhotoDto.getSUuidPhotos().get(count));
			count++;
		}
		if(map.get("file5") == 1) {
			shopPhotoDto.setPhoto5(shopPhotoDto.getSphotos().get(count));
			shopPhotoDto.setSphoto5(shopPhotoDto.getSUuidPhotos().get(count));
			count++;
		}
		return shopPhotoDto;
	}

	public void multiFilesave(ShopPhotoDto shopPhotoDto, HttpServletRequest request) throws Exception {
		//String root_path = request.getSession().getServletContext().getRealPath("/");
		//String attach_path = "\\resources\\upload\\";
		//String attach_path = "\\upload\\";
		
		int count = 0;
		for(MultipartFile file : shopPhotoDto.getPhotos()) {
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
				//File saveFile = new File(root_path + attach_path + shopPhotoDto.getSUuidPhotos().get(count));
				File saveFile = new File(shopPhotoDto.getSUuidPhotos().get(count));
				file.transferTo(saveFile);
			}
			count++;
		}
	}

	public void multiFileDelete(String sid, HashMap<String, Integer> map, HttpServletRequest request) {
		//String root_path = request.getSession().getServletContext().getRealPath("/");
		//String attach_path = "\\resources\\upload\\";
		//String attach_path = "\\upload\\";
		
		ShopPhotoDto shopPhotoVo = shopService.getShopPhotoSelect(sid);
		Map<String, String> mapDelete = new HashMap<String, String>();
		
		if(map.get("file1") == 1) {
			mapDelete.put("file1", shopPhotoVo.getSphoto1());
		}
		if(map.get("file2") == 1) {
			mapDelete.put("file2", shopPhotoVo.getSphoto2());
		}
		if(map.get("file3") == 1) {
			mapDelete.put("file3", shopPhotoVo.getSphoto3());
		}
		if(map.get("file4") == 1) {
			mapDelete.put("file4", shopPhotoVo.getSphoto4());
		}
		if(map.get("file5") == 1) {
			mapDelete.put("file5", shopPhotoVo.getSphoto5());
		}
		
		for (Map.Entry<String, String> entry : mapDelete.entrySet()) {
		    String fileName = entry.getValue();
		    //String imgPath = root_path + attach_path + fileName;
			String imgPath = fileName;
		    File file = new File(imgPath);
		    
		    if(file.exists()) {
		    	try {
		    		if(file.delete()) {
		    			System.out.println("File deleted successfully.");
		    		} else {
		    			System.out.println("Failed to delete the file.");
		    		}
		    	}catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }else {
		        System.out.println("File does not exist.");
		    }
		}
	}
}
