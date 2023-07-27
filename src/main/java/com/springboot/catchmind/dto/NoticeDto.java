package com.springboot.catchmind.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeDto {
    String nid, aid, ncreateid, ncreatedate, nmodifyid, nmodifydate, ndeleteyn, ntitle, ncontents;
    int nhits;
    int rno;

    @QueryProjection
    public NoticeDto(String nid, String aid, String ncontents, String ncreatedate, String ncreateid,
                        String ndeleteyn, int nhits, int rno, String nmodifydate, String nmodifyid, String ntitle) {
        this.nid = nid;
        this.aid = aid;
        this.ncontents = ncontents;
        this.ncreatedate = ncreatedate;
        this.ncreateid = ncreateid;
        this.ndeleteyn = ndeleteyn;
        this.nhits = nhits;
        this.nmodifydate = nmodifydate;
        this.nmodifyid = nmodifyid;
        this.ntitle = ntitle;
        this.rno = rno;
    }

    @QueryProjection
    public NoticeDto(String nid, String ntitle, String ncreatedate, int rno) {
        this.nid = nid;
        this.ntitle = ntitle;
        this.ncreatedate = ncreatedate;
        this.rno = rno;
    }
}
