package com.springboot.catchmind.vo;

public class SessionVo {
	String mid, memberId, roleId, mpass, kemail, mname;
	
	String sid, spass;
	
	int loginResult;
	
	public String getMname() {
		return mname;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSpass() {
		return spass;
	}

	public void setSpass(String spass) {
		this.spass = spass;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public String getKemail() {
		return kemail;
	}

	public void setKemail(String kemail) {
		this.kemail = kemail;
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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public int getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(int loginResult) {
		this.loginResult = loginResult;
	}

}
