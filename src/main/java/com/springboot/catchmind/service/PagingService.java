package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.PageDto;

public interface PagingService {
	
	/* public ArrayList<MemberVo> getMemberSelect(); */
	
//	public MemberVo getCertainMemberSelect(String mid);
	
	public PageDto getPageResult(PageDto pageDto);
	
	public PageDto getVisitedResult(PageDto pageDto);
}
