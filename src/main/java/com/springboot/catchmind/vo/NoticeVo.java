package com.springboot.catchmind.vo;

public class NoticeVo {
	String nid, aid, ncreateid, ncreatedate, nmodifydate, ndeleteyn, ntitle, ncontents;
	int rno, nhits;
	
	public int getNhits() {
		return nhits;
	}

	public void setNhits(int nhits) {
		this.nhits = nhits;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getNcreateid() {
		return ncreateid;
	}

	public void setNcreateid(String ncreateid) {
		this.ncreateid = ncreateid;
	}

	public String getNcreatedate() {
		return ncreatedate;
	}

	public void setNcreatedate(String ncreatedate) {
		this.ncreatedate = ncreatedate;
	}

	public String getNmodifydate() {
		return nmodifydate;
	}

	public void setNmodifydate(String nmodifydate) {
		this.nmodifydate = nmodifydate;
	}

	public String getNdeleteyn() {
		return ndeleteyn;
	}

	public void setNdeleteyn(String ndeleteyn) {
		this.ndeleteyn = ndeleteyn;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontents() {
		return ncontents;
	}

	public void setNcontents(String ncontents) {
		this.ncontents = ncontents;
	}
	
	
}
