package com.springboot.catchmind.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springboot.catchmind.vo.NoticeVo;

@Repository
public class NoticeDao extends DBConn {
	/*
	 *	��ü ����Ʈ �ο� ī��Ʈ
	 */
	public int totalRowCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM NOTICE";
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
	 * ��ü ����Ʈ ��ȸ - select()
	 */
	public ArrayList<NoticeVo> select(int startCount, int endCount) {
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		String sql = "SELECT RNO, NTITLE, NHITS, NCREATEDATE, NID"  
				   + " FROM (SELECT ROWNUM RNO, NTITLE, NHITS, to_char(NCREATEDATE, 'YYYY-MM-DD') NCREATEDATE, NID" 
		           + "          FROM (SELECT NTITLE, NHITS, NCREATEDATE, NID" 
		           + "		               FROM NOTICE" 
		           + "		               ORDER BY NCREATEDATE DESC))" 
		           + "      WHERE RNO BETWEEN ? AND ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, startCount);
			pstmt.setInt(2, endCount);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setRno(rs.getInt(1));
				noticeVo.setNtitle(rs.getString(2));
				noticeVo.setNhits(rs.getInt(3));
				noticeVo.setNcreatedate(rs.getString(4));
				noticeVo.setNid(rs.getString(5));
				
				list.add(noticeVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * Ư�� ���� ��ȸ - select(nid)
	 */
	public NoticeVo select(String nid) {
		String sql = "SELECT NTITLE, NCONTENTS, NHITS, NCREATEDATE, NID"
				   + " FROM NOTICE"
				   + " WHERE NID=?";
		getPreparedStatement(sql);
		
		NoticeVo noticeVo = new NoticeVo();
		try {
			pstmt.setString(1, nid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				noticeVo.setNtitle(rs.getString(1));
				noticeVo.setNcontents(rs.getString(2));
				noticeVo.setNhits(rs.getInt(3));
				noticeVo.setNcreatedate(rs.getString(4));
				noticeVo.setNid(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return noticeVo;
	}
	
	/*
	 * ���� ������Ʈ - update(noticeVo)
	 */
	public int update(NoticeVo noticeVo) {
		String sql = "UPDATE NOTICE"
				   + " SET NTITLE=?,"
				   + "     NCONTENTS=?,"
				   + "     NMODIFYDATE=sysdate"
				   + " WHERE NID=?";
		getPreparedStatement(sql);
		
		int result = 0;
		try {
			pstmt.setString(1, noticeVo.getNtitle());
			pstmt.setString(2, noticeVo.getNcontents());
			pstmt.setString(3, noticeVo.getNid());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * ���� ���� - update(nid)
	 */
	public int delete(String nid) {
		String sql = "DELETE FROM NOTICE"
				   + " WHERE NID=?";
		getPreparedStatement(sql);
		
		int result = 0;
		try {
			pstmt.setString(1, nid);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * ���� �߰� - upload(noticeVo)
	 */
	public int upload(NoticeVo noticeVo) {
		String sql = "INSERT INTO NOTICE(NID, NTITLE, NCONTENTS, NCREATEDATE, NDELETEYN)"
				 + "  VALUES('N_'||LTRIM(TO_CHAR(SEQU_NOTICE_NID.NEXTVAL, '0000')), ?, ?, SYSDATE, 'N')";
		getPreparedStatement(sql);

		int result = 0;
		try {
			pstmt.setString(1, noticeVo.getNtitle());
			pstmt.setString(2, noticeVo.getNcontents());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	
}
