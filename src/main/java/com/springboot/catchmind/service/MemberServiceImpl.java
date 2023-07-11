package com.springboot.catchmind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.SessionVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int getRoleIdCheck(MemberVo memberVo) {
		return memberDao.roleIdCheck(memberVo);
	}
	
	@Override
	public int getLoginIdCheck(MemberVo memberVo) {
		return memberDao.loginIdCheck(memberVo);
	}
	
	@Override
	public int getIdCheck(String memberId) {
		return memberDao.idCheck(memberId);
	}
	
	@Override
	public int getJoin(MemberVo memberVo) {
		return memberDao.join(memberVo);
	}
	
	@Override
	public SessionVo getMemberLogin(MemberVo memberVo) {
		return memberDao.memberLogin(memberVo);
	}
	
	@Override
	public SessionVo getRoleLogin(MemberVo memberVo) {
		return memberDao.roleLogin(memberVo);
	}
	
	@Override
	public int getKakaoJoin(MemberVo memberVo) {
		return memberDao.kakaoJoin(memberVo);
	}
	
	@Override
	public int getKakaoIdCheck(MemberVo memberVo) {
		return memberDao.kakaoIdCheck(memberVo);
	}
	
	@Override
	public int getUpdate(MemberVo memberVo) {
		return memberDao.update(memberVo);
	}
	
	@Override
	public int getTotalRowCount() {
		return memberDao.totalRowCount();
	}
	
	@Override
	public SessionVo getKakaoLogin(MemberVo memberVo) {
		return memberDao.kakaoLogin(memberVo);
	}
	
}
