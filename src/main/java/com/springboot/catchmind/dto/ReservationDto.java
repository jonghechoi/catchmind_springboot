package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class ReservationDto {
    String rid, rdate, rtime, rmodifydate, rmodifytime, rrequest, rphone, deleteyn, sid, mid, rtabletype, rstatus, reviewyn;
    int rno, guestnumber;
    String mname;
}
