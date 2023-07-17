package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class SessionDto {
	private String mid, memberId, roleId, mpass, kemail, mname;
	
	private String sid, spass;
	
	private int loginResult;
	
}
