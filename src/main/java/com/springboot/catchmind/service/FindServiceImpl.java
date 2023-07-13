package com.springboot.catchmind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.vo.MemberVo;

@Service("findService")
public class FindServiceImpl implements FindService  {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberVo getFindId(MemberVo memberVo) {
		return memberDao.findId(memberVo);
	}
	
	@Override
	public MemberVo getFindPassInfo(MemberVo memberVo) {
		return memberDao.findPassInfo(memberVo);
	}

	@Override
	public int getFindPassCheck(MemberVo memberVo) {
		return memberDao.findPassCheck(memberVo);
	}

	@Override
	public int getBeforeMpassUpdate(String mid) {
		return memberDao.beforeMpassUpdate(mid);
	}
	
	@Override
	public int getPassUpdate(String mid, String mpass) {
		return memberDao.passUpdate(mid, mpass);
	}
	
	@Override
	public MemberVo getFindPassUpdateInfo(String mid) {
		return memberDao.findPassUpdateInfo(mid);
	}
}
