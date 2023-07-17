package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper {
    int totalRowCount(PageDto pageDto);
}
