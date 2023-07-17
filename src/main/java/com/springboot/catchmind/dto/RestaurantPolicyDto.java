package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class RestaurantPolicyDto {
    String pid, sid, ptitle, pcontents, pcreatedate, pdeleteyn;
    int rno;
}
