package com.springboot.catchmind.dto;

import java.time.LocalDateTime;

import com.springboot.catchmind.entity.Shop;

import lombok.Getter;

@Getter
public class ShopResponseDto {
    private String sid;
    private String roleid, sdeleteyn, aconfirmyn, aconfirmfinalyn, sconfirmyn,
            spass, sname, sphone, sloc, slocx, slocy, slocshort, sintro, sclosingdate, swebsite, sfoodstyle, smphoto, sopeninghour, sclosinghour;
    private int rno, sdeposit, smealfee, lunch, dinner;
    private LocalDateTime screatedate, smodifydate;

    private String sopeninghourString, sclosinghourString, sdepositString, smealfeeString, lunchString, dinnerString;

    public ShopResponseDto(Shop entity) {
        this.sid = entity.getSid();
        this.roleid = entity.getRoleid();
        this.sdeleteyn = entity.getSdeleteyn();
        this.aconfirmyn = entity.getAconfirmyn();
        this.aconfirmfinalyn = entity.getAconfirmfinalyn();
        this.sconfirmyn = entity.getSconfirmyn();
        this.spass = entity.getSpass();
        this.sname = entity.getSname();
        this.sphone = entity.getSphone();
        this.sloc= entity.getSloc();
        this.slocx = entity.getSlocx();
        this.slocy = entity.getSlocy();
        this.slocshort = entity.getSlocshort();
        this.sintro = entity.getSintro();
        this.sclosingdate = entity.getSclosingdate();
        this.swebsite = entity.getSwebsite();
        this.sfoodstyle = entity.getSfoodstyle();
        this.smphoto = entity.getSmphoto();
        this.sopeninghour = entity.getSopeninghour();
        this.sclosinghour = entity.getSclosinghour();
        this.rno = entity.getRno();
        this.sdeposit = entity.getSdeposit();
        this.smealfee = entity.getSmealfee();
        this.lunch = entity.getLunch();
        this.dinner = entity.getDinner();
        this.screatedate = entity.getScreatedate();
        this.smodifydate = entity.getSmodifydate();
    }
}
