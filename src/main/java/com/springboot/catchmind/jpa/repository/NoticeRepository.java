package com.springboot.catchmind.jpa.repository;

import com.querydsl.core.Tuple;
import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.jpa.entity.NoticeEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoticeRepository {

    public List<Tuple> getNoticeByRownum();
    List<NoticeEntity> getNoticeListByPage(Pageable pageable);

}
