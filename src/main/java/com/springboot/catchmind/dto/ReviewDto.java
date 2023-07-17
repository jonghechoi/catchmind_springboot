package com.springboot.catchmind.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReviewDto {
    String reviewid, reviewcontent, reviewcreatedate, reviewmodifydate, sid, mid, rid, reviewphoto, reviewsphoto, sname, mname;
    double reviewstar, tasteStar, moodStar, serviceStar;
    int rno;
    MultipartFile reviewfile1;
}
