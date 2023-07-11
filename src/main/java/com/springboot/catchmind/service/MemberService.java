package com.springboot.catchmind.service;

import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.SessionVo;

public interface MemberService {
	int getIdCheck(String memberId);
	
	int getJoin(MemberVo memberVo);
	
	int getLoginIdCheck(MemberVo memberVo);
	
	SessionVo getMemberLogin(MemberVo memberVo);
	
	int getRoleIdCheck(MemberVo memberVo);
	
	SessionVo getRoleLogin(MemberVo memberVo);
	
	int getKakaoIdCheck(MemberVo memberVo); 
	
	SessionVo getKakaoLogin(MemberVo memberVo);
	
	int getKakaoJoin(MemberVo memberVo);
	
	public int getUpdate(MemberVo memberVo);
	
	public int getTotalRowCount();
}
