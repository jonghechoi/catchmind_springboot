package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class MemberDto {
	
	private String mid, memberId, mname, mpass, memail1, memail2, tel, mphone1, mphone2, mphone3,
	   mcreatedate, mmodifydate, roleId, deleteYN, beforemPass;

	private String memail, mphone, kemail;

	private int rno, loginResult;
	
	public String getMemail() {
		return memail = memail1 + "@" + memail2;
	}

	public String getMphone() {
		return mphone = mphone1 + "-" + mphone2 + "-" + mphone3;
	}
}
