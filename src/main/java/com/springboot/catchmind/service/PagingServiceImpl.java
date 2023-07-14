package com.springboot.catchmind.service;

import java.util.HashMap;
import java.util.Map;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.repository.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.vo.MemberVo;

@Service("pagingService")
public class PagingServiceImpl implements PagingService {
	
	@Autowired 
	private NoticeServiceImpl noticeService;
	@Autowired
	private MemberServiceImpl memberService;
	@Autowired
	private ReviewServiceImpl reviewService;
	@Autowired
	private MyDiningServiceImpl myDiningService;
	@Autowired
	private MemberDao memberdao;

	@Autowired
	PageMapper pageMapper;

	@Override
	public MemberVo getCertainMemberSelect(String mid) { return memberdao.select(mid); }
	
	@Override
	public PageDto getPageResult(PageDto pageDto) {
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;
		int reqPage = 1;
		int pageCount = 1;
		int dbCount = 0;

		dbCount = pageMapper.totalRowCount(pageDto);
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}

		if(pageDto.getPage() != null){
			reqPage = Integer.parseInt(pageDto.getPage());
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 5;
		}

		pageDto.setStartCount(startCount);
		pageDto.setEndCount(endCount);
		pageDto.setDbCount(dbCount);
		pageDto.setPageSize(pageSize);
		pageDto.setPageCount(pageCount);
		pageDto.setRegPage(reqPage);
		
		return pageDto;
	}
	
	@Override
	public Map<String, String> getVisitedResult(String page, String serviceName, String mid) {
		Map<String, String> param = new HashMap<String, String>();
		
		int startCount = 0;
		int endCount = 0;
		int pageSize = 12;
		int reqPage = 1;
		int pageCount = 1;
		int dbCount = 0;
		
		if(serviceName.equals("visited")) {
			dbCount = myDiningService.getTotalRowCount(mid);
		}
		
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 12;
		}
		
		param.put("startCount", String.valueOf(startCount));
		param.put("endCount", String.valueOf(endCount));
		param.put("dbCount", String.valueOf(dbCount));
		param.put("pageSize", String.valueOf(pageSize));
		param.put("maxSize", String.valueOf(pageCount));
		param.put("page", String.valueOf(reqPage));
		
		return param;
	}
}
