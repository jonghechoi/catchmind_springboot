package com.springboot.catchmind.restcontroller;

import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.ShopDto;
import com.springboot.catchmind.dto.TabletypeDto;
import com.springboot.catchmind.service.ReservationService;
import com.springboot.catchmind.service.ShopService;
import com.springboot.catchmind.service.ShopServiceImpl;
import com.springboot.catchmind.service.TabletypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestaurantRestController {
    @Autowired
    TabletypeService tabletypeService;

    @Autowired
    ShopServiceImpl shopServiceImpl;

    @Autowired
    ReservationService reservationService;

    /*
     * select_guestnumber.do -  select guest number
     * */
    @PostMapping ("select_rtime")
    public ArrayList<String> select_rtime(BookingDto bookingDto) throws ParseException {
        ShopDto shopDto = shopServiceImpl.shopSelect(bookingDto.getSid());
        bookingDto.setSopeninghour(shopDto.getSopeninghour());
        bookingDto.setSclosinghour(shopDto.getSclosinghour());

        int rtabletypeNum = tabletypeService.selectRtabletypeNum(bookingDto);
        bookingDto.setRtabletypeNum(rtabletypeNum);

        return reservationService.selectRtime(bookingDto);
    }


    /*
     * select_guestnumber.do -  select guest number
     * */
    @PostMapping("select_guestnumber")
    public Map<String, Integer> select_guestnumber(BookingDto bookingDto) throws ParseException, ParseException {
        Map<String, Integer> param =  new HashMap<String, Integer>();
        ShopDto shopDto = shopServiceImpl.shopSelect(bookingDto.getSid());
        bookingDto.setSopeninghour(shopDto.getSopeninghour());
        bookingDto.setSclosinghour(shopDto.getSclosinghour());

        int minOccupiedTableNum = reservationService.selectGuestnumber(bookingDto);
        int rtabletypeNum = tabletypeService.selectRtabletypeNum(bookingDto);

        param.put("minOccupiedTableNum", minOccupiedTableNum);
        param.put("rtabletypeNum", rtabletypeNum);

        return param;
    }

    /*
     * select_rtabletype -  select table type
     * */
    @PostMapping("select_rtabletype")
    public TabletypeDto select_rtabletype(BookingDto bookingDto) {
        return tabletypeService.tabletypeSelect(bookingDto.getSid());
    }
}
