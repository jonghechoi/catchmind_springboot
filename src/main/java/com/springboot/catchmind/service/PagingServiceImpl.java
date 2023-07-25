package com.springboot.catchmind.service;

import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.dto.PageDto;
import java.util.HashMap;
import java.util.Map;

import com.springboot.catchmind.repository.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pagingService")
public class PagingServiceImpl implements PagingService {
	
	@Autowired
	private MyDiningServiceImpl myDiningService;

	@Autowired
	PageMapper pageMapper;


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
		pageDto.setReqPage(reqPage);
		
		return pageDto;
	}
	
	@Override
	public PageDto getVisitedResult(PageDto pageDto) {
		int startCount = 0;
		int endCount = 0;
		int pageSize = 12;
		int reqPage = 1;
		int pageCount = 1;
		int dbCount = 0;
		
		if(pageDto.getServiceName().equals("visited")) {
			dbCount = myDiningService.getTotalRowCount(pageDto);

		}else if(pageDto.getServiceName().equals("cancel_noshow")) {
			dbCount = myDiningService.getTotalRowCount(pageDto);
		}
		
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
			endCount = 12;
		}

		pageDto.setStartCount(startCount);
		pageDto.setEndCount(endCount);
		pageDto.setDbCount(dbCount);
		pageDto.setPageSize(pageSize);
		pageDto.setPageCount(pageCount);
		pageDto.setReqPage(reqPage);
		
		return pageDto;
	}
}
