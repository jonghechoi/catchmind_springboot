package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper{
	//start Dayoung
	int getStarAvg(String sid);
	int getTotalReviewCount(String sid);
	int getTotalReviewPhotoCount(String sid);
	ArrayList<ReviewDto> reviewListSelect(String sid);
	//end Dayoung

	 /* REVIEWYN : N -> Y */
	int updateReviewYN(String rid);

	 /* write_review(insert) */
	int writeReview(ReviewDto reviewDto);

	 /* write_review form Data */
	ReviewDto reviewSelect(String rid);

    List<ReviewDto> selectList(PageDto pageDto);

    ReviewDto select(String rid);

    int updateToMain(String rid);

    List<ReviewDto> reviewMainList();

    int deleteFromMain(String rid);

	int totalRowCount();
}