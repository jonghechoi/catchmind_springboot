package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.ReservationDto;
import com.springboot.catchmind.repository.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
//@MapperScan("com.springboot.catchmind.repository.ReservationRepository")
public class ReservationService {
    @Autowired
    ReservationMapper reservationMapper;

    public int insert(ReservationDto reservationDto){
        return reservationMapper.insert(reservationDto);
    }

    public int insertPayment(BookingDto bookingDto){
        return reservationMapper.insertPayment(bookingDto);
    }

    public ArrayList<String> selectRtime(BookingDto bookingDto) throws ParseException {
        ArrayList<String> timeList = new ArrayList<String>();
        String time_open = bookingDto.getRdate() + " " + bookingDto.getSopeninghour();
        String time_close = bookingDto.getRdate() + " " + bookingDto.getSclosinghour();

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date start = transFormat.parse(time_open);
        Date close = transFormat.parse(time_close);

        Calendar startTime = Calendar.getInstance();
        startTime.setTime(start); // 시간 설정
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(start); // 시간 설정
        endTime.add(Calendar.HOUR_OF_DAY , 2); // 시간 연산
        Calendar closeTime = Calendar.getInstance();
        closeTime.setTime(close); // 시간 설정

        int tableNumForGuest = 0;
        int guestnumber = bookingDto.getGuestnumber();

        if(guestnumber % 2 != 0) {
            tableNumForGuest = guestnumber / 2 + 1;
        }
        else {
            tableNumForGuest += guestnumber / 2;
        }

        while(!endTime.equals(closeTime)) {
            bookingDto.setEndTime(transFormat.format(endTime.getTime()));
            bookingDto.setStartTime(transFormat.format(startTime.getTime()));
            int sum = 0;
            ArrayList<ReservationDto> list = new ArrayList<ReservationDto>();
            list = reservationMapper.selectRtime(bookingDto);
            for(int i = 0; i < list.size(); i++){
                //System.out.println("rs.getInt(4) ---> " + rs.getInt(4));
                int tableNum = 0;
                if(list.get(i).getGuestnumber() % 2 != 0) {
                    tableNum = list.get(i).getGuestnumber() / 2 + 1;
                    sum += tableNum;
                }
                else {
                    sum += list.get(i).getGuestnumber() / 2;
                }
                //System.out.println("sum ---> " + sum);
            }

            if(sum + tableNumForGuest <= bookingDto.getRtabletypeNum()) {
                String time = transFormat.format(startTime.getTime()).substring(11);
                System.out.println("time ---> " + time);
                timeList.add(time);
            }

            startTime.add(Calendar.MINUTE, 30); // 분 연산
            endTime.add(Calendar.MINUTE, 30); // 분 연산
        }

        return timeList;
    }

    public int selectGuestnumber(BookingDto bookingDto) throws ParseException {
        String time_open = bookingDto.getRdate() + " " + bookingDto.getSopeninghour();
        String time_close = bookingDto.getRdate() + " " + bookingDto.getSclosinghour();

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date start = transFormat.parse(time_open);
        Date close = transFormat.parse(time_close);

        Calendar startTime = Calendar.getInstance();
        startTime.setTime(start); // 시간 설정
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(start); // 시간 설정
        endTime.add(Calendar.HOUR_OF_DAY , 2); // 시간 연산
        Calendar closeTime = Calendar.getInstance();
        closeTime.setTime(close); // 시간 설정
        int min = Integer.MAX_VALUE;

        while(!endTime.equals(closeTime)) {
            bookingDto.setEndTime(transFormat.format(endTime.getTime()));
            bookingDto.setStartTime(transFormat.format(startTime.getTime()));
            int sum = 0;
            ArrayList<ReservationDto> list = new ArrayList<ReservationDto>();
            list = reservationMapper.selectGuestnumber(bookingDto);
            for(int i = 0; i < list.size(); i++){
                //System.out.println("rs.getInt(4) ---> " + rs.getInt(4));
                int tableNum = 0;
                if (list.get(i).getGuestnumber() % 2 != 0) {
                    tableNum = list.get(i).getGuestnumber() / 2 + 1;
                    sum += tableNum;
                } else {
                    sum += list.get(i).getGuestnumber() / 2;
                }
                System.out.println("sum ---> " + sum);
            }
            if (min > sum) {
                min = sum;
            }
            startTime.add(Calendar.MINUTE, 30); // 분 연산
            endTime.add(Calendar.MINUTE, 30); // 분 연산
        }

        return min;
    }
}
