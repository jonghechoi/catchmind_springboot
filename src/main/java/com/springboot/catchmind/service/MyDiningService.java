package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.Map;

import com.springboot.catchmind.vo.ScheduledVo;

public interface MyDiningService {
	void getUpdateStatus();
	
	ArrayList<ScheduledVo> getVisited(String mid);
	
	ScheduledVo getInformation(String mid, String sid, String rid);
	
	ArrayList<ScheduledVo> getScheduled(String mid);
	
	int getTotalRowCount(String mid);
	
	ArrayList<ScheduledVo> getVisitedSelect(Map<String,String> param);
	
	int getUpdateDeleteYN(String rid);
	
	int getBookmarkResult(String mid, String sid);
	
	int getDeleteBookmark(String mid, String sid);
	
	int getInsertBookmark(String mid, String sid);
}
