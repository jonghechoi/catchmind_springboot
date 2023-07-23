package com.springboot.catchmind.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    int update(String sid);

    int cancle(String sid);
}
