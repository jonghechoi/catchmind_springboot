package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.FacilityDto;
import com.springboot.catchmind.repository.FacilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {
    @Autowired
    FacilityMapper facilityMapper;

    public FacilityDto facilitySelect(String sid){
        return facilityMapper.facilitySelect(sid);
    }
}
