package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.dto.SessionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {
//	@Autowired
//	SqlSessionTemplate sqlSession;
	/*
	 *	�뜝�룞�삕泥� �뜝�룞�삕�뜝�룞�삕�듃 �뜝�떥�슱�삕 移닷뜝�룞�삕�듃
	 */
//	public int totalRowCount() {
//		int count = 0;
//		String sql = "SELECT COUNT(*) FROM Member";
//		getPreparedStatement(sql);
//
//		try {
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				count = rs.getInt(1);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return count;
//	}
//
//	/*
//	 *	member �뜝�룞�삕�뜝�룞�삕 - �듅�뜝�룞�삕 mid �뜝�룞�삕�쉶
//	 */
//	public MemberDto select(String mid) {
//		MemberDto memberDto = new MemberDto();
//		String sql = "SELECT MID, MNAME, MEMBERID, MEMAIL, MPHONE FROM MEMBER"
//				+ " WHERE MID=?";
//		getPreparedStatement(sql);
//		try {
//			pstmt.setString(1, mid);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				memberDto.setMid(rs.getString(1));
//				memberDto.setMname(rs.getString(2));
//				memberDto.setMemberId(rs.getString(3));
//				memberDto.setMemail(rs.getString(4));
//				memberDto.setMphone(rs.getString(5));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//
//		return memberDto;
//	}
//
//	/*
//	 *	member �뜝�룞�삕�뜝�룞�삕 - �뜝�룞�삕泥� �뜝�룞�삕�쉶
//	 */
//	public ArrayList<MemberDto> select(int startCount, int endCount) {
//		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
//		String sql = "SELECT RNO, MID, MNAME, MEMBERID, MEMAIL, MPHONE"
//				+ "    FROM(SELECT ROWNUM RNO, MID, MNAME, MEMBERID, MEMAIL, MPHONE"
//				+ "  		  FROM(SELECT MID, MNAME, MEMBERID, MEMAIL, MPHONE"
//				+ "						FROM MEMBER"
//				+ "        				ORDER BY MID))"
//				+ "         WHERE RNO BETWEEN ? AND ?";
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setInt(1, startCount);
//			pstmt.setInt(2, endCount);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				MemberDto memberDto = new MemberDto();
//				memberDto.setRno(rs.getInt(1));
//				memberDto.setMid(rs.getString(2));
//				memberDto.setMname(rs.getString(3));
//				memberDto.setMemberId(rs.getString(4));
//				memberDto.setMemail(rs.getString(5));
//				memberDto.setMphone(rs.getString(6));
//				list.add(memberDto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
//	}
//
//	/*
//	 *	member �뜝�룞�삕�뜝�룞�삕 - �듅�뜝�룞�삕 mid �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃
//	 */
//	public int update(MemberDto memberDto) {
//		String sql = "UPDATE MEMBER"
//				   + "  SET MNAME=?,"
//				   + "      MEMBERID=?,"
//				   + "      MEMAIL=?,"
//				   + "      MPHONE=?"
//				   + "  WHERE MID=?";
//		getPreparedStatement(sql);
//
//		int result = 0;
//		try {
//			pstmt.setString(1, memberDto.getMname());
//			pstmt.setString(2, memberDto.getMemberId());
//			pstmt.setString(3, memberDto.getMemail());
//			pstmt.setString(4, memberDto.getMphone());
//			pstmt.setString(5, memberDto.getMid());
//
//			result = pstmt.executeUpdate();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	public MemberDto nameSelect(String mid) {
//	    MemberDto memberDto = new MemberDto();
//	    String sql = " SELECT mid, mname " +
//	            " FROM MEMBER " +
//	            " WHERE mid = ?";
//
//	    getPreparedStatement(sql);
//
//	    try {
//	        pstmt.setString(1, mid);
//	        rs = pstmt.executeQuery();
//
//	        if (rs.next()) {
//	            memberDto = new MemberDto();
//	            memberDto.setMid(rs.getString(1));
//	            memberDto.setMname(rs.getString(2));
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return memberDto;
//	}

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

	/**
	 * FindPasswordCheck
	 */
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
}
