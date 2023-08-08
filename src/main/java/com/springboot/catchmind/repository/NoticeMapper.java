package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDto> selectList(PageDto pageDto);
    NoticeDto select(String nid);
    int update(NoticeDto noticeDto);
    int upload(NoticeDto noticeDto);
    int delete(String nid);
    int totalRowCount();
}
