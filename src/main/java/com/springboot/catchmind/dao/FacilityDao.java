package com.springboot.catchmind.dao;

import java.lang.reflect.Field;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import com.springboot.catchmind.vo.FacilityVo;

public class FacilityDao extends DBConn{
	public FacilityVo select(String sid) {
		FacilityVo facilityVo = new FacilityVo();
		//ResultSetMetaData rsmd;
		String sql = "select sid, parking, valet, corkage, adultonly, sommelier, lettering, rentals,"
				+ " parkingdesc, valetdesc, corkagedesc, adultonlydesc, sommelierdesc, letteringdesc, rentalsdesc"
				+ " from facility"
				+ " where sid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			//rsmd = rs.getMetaData();
            
			while(rs.next()) {
				facilityVo.setSid(rs.getString(1));
				facilityVo.setParking(rs.getInt(2));
				facilityVo.setValet(rs.getInt(3));
				facilityVo.setCorkage(rs.getInt(4));
				facilityVo.setAdultonly(rs.getInt(5));
				facilityVo.setSommelier(rs.getInt(6));
				facilityVo.setLettering(rs.getInt(7));
				facilityVo.setRentals(rs.getInt(8));
				facilityVo.setParkingdesc(rs.getString(9));
				facilityVo.setValetdesc(rs.getString(10));
				facilityVo.setCorkagedesc(rs.getString(11));
				facilityVo.setAdultonlydesc(rs.getString(12));
				facilityVo.setSommelierdesc(rs.getString(13));
				facilityVo.setLetteringdesc(rs.getString(14));
				facilityVo.setRentalsdesc(rs.getString(15));
			}
			
//			Object obj = facilityVo;
//			int colNum = 0;
//			// 반복문을 이용하여 해당 클래스에 정의된 필드를 가져옵니다.
//            for (Field field : obj.getClass().getDeclaredFields()) {
//            	colNum++;
//                field.setAccessible(true);
//                if((field.getInt(obj) == 1) || !(field.get(obj).equals(""))) {
//					Object value = rsmd.getColumnName(colNum); // 필드에 해당하는 값을 가져옵니다.
//					System.out.println("field : "+field.getName()+" | value : " value);
//                }
//            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return facilityVo;
	}
}
