package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl{
	@Autowired
	private MemberMapper memberMapper;

	public int getRoleIdCheck(MemberDto memberDto) {
		return memberMapper.roleIdCheck(memberDto);
	}
	
	public int getLoginIdCheck(MemberDto memberDto) {
		return memberMapper.loginIdCheck(memberDto);
	}
	
	public int getIdCheck(String memberId) {
		return memberMapper.idCheck(memberId);
	}
	
	public int getJoin(MemberDto memberDto) {
		return memberMapper.join(memberDto);
	}
	
	public SessionDto getMemberLogin(MemberDto memberDto) {
		return memberMapper.memberLogin(memberDto);
	}
	
	public SessionDto getRoleLogin(MemberDto memberDto) {
		return memberMapper.roleLogin(memberDto);
	}
	
	public int getKakaoJoin(MemberDto memberDto) {
		return memberMapper.kakaoJoin(memberDto);
	}
	
	public int getKakaoIdCheck(MemberDto memberDto) {
		return memberMapper.kakaoIdCheck(memberDto);
	}

	public SessionDto getKakaoLogin(MemberDto memberDto) {
		return memberMapper.kakaoLogin(memberDto);
	}

//	public int getUpdate(MemberVo memberVo) {
//		return memberDao.update(memberVo);
//	}
	
	public int getTotalRowCount() {
		return memberMapper.totalRowCount();
	}
}
