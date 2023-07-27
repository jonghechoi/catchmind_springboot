package com.springboot.catchmind.dto;

import lombok.Data;

@Data
public class NoticeDto {
    String nid, aid, ncreateid, ncreatedate, nmodifydate, ndeleteyn, ntitle, ncontents;
    int nhits;
    long rno;
}
