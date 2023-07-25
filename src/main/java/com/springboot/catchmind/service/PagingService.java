package com.springboot.catchmind.service;

import java.util.Map;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.vo.MemberVo;

public interface PagingService {
	
	/* public ArrayList<MemberVo> getMemberSelect(); */


	public PageDto getPageResult(PageDto pageDto);
	
	public PageDto getVisitedResult(PageDto pageDto);
}
