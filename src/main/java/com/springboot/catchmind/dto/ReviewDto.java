package com.springboot.catchmind.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class ReviewDto {
	private String reviewid, reviewcontent, reviewcreatedate, reviewmodifydate, sid, mid, rid, reviewphoto, reviewsphoto, sname, mname;
	private double reviewstar, tasteStar, moodStar, serviceStar;

	private int rno;

	private MultipartFile reviewfile1;

	public void setWriteReviewstar(ReviewDto reviewDto) {
		this.reviewstar = Math.round((reviewDto.getTasteStar() + reviewDto.getMoodStar() + reviewDto.getServiceStar()) / 3.0 * 10) / 10.0;
	}
}
