package com.springboot.catchmind.jpa.repository;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;

import java.util.List;

public interface NoticeJPARepository {

    List<NoticeDto> getNoticeListByPage(PageDto pageDto);

}
