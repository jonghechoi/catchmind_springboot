package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.ReviewDao;
import com.springboot.catchmind.vo.ReviewVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service("reviewSchedulerService")
public class Scheduler {
	
	@Autowired
	private ReviewDao reviewDao;
	
	public String reviewMainChange() {
		ArrayList<ReviewVo> list = reviewDao.reviewMainList();

		Collections.shuffle(list);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();			
		
		int count = 0;
		for(ReviewVo reviewVo : list) {
			if(count == 4) { break; };

			JsonObject jobj = new JsonObject();
			jobj.addProperty("reviewphoto", reviewVo.getReviewphoto());
			jobj.addProperty("reviewcontent", reviewVo.getReviewcontent());
			jobj.addProperty("mname", reviewVo.getMname());
			jobj.addProperty("reviewstar", reviewVo.getReviewstar());
			
			jarray.add(jobj);
			
			count++;
		}
		jlist.add("jlist", jarray);
		return new Gson().toJson(jlist);
	}
}
