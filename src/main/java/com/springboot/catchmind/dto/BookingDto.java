package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class BookingDto {
	String sid, rdate, rtabletype, rtime;
	String sopeninghour, sclosinghour;
	String endTime, startTime;
	int guestnumber;
	int rtabletypeNum;
	String mid, kemail, contact, rrequest;
	int paymentAmount;
}
