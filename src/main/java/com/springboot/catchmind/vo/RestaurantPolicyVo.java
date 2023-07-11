package com.springboot.catchmind.vo;

public class RestaurantPolicyVo {
	String pid, sid, ptitle, pcontents, pcreatedate, pdeleteyn;
	int rno;	
	

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPcontents() {
		return pcontents;
	}

	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}

	public String getPcreatedate() {
		return pcreatedate;
	}

	public void setPcreatedate(String pcreatedate) {
		this.pcreatedate = pcreatedate;
	}

	public String getPdeleteyn() {
		return pdeleteyn;
	}

	public void setPdeleteyn(String pdeleteyn) {
		this.pdeleteyn = pdeleteyn;
	}
}
