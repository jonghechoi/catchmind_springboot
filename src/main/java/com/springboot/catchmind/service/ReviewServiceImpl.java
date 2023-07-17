
package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.repository.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReviewServiceImpl{
	@Autowired
	private ReviewMapper reviewMapper;

	public ReviewDto getReviewSelect(String rid) {
		return reviewMapper.reviewSelect(rid);
	}

	public int getWriteReview(ReviewDto reviewDto) {
		return reviewMapper.writeReview(reviewDto);
	}

	public int getUpdateReviewYN(String rid) {
		return reviewMapper.updateReviewYN(rid);
	}
}
