package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopMapper {
    //start Dayoung
    ShopDto shopSelect(String sid);
    Map<String, String> getPriceInString(String sid);
    //end Dayoung

    List<ShopDto> select(Map map);

    int insert(ShopDto shopDto);

    String selectSpass();

    int selectSpassCheck(String spass);

    ShopDto shopInfoSelect(String sid);

    FacilityDto facilitySelect(String sid);

    int facilityCheck(String sid);

    int facilityInsert(FacilityDto facilityDto);

    int facilityUpdate(FacilityDto facilityDto);

    ShopPhotoDto photoSelect(String sid);

    int photoSelectCheck(String sid);

    int shopRegistrationCheck(ShopDto shopDto);

    int detailInsert(ShopDto shopDto);

    int detailUpdate(ShopDto shopDto);

    List<BookingDto> reservationSelect(Map map);

    List<SearchDto> mapSelect(double lat, double lng);
}
