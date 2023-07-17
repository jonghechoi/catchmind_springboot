package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.ShopPhotoDto;
import com.springboot.catchmind.repository.ShopPhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopPhotoService {
    @Autowired
    ShopPhotoMapper shopPhotoMapper;

    public ShopPhotoDto shopPhotoSelect(String sid){
        return shopPhotoMapper.shopPhotoSelect(sid);
    }
}
