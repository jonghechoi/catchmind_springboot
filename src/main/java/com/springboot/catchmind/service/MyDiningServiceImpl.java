package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.MyDiningDao;
import com.springboot.catchmind.vo.ScheduledVo;

@Service("myDiningService")
public class MyDiningServiceImpl implements MyDiningService {
	
	@Autowired
	private MyDiningDao myDiningDao;
	
	@Override
	public ArrayList<ScheduledVo> getScheduled(String mid) {
		return myDiningDao.scheduled(mid);
	}
	
	@Override
	public ScheduledVo getInformation(String mid, String sid, String rid) {
		return myDiningDao.information(mid, sid, rid);
	}
	
	@Override
	public ArrayList<ScheduledVo> getVisited(String mid) {
		return myDiningDao.visited(mid);
	}
	
	@Override
	public void getUpdateStatus() {
		myDiningDao.updateStatus();
	}
	
	@Override
	public int getTotalRowCount(String mid) {
		return myDiningDao.totalRowCount(mid);
	}
	
	@Override
	public ArrayList<ScheduledVo> getVisitedSelect(Map<String, String> param) {
		return myDiningDao.visitedSelect(param);
	}
	
	@Override
	public int getUpdateDeleteYN(String rid) {
		return myDiningDao.updateDeleteYN(rid);
	}
	
	@Override
	public int getBookmarkResult(String mid, String sid) {
		return myDiningDao.bookmarkResult(mid, sid);
	}
	
	@Override
	public int getDeleteBookmark(String mid, String sid) {
		return myDiningDao.deleteBookmark(mid, sid);
	}
	
	@Override
	public int getInsertBookmark(String mid, String sid) {
		return myDiningDao.insertBookmark(mid, sid);
	}
}
