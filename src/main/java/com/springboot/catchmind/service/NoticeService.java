package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;

import java.util.List;

public interface NoticeService {

	public int getTotalRowCount();

	public List<NoticeDto> getNoticeSelectJson(PageDto pageDto);
}
