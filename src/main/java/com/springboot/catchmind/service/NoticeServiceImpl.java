package com.springboot.catchmind.service;

import java.util.List;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.jpa.repository.NoticeJPARepository;
import com.springboot.catchmind.jpa.repositoryimpl.NoticeJPARepositoryImpl;
import com.springboot.catchmind.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl {

/*	@Autowired
	private PagingServiceImpl pagingService;*/
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private NoticeJPARepository noticeJPARepository;
	@Autowired
	private NoticeJPARepositoryImpl noticeRepositoryImpl;
	
	//public int getTotalRowCount() {	return noticeDao.totalRowCount(); };

	public int getTotalRowCount() {	return noticeMapper.totalRowCount(); };

	// JPA 전환중
	public List<NoticeDto> getNoticeSelectJson(PageDto pageDto) {
		return noticeMapper.selectList(pageDto);
	}
}
