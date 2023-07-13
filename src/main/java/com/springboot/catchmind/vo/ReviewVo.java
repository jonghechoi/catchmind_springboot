package com.springboot.catchmind.vo;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVo {
	String reviewid, reviewcontent, reviewcreatedate, reviewmodifydate, sid, mid, rid, 
		reviewphoto, reviewsphoto, sname, mname;
	double reviewstar, tasteStar, moodStar, serviceStar;

	int rno;

	MultipartFile reviewfile1;

	public String getReviewid() {
		return reviewid;
	}

	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}

	public String getReviewcontent() {
		return reviewcontent;
	}

	public void setReviewcontent(String reviewcontent) {
		this.reviewcontent = reviewcontent;
	}

	public String getReviewcreatedate() {
		return reviewcreatedate;
	}

	public void setReviewcreatedate(String reviewcreatedate) {
		this.reviewcreatedate = reviewcreatedate;
	}

	public String getReviewmodifydate() {
		return reviewmodifydate;
	}

	public void setReviewmodifydate(String reviewmodifydate) {
		this.reviewmodifydate = reviewmodifydate;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getReviewphoto() {
		return reviewphoto;
	}

	public void setReviewphoto(String reviewphoto) {
		this.reviewphoto = reviewphoto;
	}

	public String getReviewsphoto() {
		return reviewsphoto;
	}

	public void setReviewsphoto(String reviewsphoto) {
		this.reviewsphoto = reviewsphoto;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public double getReviewstar() {
		return reviewstar;
	}

	public void setReviewstar(double reviewstar) {
		this.reviewstar = reviewstar;
	}

	public double getTasteStar() {
		return tasteStar;
	}

	public void setTasteStar(double tasteStar) {
		this.tasteStar = tasteStar;
	}

	public double getMoodStar() {
		return moodStar;
	}

	public void setMoodStar(double moodStar) {
		this.moodStar = moodStar;
	}

	public double getServiceStar() {
		return serviceStar;
	}

	public void setServiceStar(double serviceStar) {
		this.serviceStar = serviceStar;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public MultipartFile getReviewfile1() {
		return reviewfile1;
	}

	public void setReviewfile1(MultipartFile reviewfile1) {
		this.reviewfile1 = reviewfile1;
	}

	
	
}
