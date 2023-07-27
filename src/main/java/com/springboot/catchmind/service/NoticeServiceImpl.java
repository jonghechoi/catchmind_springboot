package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.jpa.entity.NoticeEntity;
import com.springboot.catchmind.jpa.repository.NoticeRepository;
import com.springboot.catchmind.jpa.repositoryimpl.NoticeRepositoryImpl;
import com.springboot.catchmind.repository.NoticeMapper;
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
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private NoticeRepositoryImpl noticeRepositoryImpl;
	
	public int getTotalRowCount() {	return noticeDao.totalRowCount(); };

	public List<NoticeDto> getNoticeSelectJson(PageDto pageDto) {
		return noticeMapper.selectList(pageDto);
	}
}
