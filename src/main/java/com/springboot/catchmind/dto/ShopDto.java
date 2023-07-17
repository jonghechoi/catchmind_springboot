package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class ShopDto {
	String sid, roleid, screatedate, sdeleteyn, aconfirmyn, aconfirmfinalyn, sconfirmyn, 
		   spass, sname, sphone, sloc, slocx, slocy, slocshort, sintro, smodifydate, 
		   sclosingdate, swebsite, sfoodstyle, smphoto, sopeninghour, sclosinghour;
	int rno, sdeposit, smealfee, lunch, dinner;
	String sopeninghourString, sclosinghourString, sdepositString, smealfeeString, lunchString, dinnerString;
}
