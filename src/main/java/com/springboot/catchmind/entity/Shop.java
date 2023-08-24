package com.springboot.catchmind.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATCHMIND_SEQ")
    @SequenceGenerator(sequenceName = "SEQU_SHOP_SID", name = "CATCHMIND_SEQ", allocationSize = 1)
    private String sid;

    private String roleid, sdeleteyn, aconfirmyn, aconfirmfinalyn, sconfirmyn,
            spass, sname, sphone, sloc, slocx, slocy, slocshort, sintro, sclosingdate, swebsite, sfoodstyle, smphoto, sopeninghour, sclosinghour;

    private int rno, sdeposit, smealfee, lunch, dinner;
    private LocalDateTime screatedate = LocalDateTime.now(); // 생성일
    private LocalDateTime smodifydate; // 수정일

    @Transient
    private String sopeninghourString, sclosinghourString, sdepositString, smealfeeString, lunchString, dinnerString;


    @Builder
    public Shop(String roleid, String screatedate, String sdeleteyn, String aconfirmyn, String aconfirmfinalyn, String sconfirmyn, String spass, String sname, String sphone, String sloc, String slocx, String slocy, String slocshort, String sintro, String smodifydate, String sclosingdate, String swebsite, String sfoodstyle, String smphoto, String sopeninghour, String sclosinghour, int rno, int sdeposit, int smealfee, int lunch, int dinner) {
        this.roleid = roleid;
        this.sdeleteyn = sdeleteyn;
        this.aconfirmyn = aconfirmyn;
        this.aconfirmfinalyn = aconfirmfinalyn;
        this.sconfirmyn = sconfirmyn;
        this.spass = spass;
        this.sname = sname;
        this.sphone = sphone;
        this.sloc= sloc;
        this.slocx = slocx;
        this.slocy = slocy;
        this.slocshort = slocshort;
        this.sintro = sintro;
        this.sclosingdate = sclosingdate;
        this.swebsite = swebsite;
        this.sfoodstyle = sfoodstyle;
        this.smphoto = smphoto;
        this.sopeninghour = sopeninghour;
        this.sclosinghour = sclosinghour;
        this.rno = rno;
        this.sdeposit =sdeposit;
        this.smealfee = smealfee;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public void update(String sdeleteyn, String aconfirmyn, String aconfirmfinalyn, String sconfirmyn, String spass, String sname, String sphone, String sloc, String slocx, String slocy, String slocshort, String sintro, String smodifydate, String sclosingdate, String swebsite, String sfoodstyle, String smphoto, String sopeninghour, String sclosinghour, int rno, int sdeposit, int smealfee, int lunch, int dinner) {
        this.sdeleteyn = sdeleteyn;
        this.aconfirmyn = aconfirmyn;
        this.aconfirmfinalyn = aconfirmfinalyn;
        this.sconfirmyn = sconfirmyn;
        this.spass = spass;
        this.sname = sname;
        this.sphone = sphone;
        this.sloc= sloc;
        this.slocx = slocx;
        this.slocy = slocy;
        this.slocshort = slocshort;
        this.sintro = sintro;
        this.sclosingdate = sclosingdate;
        this.swebsite = swebsite;
        this.sfoodstyle = sfoodstyle;
        this.smphoto = smphoto;
        this.sopeninghour = sopeninghour;
        this.sclosinghour = sclosinghour;
        this.rno = rno;
        this.sdeposit =sdeposit;
        this.smealfee = smealfee;
        this.lunch = lunch;
        this.dinner = dinner;
        this.smodifydate = LocalDateTime.now();
    }
}
