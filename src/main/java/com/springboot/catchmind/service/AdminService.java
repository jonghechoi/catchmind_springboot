package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.List;

import com.springboot.catchmind.dto.*;
import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.NoticeVo;
import com.springboot.catchmind.vo.ReviewVo;

public interface AdminService {
	
	public List<NoticeDto> getNoticeSelectJson(PageDto pageDto);

	public MemberDto getCertainMemberSelect(String mid);
	public List<MemberDto> getMemberSelectJson(PageDto pageDto);
	
	public NoticeDto getNoticeSelect(String nid);
	
	public int getNoticeUpdate(NoticeDto noticeDto);
	
	public int getNoticeDelete(String nid);

	public int getNoticeUpload(NoticeDto noticeDto);
	
	public List<ShopDto> getShopSelectJson(boolean sconfirm, boolean aconfirmfinal);
	
	public int getConfirmUpdate(String sid);
	
	public int getCancelUpdate(String sid);
	
	public List<ReviewDto> getReviewSelectJson(PageDto pageDto);
	
	public ReviewDto getReviewDetailSelectJson(String rid);
	
	public int getReviewMainUpdate(String rid);
	
	public List<ReviewDto> getReviewMainList();
	
	public int getReviewMainDelete(String rid);
}
