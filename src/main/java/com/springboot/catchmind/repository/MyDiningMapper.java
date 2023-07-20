package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.dto.ScheduledDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface MyDiningMapper {

	/**
	 * deleteBookmark
	 */
	int deleteBookmark(Map<String, String> param);

	/**
	 * insertBookmark
	 */
	int insertBookmark(Map<String, String> param);

	/**
	 * informationBookmark
	 */
	int bookmarkResult(Map<String, String> param);

	/**
	 * UpdateDeleteYN
	 */
	int updateDeleteYN(String rid);

	/**
	 * visitedTotalRowCount
	 */
	int totalRowCount(PageDto pageDto);

 	/**
	 * RSTATUS ACTIVED -> COMPLETED
	 */
	void updateStatus();

	/* Cancel Reservation : RSTATUS -> NOSHOW */
	int updateNoshow(String rid);

	/* Cancel Reservation : RSTATUS -> CANCEL */
	int updateCancel(String rid);

	/**
	 * mydining_cancel_noshow - paging
	 */
	ArrayList<ScheduledDto> cancelNoshow(PageDto pageDto);

	/**
	 * mydining_visited - paging
	 */
	ArrayList<ScheduledDto> visitedSelect(PageDto pageDto);

	/**
	 * information.do
	 */
	ScheduledDto information(Map<String, String> param);

	/* information - favorites Check */
	int fcount(Map<String, String> param);

	/**
	 * mydining_scheduled
	 */
	ArrayList<ScheduledDto> scheduled(String mid);
}
