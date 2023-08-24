package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.jpa.repositoryimpl.NoticeJPARepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeServiceJPA")
@RequiredArgsConstructor
public class NoticeServiceJPAImpl {

    @Autowired
    private NoticeJPARepositoryImpl noticeRepositoryImpl;

    public int getTotalRowCount() {
        return noticeRepositoryImpl.getTotalRowCount();
    }

    public List<NoticeDto> getNoticeSelectJson(PageDto pageDto) {
        return noticeRepositoryImpl.getNoticeListByPage(pageDto);
    }
}
