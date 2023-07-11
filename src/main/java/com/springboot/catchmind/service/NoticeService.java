package com.springboot.catchmind.service;

import com.springboot.catchmind.vo.NoticeVo;

public interface NoticeService {

	public int getTotalRowCount();
	
	public String getNoticeSelect(String page);
	
	public int getNoticeUpload(NoticeVo noticeVo);
}
