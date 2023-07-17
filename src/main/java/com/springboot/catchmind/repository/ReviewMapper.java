package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<ReviewDto> selectList(PageDto pageDto);

    ReviewDto select(String rid);

    int updateToMain(String rid);

    List<ReviewDto> reviewMainList();

    int deleteFromMain(String rid);
}
