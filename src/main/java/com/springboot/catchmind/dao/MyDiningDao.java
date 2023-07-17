package com.springboot.catchmind.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.catchmind.vo.ScheduledVo;

@Repository
public class MyDiningDao extends DBConn {
	
//	@Autowired
//	private SqlSessionTemplate sqlSession;
//
//	/**
//	 * deleteBookmark
//	 */
//	public int deleteBookmark(String mid, String sid) {
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("mid", mid);
//		param.put("sid", sid);
//
//		return sqlSession.delete("mapper.mydining.deleteBookmark", param);
//	}
//
//	/**
//	 * insertBookmark
//	 */
//	public int insertBookmark(String mid, String sid) {
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("mid", mid);
//		param.put("sid", sid);
//
//		return sqlSession.insert("mapper.mydining.insertBookmark", param);
//	}
//
//	/**
//	 * informationBookmark
//	 */
//	public int bookmarkResult(String mid, String sid) {
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("mid", mid);
//		param.put("sid", sid);
//
//		return sqlSession.selectOne("mapper.mydining.bookmarkResult", param);
//	}
//
//	/**
//	 * UpdateDeleteYN - ���� ��� 'Y'
//	 */
//	public int updateDeleteYN(String rid) {
//		return sqlSession.update("mapper.mydining.updateDeleteYN", rid);
//	}
//
//	/**
//	 * visitedTotalRowCount - �ο� ī��Ʈ �޾ƿ���
//	 */
//	public int totalRowCount(String mid) {
//			int count = 0;
//			String sql = "select count(*)\r\n" +
//					"		from reservation\r\n" +
//					"		where mid = ? and rstatus = 'COMPLETED'";
//			getPreparedStatement(sql);
//
//			try {
//				pstmt.setString(1, mid);
//				rs = pstmt.executeQuery();
//				while(rs.next()) {
//					count = rs.getInt(1);
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			return count;
//	}
//
//
// 	/**
//	 * RSTATUS ACTIVED -> COMPLETED ����
//	 */
//	public void updateStatus() {
//		sqlSession.update("mapper.mydining.updateStatus");
//	}
////		String sql = "UPDATE RESERVATION SET RSTATUS = 'COMPLETED' WHERE to_date(rdate,'yyyy/mm/dd') < to_date(sysdate,'yyyy/mm/dd') AND RSTATUS = 'ACTIVE'" ;
////		getPreparedStatement(sql);
////
////		try {
////			pstmt.executeUpdate();
////			System.out.println("������Ʈ");
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////	}
//
//	/**
//	 * �湮 �Ϸ��� �Ĵ� ����Ʈ ����¡ ó�� - mydining_visited.do
//	 */
//	public ArrayList<ScheduledVo> visitedSelect(Map<String,String> param) {
//		ArrayList<ScheduledVo> list = new ArrayList<ScheduledVo>();
//		String sql = "SELECT RNO, MID, SID, RID, MEMBERID, MNAME, TEL, MPHONE,SNAME,SLOCSHORT, RDATE, RTIME, GUESTNUMBER, RPHONE, RSTATUS, REVIEWYN, SMPHOTO, DELETEYN\r\n" +
//				" FROM(select ROWNUM RNO,MID,SID,RID, MEMBERID, MNAME, TEL, MPHONE,SNAME,SLOCSHORT, RDATE, RTIME, GUESTNUMBER, RPHONE, RSTATUS, REVIEWYN, SMPHOTO, DELETEYN\r\n" +
//				" from(select M.MID MID,S.SID SID,R.RID RID, M.MEMBERID MEMBERID, M.MNAME MNAME, M.TEL TEL, M.MPHONE MPHONE, S.SNAME SNAME,\r\n" +
//				"				S.SLOCSHORT SLOCSHORT, to_char(R.RDATE,'yyyy-mm-dd') RDATE, R.RTIME RTIME, R.GUESTNUMBER GUESTNUMBER, R.RPHONE RPHONE, R.RSTATUS RSTATUS, R.REVIEWYN, S.SMPHOTO SMPHOTO, R.DELETEYN DELETEYN\r\n" +
//				"				from MEMBER M, SHOP S, RESERVATION R\r\n" +
//				"				WHERE R.MID = M.MID AND R.SID = S.SID\r\n" +
//				"				ORDER BY RDATE DESC, RTIME desc)\r\n" +
//				"  WHERE MID = ? AND RSTATUS = 'COMPLETED' AND DELETEYN = 'N')\r\n" +
//				"  WHERE RNO BETWEEN ? AND ?";
//		getPreparedStatement(sql);
//
//		try {
//			pstmt.setString(1, param.get("mid"));
//			pstmt.setString(2, param.get("startCount"));
//			pstmt.setString(3, param.get("endCount"));
//
//			rs = pstmt.executeQuery();
//
//			while(rs.next()) {
//				ScheduledVo scheduledVo = new ScheduledVo();
//
//				scheduledVo.setRno(rs.getInt(1));
//				scheduledVo.setMid(rs.getString(2));
//				scheduledVo.setSid(rs.getString(3));
//				scheduledVo.setRid(rs.getString(4));
//				scheduledVo.setMemberId(rs.getString(5));
//				scheduledVo.setMname(rs.getString(6));
//				scheduledVo.setTel(rs.getString(7));
//				scheduledVo.setMphone(rs.getString(8));
//				scheduledVo.setSname(rs.getString(9));
//				scheduledVo.setSlocShort(rs.getString(10));
//				scheduledVo.setRdate(rs.getString(11));
//				scheduledVo.setRtime(rs.getString(12));
//				scheduledVo.setGuestNumber(rs.getInt(13));
//				scheduledVo.setRphone(rs.getString(14));
//				scheduledVo.setRstatus(rs.getString(15));
//				scheduledVo.setReviewYN(rs.getString(16));
//				scheduledVo.setSmphoto(rs.getString(17));
//
//				list.add(scheduledVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
//	}
//
//	/**
//	 * �湮 �Ϸ��� �Ĵ� ����Ʈ ������ - mydining_visited.do
//	 */
//	public ArrayList<ScheduledVo> visited(String mid) {
//
//		List<ScheduledVo> list = sqlSession.selectList("mapper.mydining.visited", mid);
//
//		return (ArrayList<ScheduledVo>)list;
//	}
////		ArrayList<ScheduledVo> visitedList = new ArrayList<ScheduledVo>();
////		String sql = "select MID,SID,RID, MEMBERID, MNAME, TEL, MPHONE,SNAME,SLOCSHORT, RDATE, RTIME, GUESTNUMBER, RPHONE, RSTATUS, REVIEWYN, SMPHOTO\r\n" +
////				"  from(select M.MID MID,S.SID SID,R.RID RID, M.MEMBERID MEMBERID, M.MNAME MNAME, M.TEL TEL, M.MPHONE MPHONE, S.SNAME SNAME,\r\n" +
////				"      S.SLOCSHORT SLOCSHORT, to_char(R.RDATE,'yyyy-mm-dd') RDATE, R.RTIME RTIME, R.GUESTNUMBER GUESTNUMBER, R.RPHONE RPHONE, R.RSTATUS RSTATUS, R.REVIEWYN, S.SMPHOTO SMPHOTO\r\n" +
////				"      from MEMBER M, SHOP S, RESERVATION R\r\n" +
////				"      WHERE R.MID = M.MID AND R.SID = S.SID\r\n" +
////				"      ORDER BY RDATE DESC, RTIME desc)\r\n" +
////				" WHERE MID = ? AND RSTATUS = 'COMPLETED'";
////		getPreparedStatement(sql);
////
////		try {
////			pstmt.setString(1, mid);
////			rs = pstmt.executeQuery();
////
////			while(rs.next()) {
////				ScheduledVo scheduledVo = new ScheduledVo();
////
////				scheduledVo.setMid(rs.getString(1));
////				scheduledVo.setSid(rs.getString(2));
////				scheduledVo.setRid(rs.getString(3));
////				scheduledVo.setMemberId(rs.getString(4));
////				scheduledVo.setMname(rs.getString(5));
////				scheduledVo.setTel(rs.getString(6));
////				scheduledVo.setMphone(rs.getString(7));
////				scheduledVo.setSname(rs.getString(8));
////				scheduledVo.setSlocShort(rs.getString(9));
////				scheduledVo.setRdate(rs.getString(10));
////				scheduledVo.setRtime(rs.getString(11));
////				scheduledVo.setGuestNumber(rs.getInt(12));
////				scheduledVo.setRphone(rs.getString(13));
////				scheduledVo.setRstatus(rs.getString(14));
////				scheduledVo.setReviewYN(rs.getString(15));
////				scheduledVo.setSmphoto(rs.getString(16));
////
////				visitedList.add(scheduledVo);
////			}
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		return visitedList;
////	}
//
//	/**
//	 * ���� ������ �Ĵ� ���� ������ - information.do
//	 */
//	public ScheduledVo information(String mid, String sid, String rid) {
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("mid", mid);
//		param.put("sid", sid);
//		param.put("rid", rid);
//
//		ScheduledVo scheduledVo = sqlSession.selectOne("mapper.mydining.information", param);
//
//		int check = sqlSession.selectOne("mapper.mydining.fcount", param);
//
//		if(check == 0) {
//			scheduledVo.setFcheck(String.valueOf('N'));
//		}else {
//			scheduledVo.setFcheck(String.valueOf('Y'));
//		}
//
//		return scheduledVo;
//	}
////		ScheduledVo scheduledVo = new ScheduledVo();
////
////		String sql = "select SID, RID, MID, RDATE, RTIME, GUESTNUMBER, MNAME, SNAME, SLOC, SLOCSHORT, SINTRO, SPHONE, SOPENINGHOUR, SCLOSINGHOUR, SCLOSINGDATE, SDEPOSIT, MPHONE, SMPHOTO \r\n" +
////				"  from(select S.SID SID, M.MID MID, R.RID RID, to_char(R.RDATE,'yyyy-mm-dd') RDATE, R.RTIME RTIME, R.GUESTNUMBER GUESTNUMBER,\r\n" +
////				"        M.MNAME MNAME, S.SNAME SNAME, S.SLOC SLOC, S.SLOCSHORT SLOCSHORT, S.SINTRO SINTRO, S.SPHONE SPHONE,\r\n" +
////				"        S.SOPENINGHOUR SOPENINGHOUR, S.SCLOSINGHOUR SCLOSINGHOUR, S.SCLOSINGDATE SCLOSINGDATE, S.SDEPOSIT SDEPOSIT,  M.MPHONE MPHONE, S.SMPHOTO SMPHOTO\r\n" +
////				"        from SHOP S, RESERVATION R, MEMBER M\r\n" +
////				"        WHERE R.SID = S.SID AND R.MID = M.MID)\r\n" +
////				" WHERE MID = ? AND SID = ?";
////		getPreparedStatement(sql);
////
////		try {
////			pstmt.setString(1, mid);
////			pstmt.setString(2, sid);
////			rs = pstmt.executeQuery();
////
////			while(rs.next()) {
////				scheduledVo.setSid(rs.getString(1));
////				scheduledVo.setRid(rs.getString(2));
////				scheduledVo.setMid(rs.getString(3));
////				scheduledVo.setRdate(rs.getString(4));
////				scheduledVo.setRtime(rs.getString(5));
////				scheduledVo.setGuestNumber(rs.getInt(6));
////				scheduledVo.setMname(rs.getString(7));
////				scheduledVo.setSname(rs.getString(8));
////				scheduledVo.setSloc(rs.getString(9));
////				scheduledVo.setSlocShort(rs.getString(10));
////				scheduledVo.setSintro(rs.getString(11));
////				scheduledVo.setSphone(rs.getString(12));
////				scheduledVo.setSopeningHour(rs.getString(13));
////				scheduledVo.setSclosingHour(rs.getString(14));
////				scheduledVo.setSclosingDate(rs.getString(15));
////				scheduledVo.setSdeposit(rs.getInt(16));
////				scheduledVo.setMphone(rs.getString(17));
////				scheduledVo.setSmphoto(rs.getString(18));
////
////			}
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		return scheduledVo;
////	}
//
//	/**
//	 * ���� ������ �Ĵ� ����Ʈ ��� - mydining_scheduled.do
//	 */
//	public ArrayList<ScheduledVo> scheduled(String mid) {
//		List<ScheduledVo> list = sqlSession.selectList("mapper.mydining.scheduled", mid);
//
//		return (ArrayList<ScheduledVo>)list;
//	}
////		ArrayList<ScheduledVo> list = new ArrayList<ScheduledVo>();
////
////		String sql = "select MID,SID,RID, MEMBERID, MNAME, TEL, MPHONE,SNAME,SLOCSHORT, RDATE, RTIME, GUESTNUMBER, RPHONE, RSTATUS, SMPHOTO\r\n" +
////				"  from(select M.MID MID,S.SID SID,R.RID RID, M.MEMBERID MEMBERID, M.MNAME MNAME, M.TEL TEL, M.MPHONE MPHONE, S.SNAME SNAME,\r\n" +
////				"      S.SLOCSHORT SLOCSHORT, to_char(R.RDATE,'yyyy-mm-dd') RDATE, R.RTIME RTIME, R.GUESTNUMBER GUESTNUMBER, R.RPHONE RPHONE, R.RSTATUS RSTATUS, S.SMPHOTO SMPHOTO\r\n" +
////				"      from MEMBER M, SHOP S, RESERVATION R\r\n" +
////				"      WHERE R.MID = M.MID AND R.SID = S.SID\r\n" +
////				"      ORDER BY RDATE DESC, RTIME desc)\r\n" +
////				" WHERE MID = ? AND RSTATUS = 'ACTIVE'";
////		getPreparedStatement(sql);
////
////		try {
////			pstmt.setString(1, mid);
////			rs = pstmt.executeQuery();
////
////			while(rs.next()) {
////				ScheduledVo scheduledVo = new ScheduledVo();
////
////				scheduledVo.setMid(rs.getString(1));
////				scheduledVo.setSid(rs.getString(2));
////				scheduledVo.setRid(rs.getString(3));
////				scheduledVo.setMemberId(rs.getString(4));
////				scheduledVo.setMname(rs.getString(5));
////				scheduledVo.setTel(rs.getString(6));
////				scheduledVo.setMphone(rs.getString(7));
////				scheduledVo.setSname(rs.getString(8));
////				scheduledVo.setSlocShort(rs.getString(9));
////				scheduledVo.setRdate(rs.getString(10));
////				scheduledVo.setRtime(rs.getString(11));
////				scheduledVo.setGuestNumber(rs.getInt(12));
////				scheduledVo.setRphone(rs.getString(13));
////				scheduledVo.setRstatus(rs.getString(14));
////				scheduledVo.setSmphoto(rs.getString(15));
////
////				list.add(scheduledVo);
////
////			}
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return list;
////	}

}
