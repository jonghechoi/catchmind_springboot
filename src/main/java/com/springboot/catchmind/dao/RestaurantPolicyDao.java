package com.springboot.catchmind.dao;

import java.util.ArrayList;

import com.springboot.catchmind.vo.RestaurantPolicyVo;

public class RestaurantPolicyDao extends DBConn{
	public ArrayList<RestaurantPolicyVo> ptitleNotNullList(String sid) {
		ArrayList<RestaurantPolicyVo> ptitleNotNullList = new ArrayList<RestaurantPolicyVo>();
		String sql = "select PID, SID, PTITLE, PCONTENTS, PCREATEDATE, PDELETEYN"
				+ "   from restaurant_policy"
				+ "	  where sid = ? and ptitle is not null";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RestaurantPolicyVo rsPolicyVo = new RestaurantPolicyVo();
				rsPolicyVo.setPid(rs.getString(1));
				rsPolicyVo.setSid(rs.getString(2));
				rsPolicyVo.setPtitle(rs.getString(3));
				rsPolicyVo.setPcontents(rs.getString(4));
				rsPolicyVo.setPcreatedate(rs.getString(5));
				rsPolicyVo.setPdeleteyn(rs.getString(6));
				
				ptitleNotNullList.add(rsPolicyVo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ptitleNotNullList;
	}
	
	
	public ArrayList<RestaurantPolicyVo> select(String sid) {
		ArrayList<RestaurantPolicyVo> rsPolicyList = new ArrayList<RestaurantPolicyVo>();
		String sql = "select pid, sid, ptitle, pcontents, pcreatedate, pdeleteyn" + 
				"	from restaurant_policy" + 
				"	where sid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RestaurantPolicyVo rsPolicyVo = new RestaurantPolicyVo();
				rsPolicyVo.setPid(rs.getString(1));
				rsPolicyVo.setSid(rs.getString(2));
				rsPolicyVo.setPtitle(rs.getString(3));
				rsPolicyVo.setPcontents(rs.getString(4));
				rsPolicyVo.setPcreatedate(rs.getString(5));
				rsPolicyVo.setPdeleteyn(rs.getString(6));
				
				rsPolicyList.add(rsPolicyVo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rsPolicyList;
	}
}
