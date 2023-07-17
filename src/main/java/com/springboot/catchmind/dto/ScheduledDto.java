package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class ScheduledDto {
	private String mid, sid, rid, memberId, mname, tel, mphone, sname, slocShort, rdate, rtime,
		 rphone, sloc, sintro, sphone, sopeningHour, sclosingHour, sclosingDate, rstatus, reviewYN, smphoto, fid, fcheck;
	
	private int rno, totalMount, sdeposit, guestNumber, startCount, endCount;
	
}
