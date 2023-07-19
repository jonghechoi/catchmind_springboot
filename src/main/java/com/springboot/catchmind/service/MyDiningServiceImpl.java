package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.dto.ScheduledDto;
import com.springboot.catchmind.repository.MyDiningMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyDiningServiceImpl{

	@Autowired
	private MyDiningMapper myDiningMapper;

	public ArrayList<ScheduledDto> getScheduled(String mid) {
		return myDiningMapper.scheduled(mid);
	}

	public ScheduledDto getInformation(String mid, String sid, String rid) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("mid", mid);
		param.put("sid", sid);
		param.put("rid", rid);

		ScheduledDto scheduledDto = myDiningMapper.information(param);

		int check = myDiningMapper.fcount(param);

		if(check == 0) {
			scheduledDto.setFcheck(String.valueOf('N'));
		}else {
			scheduledDto.setFcheck(String.valueOf('Y'));
		}

		return scheduledDto;
	}

	public void getUpdateStatus() {
		myDiningMapper.updateStatus();
	}

	public int getTotalRowCount(PageDto pageDto) {
		return myDiningMapper.totalRowCount(pageDto);
	}

	public int getUpdateCancelNoshow(String rid, String rdate) {
		LocalDate currentDate = LocalDate.now();
		String sysdate = currentDate.format(DateTimeFormatter.ISO_DATE);

		if(rdate.equals(sysdate)) {
			return myDiningMapper.updateNoshow(rid);

		}else{
			return myDiningMapper.updateCancel(rid);
		}
	}


	public ArrayList<ScheduledDto> getCancelNoshow(PageDto pageDto) {
		return myDiningMapper.cancelNoshow(pageDto);
	}

	public ArrayList<ScheduledDto> getVisitedSelect(PageDto pageDto) {
		return myDiningMapper.visitedSelect(pageDto);
	}

	public int getUpdateDeleteYN(String rid) {
		return myDiningMapper.updateDeleteYN(rid);
	}

	public int getBookmarkResult(String mid, String sid) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("mid", mid);
		param.put("sid", sid);
		return myDiningMapper.bookmarkResult(param);
	}

	public int getDeleteBookmark(String mid, String sid) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("mid", mid);
		param.put("sid", sid);
		return myDiningMapper.deleteBookmark(param);
	}

	public int getInsertBookmark(String mid, String sid) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("mid", mid);
		param.put("sid", sid);
		return myDiningMapper.insertBookmark(param);
	}
}
