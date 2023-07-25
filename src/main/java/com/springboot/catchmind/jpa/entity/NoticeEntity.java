package com.springboot.catchmind.jpa.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="NOTICE")
public class NoticeEntity {
    @Id
    @GeneratedValue
    private String nid;
    private String AID;
    private String ncreateid;
    private String ncreatedate;
    private String nmodifyid;
    private String nmodifydate;
    private String ndeleteyn;
    private String ntitle;
    private int nhits;
    private String ncontents;
}
