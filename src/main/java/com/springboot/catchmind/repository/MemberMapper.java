package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.dto.SessionDto;
import org.apache.ibatis.annotations.Mapper;
import com.springboot.catchmind.dao.DBConn;
import com.springboot.catchmind.dto.PageDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
	List<MemberDto> selectList(PageDto pageDto);
	MemberDto select(String mid);
	
	 /* ADMIN/SHOP 로그인타입 체크 */
	int roleIdCheck(MemberDto memberDto);

	 /* Login ID Check */
	int loginIdCheck(MemberDto memberDto);

	 /* kakaoLogin */
	SessionDto kakaoLogin(MemberDto memberDto);

	/* kakaoIdCheck */
	int kakaoIdCheck(MemberDto memberDto);

	 /* kakaoJoin */
	int kakaoJoin(MemberDto memberDto);

	 /* PassUpdate */
	int passUpdate(Map<String, String> param);

	 /* FindPassUpdate */
	MemberDto findPassUpdateInfo(String mid);

	 /*  BeforeMpassUpdate */
	int beforeMpassUpdate(String mid);

	 /* FindPassInfo */
	MemberDto findPassInfo(MemberDto memberDto);


	/* FindPasswordCheck */

	int findPassCheck(MemberDto memberDto);

	 /* FindID */
	MemberDto findId(MemberDto memberDto);

	 /*  Login - Shop / Admin */
	SessionDto roleLogin(MemberDto memberDto);

	 /* Login - Member */
	SessionDto memberLogin(MemberDto memberDto);

	 /* MemberJoin */
	int join(MemberDto memberDto);

	 /* Duplicate check */
	int idCheck(String memberId);

	int totalRowCount();
}
