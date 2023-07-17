package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.TabletypeDto;
import com.springboot.catchmind.repository.TabletypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabletypeService {
    @Autowired
    TabletypeMapper tabletypeMapper;

    public int selectRtabletypeNum(BookingDto bookingDto){
        return tabletypeMapper.selectRtabletypeNum(bookingDto);
    }
    public TabletypeDto tabletypeSelect(String sid){
        return tabletypeMapper.tabletypeSelect(sid);
    }
}
