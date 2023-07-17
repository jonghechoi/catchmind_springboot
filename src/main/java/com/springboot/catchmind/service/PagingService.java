package com.springboot.catchmind.service;

import java.util.Map;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.vo.MemberVo;

public interface PagingService {
	
	/* public ArrayList<MemberVo> getMemberSelect(); */
	
	public MemberVo getCertainMemberSelect(String mid);
	
	public PageDto getPageResult(PageDto pageDto);
	
	public Map<String, String> getVisitedResult(String page, String serviceName, String mid);
}
