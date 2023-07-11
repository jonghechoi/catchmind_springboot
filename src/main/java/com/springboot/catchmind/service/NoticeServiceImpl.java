package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.NoticeDao;
import com.springboot.catchmind.vo.NoticeVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service("noticeService")
public class NoticeServiceImpl {

/*	@Autowired
	private PagingServiceImpl pagingService;*/
	@Autowired
	private NoticeDao noticeDao;
	
	public int getTotalRowCount() {	return noticeDao.totalRowCount(); };
	
	public ArrayList<NoticeVo> getNoticeSelect(Map<String, Integer> param) {
		ArrayList<NoticeVo> list = noticeDao.select(param.get("startCount"), param.get("endCount"));

//		JsonObject jlist = new JsonObject();
//		JsonArray jarray = new JsonArray();
//
//		for(NoticeVo noticeVo : list) {
//			JsonObject jobj = new JsonObject();
//			jobj.addProperty("rno", noticeVo.getRno());
//			jobj.addProperty("ntitle", noticeVo.getNtitle());
//			jobj.addProperty("nhits", noticeVo.getNhits());
//			jobj.addProperty("ncreatedate", noticeVo.getNcreatedate());
//			jobj.addProperty("nid", noticeVo.getNid());
//
//			jarray.add(jobj);
//		}
//
//		jlist.add("jlist", jarray);
//		jlist.addProperty("totals", param.get("dbCount"));
//		jlist.addProperty("maxSize", param.get("maxSize"));
//		jlist.addProperty("pageSize", param.get("pageSize"));
//		jlist.addProperty("page", param.get("page"));

		return list;
	}
	
	public int getNoticeUpload(NoticeVo noticeVo) {	return noticeDao.upload(noticeVo); }
}
