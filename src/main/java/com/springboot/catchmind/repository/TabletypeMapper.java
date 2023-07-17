package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.TabletypeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TabletypeMapper {
    int selectRtabletypeNum(BookingDto bookingDto);
    TabletypeDto tabletypeSelect(String sid);
}
