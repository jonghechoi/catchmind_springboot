package com.springboot.catchmind.jpa.entity;


import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="NOTICE")
@NoArgsConstructor
public class NoticeEntity {
    @Id
    String nid;
    String aid;
    String ncontents;
    String ncreatedate;
    String ncreateid;
    String ndeleteyn;
    int nhits;
    String nmodifydate;
    String nmodifyid;
    String ntitle;

    @Builder
    @QueryProjection
    public NoticeEntity(String nid, String aid, String ncontents, String ncreatedate, String ncreateid,
                        String ndeleteyn, int nhits, String nmodifydate, String nmodifyid, String ntitle) {
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
    }
}