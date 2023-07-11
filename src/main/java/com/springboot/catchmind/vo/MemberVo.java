package com.springboot.catchmind.vo;

public class MemberVo {
	
	String mid, memberId, mname, mpass, memail1, memail2, tel, mphone1, mphone2, mphone3,
	   mcreatedate, mmodifydate, roleId, deleteYN, beforemPass;

	String memail, mphone, kemail;

	int rno, loginResult;
	
	public String getMemailAdmin() {
		return memail;
	}

	public String getMphoneAdmin() {
		return mphone;
	}	

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public String getMemail1() {
		return memail1;
	}

	public void setMemail1(String memail1) {
		this.memail1 = memail1;
	}

	public String getMemail2() {
		return memail2;
	}

	public void setMemail2(String memail2) {
		this.memail2 = memail2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMphone1() {
		return mphone1;
	}

	public void setMphone1(String mphone1) {
		this.mphone1 = mphone1;
	}

	public String getMphone2() {
		return mphone2;
	}

	public void setMphone2(String mphone2) {
		this.mphone2 = mphone2;
	}

	public String getMphone3() {
		return mphone3;
	}

	public void setMphone3(String mphone3) {
		this.mphone3 = mphone3;
	}
	
	public String getMcreatedate() {
		return mcreatedate;
	}

	public void setMcreatedate(String mcreatedate) {
		this.mcreatedate = mcreatedate;
	}

	public String getMmodifydate() {
		return mmodifydate;
	}

	public void setMmodifydate(String mmodifydate) {
		this.mmodifydate = mmodifydate;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
	}

	public String getBeforemPass() {
		return beforemPass;
	}

	public void setBeforemPass(String beforemPass) {
		this.beforemPass = beforemPass;
	}

	public String getMemail() {
		return memail = memail1 + "@" + memail2;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphone() {
		return mphone = mphone1 + "-" + mphone2 + "-" + mphone3;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getKemail() {
		return kemail;
	}

	public void setKemail(String kemail) {
		this.kemail = kemail;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(int loginResult) {
		this.loginResult = loginResult;
	}

	


}
