package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.RestaurantPolicyDto;
import com.springboot.catchmind.repository.RestaurantPolicyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RestaurantPolicyService {
    @Autowired
    RestaurantPolicyMapper restaurantPolicyMapper;

    public ArrayList<RestaurantPolicyDto> rsPolicySelect(String sid){
        return restaurantPolicyMapper.rsPolicySelect(sid);
    }

    public ArrayList<RestaurantPolicyDto> rsPolicyNotNullList(String sid){
        return restaurantPolicyMapper.rsPolicyNotNullList(sid);
    }
}
