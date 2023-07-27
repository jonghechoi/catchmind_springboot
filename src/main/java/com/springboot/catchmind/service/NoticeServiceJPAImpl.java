package com.springboot.catchmind.service;

import com.querydsl.core.Tuple;
import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.jpa.entity.NoticeEntity;
import com.springboot.catchmind.jpa.repository.NoticeRepository;
import com.springboot.catchmind.jpa.repositoryimpl.NoticeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeServiceJPA")
@RequiredArgsConstructor
public class NoticeServiceJPAImpl {

    @Autowired
    private NoticeRepositoryImpl noticeRepositoryImpl;

    private NoticeRepository noticeRepository;

    public List<Tuple> getNoticeByRownum() {
        return noticeRepositoryImpl.getNoticeByRownum();
    }

//    public List<NoticeEntity> getNoticeSelectJson(PageDto pageDto) {
//        return noticeRepositoryImpl.getNoticeListByPage(pageDto);
//    }
    public List<NoticeDto> getNoticeSelectJson(Pageable pageable) {
        return noticeRepositoryImpl.getNoticeListByPage(pageable);
    }
}
