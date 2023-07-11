package com.springboot.catchmind.vo;

import java.util.ArrayList;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ShopPhotoVo {
	String sid, photo1, photo2, photo3, photo4, photo5,
		   sphoto1, sphoto2, sphoto3, sphoto4, sphoto5;
    
	CommonsMultipartFile[] photos;
    
	ArrayList<String> sphotos = new ArrayList<String>();
	ArrayList<String> sUuidPhotos = new ArrayList<String>();

	
	public String getSphoto1() {
		return sphoto1;
	}

	public CommonsMultipartFile[] getPhotos() {
		return photos;
	}

	public void setPhotos(CommonsMultipartFile[] photos) {
		this.photos = photos;
	}

	public ArrayList<String> getSphotos() {
		return sphotos;
	}

	public void setSphotos(ArrayList<String> sphotos) {
		this.sphotos = sphotos;
	}

	public ArrayList<String> getsUuidPhotos() {
		return sUuidPhotos;
	}

	public void setsUuidPhotos(ArrayList<String> sUuidPhotos) {
		this.sUuidPhotos = sUuidPhotos;
	}

	public void setSphoto1(String sphoto1) {
		this.sphoto1 = sphoto1;
	}

	public String getSphoto2() {
		return sphoto2;
	}

	public void setSphoto2(String sphoto2) {
		this.sphoto2 = sphoto2;
	}

	public String getSphoto3() {
		return sphoto3;
	}

	public void setSphoto3(String sphoto3) {
		this.sphoto3 = sphoto3;
	}

	public String getSphoto4() {
		return sphoto4;
	}

	public void setSphoto4(String sphoto4) {
		this.sphoto4 = sphoto4;
	}

	public String getSphoto5() {
		return sphoto5;
	}

	public void setSphoto5(String sphoto5) {
		this.sphoto5 = sphoto5;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public String getPhoto4() {
		return photo4;
	}

	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}

	public String getPhoto5() {
		return photo5;
	}

	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}
}
