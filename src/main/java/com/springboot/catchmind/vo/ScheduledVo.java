package com.springboot.catchmind.vo;

public class ScheduledVo {
	private String mid, sid, rid, memberId, mname, tel, mphone, sname, slocShort, rdate, rtime,
		 rphone, sloc, sintro, sphone, sopeningHour, sclosingHour, sclosingDate, rstatus, reviewYN, smphoto, fid, fcheck;
	
	private int rno, totalMount, sdeposit, guestNumber, startCount, endCount;
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	public int getStartCount() {
		return startCount;
	}
	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}
	public int getEndCount() {
		return endCount;
	}
	public String getFcheck() {
		return fcheck;
	}
	public void setFcheck(String fcheck) {
		this.fcheck = fcheck;
	}
	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}
	public String getSmphoto() {
		return smphoto;
	}
	public void setSmphoto(String smphoto) {
		this.smphoto = smphoto;
	}
	public String getReviewYN() {
		return reviewYN;
	}
	public void setReviewYN(String reviewYN) {
		this.reviewYN = reviewYN;
	}
	public String getRstatus() {
		return rstatus;
	}
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSloc() {
		return sloc;
	}
	public void setSloc(String sloc) {
		this.sloc = sloc;
	}
	public String getSintro() {
		return sintro;
	}
	public void setSintro(String sintro) {
		this.sintro = sintro;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSopeningHour() {
		return sopeningHour;
	}
	public void setSopeningHour(String sopeningHour) {
		this.sopeningHour = sopeningHour;
	}
	public String getSclosingHour() {
		return sclosingHour;
	}
	public void setSclosingHour(String sclosingHour) {
		this.sclosingHour = sclosingHour;
	}
	public String getSclosingDate() {
		return sclosingDate;
	}
	public void setSclosingDate(String sclosingDate) {
		this.sclosingDate = sclosingDate;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSlocShort() {
		return slocShort;
	}
	public void setSlocShort(String slocShort) {
		this.slocShort = slocShort;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public int getTotalMount() {
		return totalMount = sdeposit * guestNumber;
	}
	public int getSdeposit() {
		return sdeposit;
	}
	public void setSdeposit(int sdeposit) {
		this.sdeposit = sdeposit;
	}
	public int getGuestNumber() {
		return guestNumber;
	}
	public void setGuestNumber(int guestNumber) {
		this.guestNumber = guestNumber;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	@Override
	public String toString() {
		return "ScheduledVo [mid=" + mid + ", sid=" + sid + ", rid=" + rid + ", memberId=" + memberId + ", mname="
				+ mname + ", tel=" + tel + ", mphone=" + mphone + ", sname=" + sname + ", slocShort=" + slocShort
				+ ", rdate=" + rdate + ", rtime=" + rtime + ", rphone=" + rphone + ", sloc=" + sloc + ", sintro="
				+ sintro + ", sphone=" + sphone + ", sopeningHour=" + sopeningHour + ", sclosingHour=" + sclosingHour
				+ ", sclosingDate=" + sclosingDate + ", rstatus=" + rstatus + ", reviewYN=" + reviewYN + ", smphoto="
				+ smphoto + ", rno=" + rno + ", totalMount=" + totalMount + ", sdeposit=" + sdeposit + ", guestNumber="
				+ guestNumber + "]";
	}
}
