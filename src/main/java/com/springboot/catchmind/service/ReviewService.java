package com.springboot.catchmind.service;

import java.util.ArrayList;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.vo.ReviewVo;

public interface ReviewService {

//	int getInsert(ReviewVo reviewVo);
//	ArrayList<ReviewVo> getSelect(int startCount, int endCount);
//	ReviewVo getSelect(String bid);
//	int getUpdate(ReviewVo reviewVo);
//	int getDelete(String bid);
//	void getUpdateHits(String bid);
	int getTotalRowCount();
	int getUpdateReviewYN(String rid);
	int getWriteReview(ReviewVo reviewVo);
	ReviewVo getReviewSelect(String rid);
	ReviewDto Select(String mid);
}

