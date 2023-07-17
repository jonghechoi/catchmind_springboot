package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class MemberDto {
	
	String mid, memberId, mname, mpass, memail1, memail2, tel, mphone1, mphone2, mphone3,
	   mcreatedate, mmodifydate, roleId, deleteYN, beforemPass;

	String memail, mphone, kemail;

	int rno, loginResult;
}
