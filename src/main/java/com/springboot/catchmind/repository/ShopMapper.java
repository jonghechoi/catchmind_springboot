package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.FacilityDto;
import com.springboot.catchmind.dto.ShopDto;
import com.springboot.catchmind.dto.ShopPhotoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopMapper {
    List<ShopDto> select(Map map);

    int insert(ShopDto shopDto);

    String selectSpass();

    int selectSpassCheck(String spass);

    ShopDto shopInfoSelect(String sid);

    FacilityDto facilitySelect(String sid);

    ShopPhotoDto photoSelect(String sid);
}
