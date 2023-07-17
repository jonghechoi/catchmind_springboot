package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.RestaurantPolicyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface RestaurantPolicyMapper {
    ArrayList<RestaurantPolicyDto> rsPolicySelect(String sid);
    ArrayList<RestaurantPolicyDto> rsPolicyNotNullList(String sid);
}
