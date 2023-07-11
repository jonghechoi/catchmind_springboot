package com.springboot.catchmind.service;

import java.util.ArrayList;

import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.NoticeVo;
import com.springboot.catchmind.vo.ReviewVo;

public interface AdminService {
	
	public String getNoticeSelectGson(String page);

	public MemberVo getCertainMemberSelect(String mid);
	public String getMemberSelectGson(String page);
	
	public NoticeVo getNoticeSelect(String nid);
	
	public int getNoticeUpdate(NoticeVo noticeVo);
	
	public int getNoticeDelete(String nid);
	
	public String getShopSelectGson(boolean sconfirm, boolean aconfirmfinal);
	
	public int getConfirmUpdate(String sid);
	
	public int getCancelUpdate(String sid);
	
	public String getReviewSelectGson(String page);
	
	public String getReviewDetailSelectGson(String rid);
	
	public int getReviewMainUpdate(String rid);
	
	public ArrayList<ReviewVo> getReviewMainList();
	
	public int getReviewMainDelete(String rid);
}
