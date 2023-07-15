package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springboot.catchmind.dto.*;
import com.springboot.catchmind.repository.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.AdminDao;
import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.dao.NoticeDao;
import com.springboot.catchmind.dao.ReviewDao;
import com.springboot.catchmind.dao.ShopDao;
import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.NoticeVo;
import com.springboot.catchmind.vo.ReviewVo;
import com.springboot.catchmind.vo.ShopVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service("adminService")
@MapperScan(basePackages = "com.springboot.catchmind.repository")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private PagingServiceImpl pagingService;
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private ShopMapper shopMapper;
	@Autowired
	private AdminMapper adminMapper;

	/**
	 *	Admin paging - Member, Notice, Review
	 */
	@Override
	public List<MemberDto> getMemberSelectJson(PageDto pageDto) {
		return memberMapper.selectList(pagingService.getPageResult(pageDto));
	}
	@Override
	public List<NoticeDto> getNoticeSelectJson(PageDto pageDto) {
		return noticeMapper.selectList(pagingService.getPageResult(pageDto));
	}
	@Override
	public List<ReviewDto> getReviewSelectJson(PageDto pageDto) {
		return reviewMapper.selectList(pagingService.getPageResult(pageDto));
	}

	/**
	 *	Member
	 */
	@Override
	public MemberDto getCertainMemberSelect(String mid) {
		return memberMapper.select(mid);
	}

	/**
	 *	Notice
	 */
	@Override
	public NoticeDto getNoticeSelect(String nid) {
		return noticeMapper.select(nid);
	}
	
	@Override
	public int getNoticeUpdate(NoticeDto noticeDto) {
		return noticeMapper.update(noticeDto);
	}
	
	@Override
	public int getNoticeDelete(String nid) {
		return noticeMapper.delete(nid);
	}

	@Override
	public int getNoticeUpload(NoticeDto noticeDto) {	return noticeMapper.upload(noticeDto); }

	/**
	 *	Review
	 */
	@Override
	public ReviewDto getReviewDetailSelectJson(String rid) {
		return reviewMapper.select(rid);
	}

	@Override
	public int getReviewMainUpdate(String rid) {
		return reviewMapper.updateToMain(rid);
	}

	@Override
	public List<ReviewDto> getReviewMainList() {
		return reviewMapper.reviewMainList();
	}

	@Override
	public int getReviewMainDelete(String rid) {
		return reviewMapper.deleteFromMain(rid);
	}

	/**
	 *	Shop
	 */
	@Override
	public List<ShopDto> getShopSelectJson(boolean sconfirm, boolean aconfirmfinal) {
		Map<String, String> map = new HashMap<String, String>();
		String sconfirmCheck = sconfirm ? String.valueOf('Y') : String.valueOf('N');
		String aconfirmfinalCheck = aconfirmfinal ? String.valueOf('Y') : String.valueOf('N');
		map.put("sconfirm", sconfirmCheck);
		map.put("aconfirmfinal", aconfirmfinalCheck);
		return shopMapper.select(map);
	}
	
	@Override
	public int getConfirmUpdate(String sid) {
		return adminMapper.update(sid);
	}
	
	@Override
	public int getCancelUpdate(String sid) {
		return adminDao.cancel(sid);
	}
}
