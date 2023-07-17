package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class BookingDto {
	String RID, RDATE, RTIME, RMODIFYDATE, RMODIFYTIME, RTABLETYPE, RREQUEST, RPHONE, DELETEYN, SID, UID, TID,
		   MID, MNAME;
	int GUESTNUMBER;
}
