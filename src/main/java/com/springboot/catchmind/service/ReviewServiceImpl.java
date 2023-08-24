
package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.repository.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReviewServiceImpl{
	@Autowired
	private ReviewMapper reviewMapper;

	//start Dayoung
	public int getStarAvg(String sid){
		return reviewMapper.getStarAvg(sid);
	}

	public int getTotalReviewCount(String sid){
		return reviewMapper.getTotalReviewCount(sid);
	}

	public int getTotalReviewPhotoCount(String sid){
		return reviewMapper.getTotalReviewPhotoCount(sid);
	}

	public ArrayList<ReviewDto> reviewListSelect(String sid){
		return reviewMapper.reviewListSelect(sid);
	}
	//end Dayoung


	public ReviewDto getReviewSelect(String rid) {
		return reviewMapper.reviewSelect(rid);
	}

	public int getWriteReview(ReviewDto reviewDto) {
		reviewDto.setReviewstar(reviewDto);
		return reviewMapper.writeReview(reviewDto);
	}

	public int getUpdateReviewYN(String rid) {
		return reviewMapper.updateReviewYN(rid);
	}

	public int getTotalRowCount() { return reviewMapper.totalRowCount(); }
}
