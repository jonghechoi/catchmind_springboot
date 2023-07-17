package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.ReservationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ReservationMapper {
    int insert(BookingDto bookingDto);
    int insertPayment(BookingDto bookingDto);
    ArrayList<ReservationDto> selectRtime(BookingDto bookingDto);
    ArrayList<ReservationDto> selectGuestnumber(BookingDto bookingDto);
}
