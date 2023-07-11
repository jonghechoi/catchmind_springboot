
package com.springboot.catchmind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.ReviewDao;
import com.springboot.catchmind.vo.ReviewVo;
@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public ReviewVo getReviewSelect(String rid) {
		return reviewDao.reviewSelect(rid);
	}
	
	@Override
	public int getWriteReview(ReviewVo reviewVo) {
		return reviewDao.writeReview(reviewVo);
	}
	
	@Override
	public int getUpdateReviewYN(String rid) {
		return reviewDao.updateReviewYN(rid);
	}
	
	@Override
	public int getTotalRowCount() {
		return reviewDao.totalRowCount();
	}
}
