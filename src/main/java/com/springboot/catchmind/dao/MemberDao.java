package com.springboot.catchmind.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.SessionVo;

@Repository
public class MemberDao extends DBConn {
	@Autowired
	private SqlSessionTemplate sqlSession;
	/*
	 *	�뜝�룞�삕泥� �뜝�룞�삕�뜝�룞�삕�듃 �뜝�떥�슱�삕 移닷뜝�룞�삕�듃
	 */
	public int totalRowCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM Member";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				count = rs.getInt(1);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;		
	}
	
	/*
	 *	member �뜝�룞�삕�뜝�룞�삕 - �듅�뜝�룞�삕 mid �뜝�룞�삕�쉶
	 */
	public MemberVo select(String mid) {
		MemberVo memberVo = new MemberVo();
		String sql = "SELECT MID, MNAME, MEMBERID, MEMAIL, MPHONE FROM MEMBER"
				+ " WHERE MID=?";
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberVo.setMid(rs.getString(1));
				memberVo.setMname(rs.getString(2));
				memberVo.setMemberId(rs.getString(3));
				memberVo.setMemail(rs.getString(4));
				memberVo.setMphone(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return memberVo;
	}

	/*
	 *	member �뜝�룞�삕�뜝�룞�삕 - �뜝�룞�삕泥� �뜝�룞�삕�쉶
	 */
	public ArrayList<MemberVo> select(int startCount, int endCount) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT RNO, MID, MNAME, MEMBERID, MEMAIL, MPHONE"
				+ "    FROM(SELECT ROWNUM RNO, MID, MNAME, MEMBERID, MEMAIL, MPHONE" 
				+ "  		  FROM(SELECT MID, MNAME, MEMBERID, MEMAIL, MPHONE"
				+ "						FROM MEMBER"
				+ "        				ORDER BY MID))"
				+ "         WHERE RNO BETWEEN ? AND ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setRno(rs.getInt(1));
				memberVo.setMid(rs.getString(2));
				memberVo.setMname(rs.getString(3));
				memberVo.setMemberId(rs.getString(4));
				memberVo.setMemail(rs.getString(5));
				memberVo.setMphone(rs.getString(6));
				list.add(memberVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/*
	 *	member �뜝�룞�삕�뜝�룞�삕 - �듅�뜝�룞�삕 mid �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃
	 */
	public int update(MemberVo memberVo) {
		String sql = "UPDATE MEMBER" 
				   + "  SET MNAME=?," 
				   + "      MEMBERID=?," 
				   + "      MEMAIL=?," 
				   + "      MPHONE=?" 
				   + "  WHERE MID=?";
		getPreparedStatement(sql);
		
		int result = 0;
		try {
			pstmt.setString(1, memberVo.getMname());
			pstmt.setString(2, memberVo.getMemberId());
			pstmt.setString(3, memberVo.getMemail());
			pstmt.setString(4, memberVo.getMphone());
			pstmt.setString(5, memberVo.getMid());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public MemberVo nameSelect(String mid) {
	    MemberVo memberVo = new MemberVo();
	    String sql = " SELECT mid, mname " +
	            " FROM MEMBER " +
	            " WHERE mid = ?";

	    getPreparedStatement(sql);

	    try {
	        pstmt.setString(1, mid);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            memberVo = new MemberVo();
	            memberVo.setMid(rs.getString(1));
	            memberVo.setMname(rs.getString(2));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return memberVo;
	}

	/**
	 * ADMIN/SHOP LoginType Check
	 * ADMIN/SHOP 로그인타입 체크
	 */
	public int roleIdCheck(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.roleIdCheck", memberVo);
	}
	
	/**
	 * Member ID Check
	 * 로그인ID 체크
	 */
	public int loginIdCheck(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.loginIdCheck", memberVo);
	}
	/**
	 * kakaoLogin
	 */
	public SessionVo kakaoLogin(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.kakaoLogin", memberVo);
	}

	/**
	 * kakaoIdCheck
	 */
	public int kakaoIdCheck(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.kakaoIdCheck", memberVo);
	}
	
	/**
	 * kakaoJoin
	 */
	public int kakaoJoin(MemberVo memberVo) {
		return sqlSession.insert("mapper.member.kakaoJoin", memberVo);
	}
	
	/**
	 * PassUpdate
	 */
	public int passUpdate(String mid, String mpass) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("mid", mid);
		param.put("mpass", mpass);
		
		return sqlSession.update("mapper.find.passUpdate", param);
	}
	
	/**
	 * FindPassUpdateInfo
	 */
	public MemberVo findPassUpdateInfo(String mid) {
		return sqlSession.selectOne("mapper.find.findPassUpdateInfo", mid);
	}
	
	/**
	 *  BeforeMpassUpdate
	 */
	public int beforeMpassUpdate(String mid) {
		return sqlSession.update("mapper.find.beforeMpassUpdate", mid);
	}
	
	/**
	 * FindPassInfo
	 */
	public MemberVo findPassInfo(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.find.findPassInfo", memberVo);
	}
	
	/**
	 * FindPasswordCheck
	 */
	public int findPassCheck(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.find.findPassCheck", memberVo);
	}
	
	/**
	 * FindID 
	 * 占쏙옙占싱듸옙 찾占쏙옙 
	 */
	public MemberVo findId(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.find.findId", memberVo);
	}
	
	/**
	 *  Login - Shop / Admin
	 * 占싸깍옙占쏙옙 - Shop / Admin
	 */
	public SessionVo roleLogin(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.roleLogin", memberVo);
	}
	
	/**
	 * Login - Member
	 * 占싸깍옙占쏙옙 - 占쏙옙占�
	 */
	public SessionVo memberLogin(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.memberLogin", memberVo);
	}
	
	/**
	 * MemberJoin
	 * 회占쏙옙占쏙옙占쏙옙
	 */
	public int join(MemberVo memberVo) {
		return sqlSession.insert("mapper.member.join", memberVo);
	}
	
	/**
	 * Duplicate check
	 * 회占쏙옙占쏙옙占쏙옙 占쌩븝옙체크
	 */
	public int idCheck(String memberId) {
		return sqlSession.selectOne("mapper.member.idCheck", memberId);
	}
}
