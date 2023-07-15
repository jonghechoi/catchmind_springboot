package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FindServiceImpl {
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberDto getFindId(MemberDto memberDto) {
		return memberMapper.findId(memberDto);
	}
	
	public MemberDto getFindPassInfo(MemberDto memberDto) {
		return memberMapper.findPassInfo(memberDto);
	}

	public int getFindPassCheck(MemberDto memberDto) {
		return memberMapper.findPassCheck(memberDto);
	}

	public int getBeforeMpassUpdate(String mid) {
		return memberMapper.beforeMpassUpdate(mid);
	}

	public int getPassUpdate(String mid, String mpass) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("mid", mid);
		param.put("mpass", mpass);
		return memberMapper.passUpdate(param);
	}
	
	public MemberDto getFindPassUpdateInfo(String mid) {
		return memberMapper.findPassUpdateInfo(mid);
	}
}
