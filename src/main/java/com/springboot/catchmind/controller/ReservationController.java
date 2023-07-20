package com.springboot.catchmind.controller;

import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.RestaurantPolicyDto;
import com.springboot.catchmind.dto.ShopDto;
import com.springboot.catchmind.service.ReservationService;
import com.springboot.catchmind.service.RestaurantPolicyService;
import com.springboot.catchmind.service.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Controller
public class ReservationController {

    @Autowired
    ShopServiceImpl shopServiceImpl;

    @Autowired
    RestaurantPolicyService restaurantPolicyService;

    @Autowired
    ReservationService reservationService;


    /*
     * booking_without_payment.do
     */
    @PostMapping("booking_without_payment")
    public String booking_without_payment(BookingDto bookingDto)
            throws ParseException {
        //Map<String, String> param = new HashMap<String, String>();
        String route = null;
//        SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
//        String mid = sessionVo.getMid();
        //System.out.println(rrequest);
        //System.out.println(rphone);

//        param.put("sid", sid);
//        param.put("rdate", rdate);
//        param.put("rtabletype", rtabletype);
//        param.put("rtime", rtime);
//        param.put("rrequest", rrequest);
//        param.put("rphone", contact);
//        param.put("mid", mid);

        //ReservationDao reservationDao = new ReservationDao();
        int result = reservationService.insert(bookingDto);

        if(result == 1) {
            route = "redirect:/mydining_scheduled";
        }
        else {
            //예약 실패 - 에러페이지 호출 필요
            System.out.println("Error - Booking without payment");
        }

        return route;
    }



    /*
     * booking_with_payment.do
     */
    @PostMapping("booking_with_payment")
    public String booking_with_payment(BookingDto bookingDto) throws ParseException {
//        Map<String, String> param = new HashMap<String, String>();
//        Map<String, Integer> param2 = new HashMap<String, Integer>();
        String route = null;
//        SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
//        String mid = sessionVo.getMid();
        //System.out.println(rrequest);
        //System.out.println(contact);

//        param.put("sid", sid);
//        param.put("rdate", rdate);
//        param.put("rtime", rtime);
//        param.put("rtabletype", rtabletype);
//        param.put("rrequest", rrequest);
//        param.put("contact", contact);
//        param.put("mid", mid);
//
//        param2.put("guestnumber", guestnumber);
//        param2.put("amount", paymentAmount);
//
//        ReservationDao reservationDao = new ReservationDao();
        int result = reservationService.insertPayment(bookingDto);

        if(result == 1) {
            route = "redirect:/mydining_scheduled.do";
        }
        else {
            //예약 실패 - 에러페이지 호출 필요
            System.out.println("Error - Booking with payment");
        }

        return route;
    }


    /**
     * reservation_proc - reservation values sending
     */
    @PostMapping("reservation_proc")
    public String reservation_proc(BookingDto bookingDto, Model model) throws ParseException {
        //SessionDto sessionDto = (SessionDto)session.getAttribute("sessionDto");
        //String mid = sessionDto.getMid();

        ShopDto shopDto = shopServiceImpl.shopSelect(bookingDto.getSid());
        ArrayList<RestaurantPolicyDto> rsPolicyList = restaurantPolicyService.rsPolicySelect(bookingDto.getSid());

        int smealfee = shopDto.getSmealfee();
        int sdeposit = shopDto.getSdeposit();

        String rdate2 = bookingDto.getRdate();
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date rdate3 = transFormat.parse(rdate2);
        Calendar targetDate = Calendar.getInstance();
        targetDate.setTime(rdate3); // 시간 설정
        targetDate.add(Calendar.DAY_OF_MONTH , -3); // 시간 연산

        model.addAttribute("bookingDto", bookingDto);
        model.addAttribute("shopDto", shopDto);
        model.addAttribute("rsPolicyList", rsPolicyList);
        model.addAttribute("targetDate", transFormat.format(targetDate.getTime()));
        //model.addAttribute("sessionDto", sessionDto);

        String path = "";

        if(smealfee == 0 && sdeposit == 0) {
            path = "/pages/reservation/reservation_confirm_nopayment";
        }
        else if(smealfee == 0 && sdeposit > 0) {
            //model.addObject("paymentAmount", shopVo.getSdeposit());
            model.addAttribute("paymentAmount", sdeposit);

            path = "/pages/reservation/reservation_confirm";
        }
        else if(smealfee > 0 && sdeposit == 0) {
            //model.addObject("paymentAmount", shopVo.getSmealfee());
            model.addAttribute("paymentAmount", smealfee);

            path = "/pages/reservation/reservation_confirm";
        }

        return path;
    }
}
