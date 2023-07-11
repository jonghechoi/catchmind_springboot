package com.springboot.catchmind.service;

import com.springboot.catchmind.vo.MemberVo;

public interface FindService {
	MemberVo getFindId(MemberVo memberVo);
	MemberVo getFindPassInfo(MemberVo memberVo);
	int getBeforeMpassUpdate(String mid);
	int getPassUpdate(String mid, String mpass);
	MemberVo getFindPassUpdateInfo(String mid);
}
