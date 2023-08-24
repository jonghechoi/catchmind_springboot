package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.FacilityDto;
import com.springboot.catchmind.repository.FacilityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private final FacilityMapper facilityMapper;

    public FacilityDto facilitySelect(String sid){
        return facilityMapper.facilitySelect(sid);
    }
}
