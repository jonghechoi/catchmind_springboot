package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

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

	List<ReviewDto> selectBy(String mid);

	//0807 일에 추가 한 코드
    int updateReview(ReviewDto updatedReviewDto);
}