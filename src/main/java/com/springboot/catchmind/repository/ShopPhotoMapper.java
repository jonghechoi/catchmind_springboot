package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.ShopPhotoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ShopPhotoMapper {
    //start Dayoung
    ShopPhotoDto shopPhotoSelect(String sid);
    //end Dayoung

    int selectCheck(String sid);

    int insert(Map map);

    int update(Map map);
}
