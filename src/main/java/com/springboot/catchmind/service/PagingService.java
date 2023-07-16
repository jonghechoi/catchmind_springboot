package com.springboot.catchmind.service;

import java.util.Map;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.vo.MemberVo;

public interface PagingService {
	
	/* public ArrayList<MemberVo> getMemberSelect(); */
	
	public MemberVo getCertainMemberSelect(String mid);
	
	public Map<String, Integer> getPageResult(String page, String serviceName);
	
	public PageDto getVisitedResult(PageDto pageDto);
}
