package com.springboot.catchmind.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.springboot.catchmind.vo.ReviewVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
	public void fileSave(ReviewVo reviewVo) throws Exception {
		String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\upload\\";

		if(reviewVo.getReviewfile1().getOriginalFilename() != null && !reviewVo.getReviewfile1().getOriginalFilename().equals("")) {
			File saveFile = new File(projectPath + reviewVo.getReviewsphoto());
			reviewVo.getReviewfile1().transferTo(saveFile);
		}
	}


	/**
	 * FileChecK
	 */
	public Object fileCheck(ReviewVo reviewVo) throws Exception {

		if(reviewVo.getReviewfile1().getOriginalFilename() != null
				&& !reviewVo.getReviewfile1().getOriginalFilename().equals("")) {

			UUID uuid = UUID.randomUUID();
			String reviewphoto = reviewVo.getReviewfile1().getOriginalFilename();
			String reviewsphoto = uuid +"_"+ reviewphoto;

			reviewVo.setReviewphoto(reviewphoto);
			reviewVo.setReviewsphoto(reviewsphoto);

			log.info("reviewVo.getReviewphoto() -> {}", reviewVo.getReviewphoto());
			log.info("reviewVo.getReviewsphoto() -> {}", reviewVo.getReviewsphoto());
		}else {
			System.out.println("No File Upload");
		}

		return reviewVo;
	}


	/**
	 *	multiFileCheck - ��Ƽ���� üũ ���
	 */
	public ShopPhotoVo multiFileCheck(ShopPhotoVo shopPhotoVo) throws Exception {
		for(CommonsMultipartFile file : shopPhotoVo.getPhotos()) {
			if(!file.getOriginalFilename().equals("")) {
				UUID uuid = UUID.randomUUID();
				shopPhotoVo.getSphotos().add(file.getOriginalFilename());
				shopPhotoVo.getsUuidPhotos().add(uuid + "_" + file.getOriginalFilename()); // ���� ������ ����Ǵ� ���� �̸�
			}else {
				// ���⼭ null�� ���� mybatis���� jdbcType='VARCHAR'�� �����������
				// �ᱹ ��� ó�����ִ��� ������
				shopPhotoVo.getSphotos().add(null);
				shopPhotoVo.getsUuidPhotos().add(null);
			}
		}
		
		// ArrayList�� ����� photo1~5, sphoto1~5 ���ϵ��� �̸��� Vo�� ������ �ʵ忡 ����
		if(shopPhotoVo.getPhotos().length == 1) {
			shopPhotoVo.setPhoto1(shopPhotoVo.getSphotos().get(0));
			shopPhotoVo.setSphoto1(shopPhotoVo.getsUuidPhotos().get(0));
		}else if(shopPhotoVo.getPhotos().length == 2) {
			shopPhotoVo.setPhoto1(shopPhotoVo.getSphotos().get(0));
			shopPhotoVo.setSphoto1(shopPhotoVo.getsUuidPhotos().get(0));		
			shopPhotoVo.setPhoto2(shopPhotoVo.getSphotos().get(1));
			shopPhotoVo.setSphoto2(shopPhotoVo.getsUuidPhotos().get(1));			
		}else if(shopPhotoVo.getPhotos().length == 3) {
			shopPhotoVo.setPhoto1(shopPhotoVo.getSphotos().get(0));
			shopPhotoVo.setSphoto1(shopPhotoVo.getsUuidPhotos().get(0));		
			shopPhotoVo.setPhoto2(shopPhotoVo.getSphotos().get(1));
			shopPhotoVo.setSphoto2(shopPhotoVo.getsUuidPhotos().get(1));
			shopPhotoVo.setPhoto3(shopPhotoVo.getSphotos().get(2));
			shopPhotoVo.setSphoto3(shopPhotoVo.getsUuidPhotos().get(2));
		}else if(shopPhotoVo.getPhotos().length == 4) {
			shopPhotoVo.setPhoto1(shopPhotoVo.getSphotos().get(0));
			shopPhotoVo.setSphoto1(shopPhotoVo.getsUuidPhotos().get(0));		
			shopPhotoVo.setPhoto2(shopPhotoVo.getSphotos().get(1));
			shopPhotoVo.setSphoto2(shopPhotoVo.getsUuidPhotos().get(1));
			shopPhotoVo.setPhoto3(shopPhotoVo.getSphotos().get(2));
			shopPhotoVo.setSphoto3(shopPhotoVo.getsUuidPhotos().get(2));
			shopPhotoVo.setPhoto4(shopPhotoVo.getSphotos().get(3));
			shopPhotoVo.setSphoto4(shopPhotoVo.getsUuidPhotos().get(3));			
		}else if(shopPhotoVo.getPhotos().length == 5) {
			shopPhotoVo.setPhoto1(shopPhotoVo.getSphotos().get(0));
			shopPhotoVo.setSphoto1(shopPhotoVo.getsUuidPhotos().get(0));		
			shopPhotoVo.setPhoto2(shopPhotoVo.getSphotos().get(1));
			shopPhotoVo.setSphoto2(shopPhotoVo.getsUuidPhotos().get(1));
			shopPhotoVo.setPhoto3(shopPhotoVo.getSphotos().get(2));
			shopPhotoVo.setSphoto3(shopPhotoVo.getsUuidPhotos().get(2));
			shopPhotoVo.setPhoto4(shopPhotoVo.getSphotos().get(3));
			shopPhotoVo.setSphoto4(shopPhotoVo.getsUuidPhotos().get(3));
			shopPhotoVo.setPhoto5(shopPhotoVo.getSphotos().get(4));
			shopPhotoVo.setSphoto5(shopPhotoVo.getsUuidPhotos().get(4));			
		}
		return shopPhotoVo;
	}
	
	/**
	 *	multiFileUpdateCheck - ��Ƽ���� üũ ���
	 */
	public ShopPhotoVo multiFileUpdateCheck(ShopPhotoVo shopPhotoVo,HashMap<String, Integer> map) throws Exception {
		for(CommonsMultipartFile file : shopPhotoVo.getPhotos()) {
			if(!file.getOriginalFilename().equals("")) {
				UUID uuid = UUID.randomUUID();
				shopPhotoVo.getSphotos().add(file.getOriginalFilename());
				shopPhotoVo.getsUuidPhotos().add(uuid + "_" + file.getOriginalFilename()); // ���� ������ ����Ǵ� ���� �̸�
			}else {
				shopPhotoVo.getSphotos().add(null);
				shopPhotoVo.getsUuidPhotos().add(null);
			}
		}
		
		// update�� �ʿ��� �����鸸 ����
		int count = 0;
		if(map.get("file1") == 1) {
			shopPhotoVo.setPhoto1(shopPhotoVo.getSphotos().get(count));
			shopPhotoVo.setSphoto1(shopPhotoVo.getsUuidPhotos().get(count));
			count++;
		}
		if(map.get("file2") == 1) {
			shopPhotoVo.setPhoto2(shopPhotoVo.getSphotos().get(count));
			shopPhotoVo.setSphoto2(shopPhotoVo.getsUuidPhotos().get(count));
			count++;
		}
		if(map.get("file3") == 1) {
			shopPhotoVo.setPhoto3(shopPhotoVo.getSphotos().get(count));
			shopPhotoVo.setSphoto3(shopPhotoVo.getsUuidPhotos().get(count));
			count++;
		}
		if(map.get("file4") == 1) {
			shopPhotoVo.setPhoto4(shopPhotoVo.getSphotos().get(count));
			shopPhotoVo.setSphoto4(shopPhotoVo.getsUuidPhotos().get(count));
			count++;
		}
		if(map.get("file5") == 1) {
			shopPhotoVo.setPhoto5(shopPhotoVo.getSphotos().get(count));
			shopPhotoVo.setSphoto5(shopPhotoVo.getsUuidPhotos().get(count));
			count++;
		}
		return shopPhotoVo;
	}
	
	/**
	 *	multiFileSave - ��Ƽ���� ���� ���
	 */
	public void multiFilesave(ShopPhotoVo shopPhotoVo, HttpServletRequest request) throws Exception {
		String root_path = request.getSession().getServletContext().getRealPath("/"); 
		String attach_path = "\\resources\\upload\\";
		
		// ������ �����ϸ� ������ ����
		int count = 0;
		for(CommonsMultipartFile file : shopPhotoVo.getPhotos()) {
			if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
				File saveFile = new File(root_path + attach_path + shopPhotoVo.getsUuidPhotos().get(count));
				file.transferTo(saveFile); 
			}
			count++;
		}
	}
	
	/**
	 *	multiFileDelete - ��Ƽ ���� ���� ���
	 */
	public void multiFileDelete(String sid, HashMap<String, Integer> map, HttpServletRequest request) {
		String root_path = request.getSession().getServletContext().getRealPath("/"); 
		String attach_path = "\\resources\\upload\\";	
		
		// ������Ʈ �Ǹ鼭 ��������� �̹��� ���� ����
		ShopPhotoVo shopPhotoVo = shopService.getShopPhotoSelect(sid);
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
		    String imgPath = root_path + attach_path + fileName;
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
