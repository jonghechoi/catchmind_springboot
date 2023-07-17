package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.FacilityDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FacilityMapper {
    FacilityDto facilitySelect(String sid);
}
