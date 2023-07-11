package com.springboot.catchmind.dao;

import com.springboot.catchmind.vo.TabletypeVo;

public class TabletypeDao extends DBConn{
	public int selectRtabletypeNum(String sid, String rtabletype) {
		int num = -1;
		String sql = "select " + rtabletype 
				+ "	from tabletype"
				+ " where sid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			//pstmt.setString(2, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				num = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	
	public TabletypeVo select(String sid) {
		TabletypeVo tabletypeVo = new TabletypeVo();
		String sql = "select SID,ROOFTOP,TERRACE,BAR,DININGHALL,WINDOWSEAT,PRIVATEROOM,RENTAL" + 
				" from tabletype" + 
				" where sid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//System.out.println("rooftop-->" + rs.getInt(2));
				tabletypeVo.setSid(rs.getString(1));
				tabletypeVo.setRooftop(rs.getInt(2));
				tabletypeVo.setTerrace(rs.getInt(3));
				tabletypeVo.setBar(rs.getInt(4));
				tabletypeVo.setDininghall(rs.getInt(5));
				tabletypeVo.setWindowseat(rs.getInt(6));
				tabletypeVo.setPrivateroom(rs.getInt(7));
				tabletypeVo.setRental(rs.getInt(8));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return tabletypeVo;
	}
}
