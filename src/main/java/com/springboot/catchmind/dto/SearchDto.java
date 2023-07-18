package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class SearchDto {
	String sid,sname,sintro,slocshort,smphoto,rtime,sloc,slocx,slocy,sfoodstyle,value,sopeninghour;
	int lunch,dinner;
	double reviewstar;

}
