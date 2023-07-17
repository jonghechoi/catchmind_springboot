package com.springboot.catchmind.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;

@Data
public class ShopPhotoDto {
	String sid, photo1, photo2, photo3, photo4, photo5,
		   sphoto1, sphoto2, sphoto3, sphoto4, sphoto5;
    
	MultipartFile[] photos;
    
	ArrayList<String> sphotos = new ArrayList<String>();
	ArrayList<String> sUuidPhotos = new ArrayList<String>();
}
