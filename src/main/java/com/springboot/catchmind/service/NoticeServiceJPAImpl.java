package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.jpa.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeServiceJpa")
@RequiredArgsConstructor
public class NoticeServiceJPAImpl {

    private NoticeRepository noticeRepository;

    public long getTotalRowCount() {
        return noticeRepository.count();
    }

//    public List<NoticeDto> getNoticeSelectJson(PageDto pageDto) {
//        return
//    }

}
