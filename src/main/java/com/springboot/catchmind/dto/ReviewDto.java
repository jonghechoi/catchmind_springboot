package com.springboot.catchmind.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class ReviewDto {
	private String reviewid, reviewcontent, reviewcreatedate, reviewmodifydate, sid, mid, rid, reviewphoto, reviewsphoto, sname, mname;
	private double reviewstar, tasteStar, moodStar, serviceStar;

	private int rno;

	private MultipartFile reviewfile1;

    public void setReviewId(Long reviewId) {
    }


//    public Long getReviewId() {
//        return null;
//    }
}
