
package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.repository.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl {
	@Autowired
	private ReviewMapper reviewMapper;


	//start Dayoung
	public int getStarAvg(String sid) {
		return reviewMapper.getStarAvg(sid);
	}

	public int getTotalReviewCount(String sid) {
		return reviewMapper.getTotalReviewCount(sid);
	}

	public int getTotalReviewPhotoCount(String sid) {
		return reviewMapper.getTotalReviewPhotoCount(sid);
	}

	public ArrayList<ReviewDto> reviewListSelect(String sid) {
		return reviewMapper.reviewListSelect(sid);
	}
	//end Dayoung


	public ReviewDto getReviewSelect(String rid) {
		return reviewMapper.reviewSelect(rid);
	}

	public int getWriteReview(ReviewDto reviewDto) {
		return reviewMapper.writeReview(reviewDto);
	}

	public int getUpdateReviewYN(String rid) {
		return reviewMapper.updateReviewYN(rid);
	}

	public List<ReviewDto> SelectBy(String mid) {
		return reviewMapper.selectBy(mid);
	}



	//0807 일에 추가 한 코드
//	public int updateReview(String setReviewId, String setReviewContent, int setReviewStar) {
//		ReviewDto Review = new ReviewDto();
//		return reviewMapper.updateReview();
//	}
//
//	public void updateReview(Long reviewId, ReviewDto updatedReviewDto) {
//	}
//
//	public ReviewDto getReviewById(Long reviewId) {
//
//		return null;
//	}


	public void updateReview(Long reviewId, ReviewDto updatedReviewDto) {
		reviewMapper.updateReview(updatedReviewDto);
	}


	public ReviewDto getReviewById(Long reviewId) {
		return reviewMapper.select(String.valueOf(reviewId)); // 리뷰를 가져오는 메서드를 사용자의 실제 구현에 맞게 호출합니다.
	}


}
