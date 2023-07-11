package com.springboot.catchmind.dao;

import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.springboot.catchmind.vo.ReservationVo;
import com.google.gson.JsonObject;

public class ReservationDao extends DBConn{
	public int insert_payment(Map<String, String> param, Map<String, Integer> param2) {
		int result = 0;
		String sql = "insert into reservation(rid, rdate, rtime, guestnumber, rmodifydate, rmodifytime, " 
				+ "   	rrequest, rphone, deleteyn, sid, mid, rtabletype, rstatus, reviewyn) " 
				+ "   	values('R_'||LTRIM(TO_CHAR(SEQU_RESERVATION_RID.NEXTVAL,'0000')), ?, ?, ?, ?, ?, "
				+ "		?, ?, 'N', ?, ?, ?, 'ACTIVE', 'N')";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, param.get("rdate"));
			pstmt.setString(2, param.get("rtime"));
			pstmt.setInt(3, param2.get("guestnumber"));
			pstmt.setString(4, param.get("rdate"));
			pstmt.setString(5, param.get("rtime"));
			pstmt.setString(6, param.get("rrequest"));
			pstmt.setString(7, param.get("contact"));
			pstmt.setString(8, param.get("sid"));
			pstmt.setString(9, param.get("mid"));
			pstmt.setString(10, param.get("rtabletype"));
			
			result = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public int insert(Map<String, String> param, int guestnumber) {
		int result = 0;
		String sql = "insert into reservation(rid, rdate, rtime, guestnumber, rmodifydate, rmodifytime, " 
				+ "   	rrequest, rphone, deleteyn, sid, mid, rtabletype, rstatus, reviewyn) " 
				+ "   	values('R_'||LTRIM(TO_CHAR(SEQU_RESERVATION_RID.NEXTVAL,'0000')), ?, ?, ?, ?, ?, "
				+ "		?, ?, 'N', ?, ?, ?, 'ACTIVE', 'N')";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, param.get("rdate"));
			pstmt.setString(2, param.get("rtime"));
			pstmt.setInt(3, guestnumber);
			pstmt.setString(4, param.get("rdate"));
			pstmt.setString(5, param.get("rtime"));
			pstmt.setString(6, param.get("rrequest"));
			pstmt.setString(7, param.get("rphone"));
			pstmt.setString(8, param.get("sid"));
			pstmt.setString(9, param.get("mid"));
			pstmt.setString(10, param.get("rtabletype"));
			
			result = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public JsonObject selectRtime(Map<String, String> param, Map<String, Integer> param2) throws ParseException {
		JsonObject jobj = new JsonObject(); 
		
		String time_open = param.get("rdate") + " " + param.get("sopeninghour");
		String time_close = param.get("rdate") + " " + param.get("sclosinghour");
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date start = transFormat.parse(time_open);
		Date close = transFormat.parse(time_close);
		
		Calendar startTime = Calendar.getInstance();
		startTime.setTime(start); // 시간 설정
		Calendar endTime = Calendar.getInstance();
		endTime.setTime(start); // 시간 설정
		endTime.add(Calendar.HOUR_OF_DAY , 2); // 시간 연산
		Calendar closeTime = Calendar.getInstance();
		closeTime.setTime(close); // 시간 설정
		
		int tableNumForGuest = 0;
		int guestnumber = param2.get("guestnumber");
		
		if(guestnumber % 2 != 0) {
			tableNumForGuest = guestnumber / 2 + 1;
		}
		else {
			tableNumForGuest += guestnumber / 2;
		}
				
		while(!endTime.equals(closeTime)) {
			int sum = 0;
			String sql = "select rid, rdate, rtime, guestnumber, rmodifydate, rmodifytime, "
					+ " rrequest, rphone, deleteyn, sid, mid, rtabletype, rstatus, reviewyn" 
					+ " from reservation" 
					+ " where sid = ? and rtabletype = ? and" 
					+ "    ((to_date(? || ' ' || rmodifytime, 'yyyy-mm-dd HH24:MI') "
					+ "			>= to_date(?, 'yyyy-mm-dd HH24:MI') and" 
					+ "    to_date(? || ' ' || rmodifytime, 'yyyy-mm-dd HH24:MI') "
					+ "			< to_date(?, 'yyyy-mm-dd HH24:MI')) or" 
					+ "    (to_date(? || ' ' || rmodifytime, 'yyyy-mm-dd HH24:MI') + (interval '2' hour)" 
					+ "         > to_date(?, 'yyyy-mm-dd HH24:MI') and" 
					+ "    to_date(? || ' ' || rmodifytime, 'yyyy-mm-dd HH24:MI') + (interval '2' hour)" 
					+ "         < to_date(?, 'yyyy-mm-dd HH24:MI')))";
			
			getPreparedStatement(sql);
			
			try {
				pstmt.setString(1, param.get("sid"));
				//pstmt.setString(1, "S_0004");
				pstmt.setString(2, param.get("rtabletype"));
				pstmt.setString(3, param.get("rdate"));
				pstmt.setString(4, transFormat.format(startTime.getTime()));
				pstmt.setString(5, param.get("rdate"));
				pstmt.setString(6, transFormat.format(endTime.getTime()));
				pstmt.setString(7, param.get("rdate"));
				pstmt.setString(8, transFormat.format(startTime.getTime()));
				pstmt.setString(9, param.get("rdate"));
				pstmt.setString(10, transFormat.format(endTime.getTime()));
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					//System.out.println("rs.getInt(4) ---> " + rs.getInt(4));
					int tableNum = 0;
					if(rs.getInt(4) % 2 != 0) {
						tableNum = rs.getInt(4) / 2 + 1;
						sum += tableNum;
					}
					else {
						sum += rs.getInt(4) / 2;
					}
					//System.out.println("sum ---> " + sum);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			if(sum + tableNumForGuest <= param2.get("rtabletypeNum")) {
				String time = transFormat.format(startTime.getTime()).substring(11);
				//System.out.println("time ---> " + time);
				jobj.addProperty(time, time);
			}
			
			startTime.add(Calendar.MINUTE, 30); // 분 연산
			endTime.add(Calendar.MINUTE, 30); // 분 연산
		}
		
		return jobj;
	}
	
	
	public int selectGuestnumber(Map<String, String> param) throws ParseException {
		String time_open = param.get("rdate") + " " + param.get("sopeninghour");
		String time_close = param.get("rdate") + " " + param.get("sclosinghour");

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date start = transFormat.parse(time_open);
		Date close = transFormat.parse(time_close);

		Calendar startTime = Calendar.getInstance();
		startTime.setTime(start); // 시간 설정
		Calendar endTime = Calendar.getInstance();
		endTime.setTime(start); // 시간 설정
		endTime.add(Calendar.HOUR_OF_DAY , 2); // 시간 연산
		Calendar closeTime = Calendar.getInstance();
		closeTime.setTime(close); // 시간 설정
		int min = Integer.MAX_VALUE;
		
		
		while(!endTime.equals(closeTime)) {
			int sum = 0;
			String sql = "select rid, rdate, rtime, guestnumber, rmodifydate, rmodifytime, "
					+ " rrequest, rphone, deleteyn, sid, mid, rtabletype, rstatus, reviewyn" 
					+ " from reservation" 
					+ " where sid = ? and rtabletype = ? and" 
					+ "    ((to_date(? || ' ' || rmodifytime, 'yyyy-mm-dd HH24:MI') "
					+ "			>= to_date(?, 'yyyy-mm-dd HH24:MI') and" 
					+ "    to_date(? || ' ' || rmodifytime, 'yyyy-mm-dd HH24:MI') "
					+ "			< to_date(?, 'yyyy-mm-dd HH24:MI')) or" 
					+ "    (to_date(? || ' ' || rmodifytime, 'yyyy-mm-dd HH24:MI') + (interval '2' hour)" 
					+ "         > to_date(?, 'yyyy-mm-dd HH24:MI') and" 
					+ "    to_date(? || ' ' || rmodifytime, 'yyyy-mm-dd HH24:MI') + (interval '2' hour)" 
					+ "         < to_date(?, 'yyyy-mm-dd HH24:MI')))";
			
			getPreparedStatement(sql);
			
			try {
				pstmt.setString(1, param.get("sid"));
				//pstmt.setString(1, "S_0004");
				pstmt.setString(2, param.get("rtabletype"));
				pstmt.setString(3, param.get("rdate"));
				//System.out.println("startTime ---> " + transFormat.format(startTime.getTime()));
				pstmt.setString(4, transFormat.format(startTime.getTime()));
				pstmt.setString(5, param.get("rdate"));
				//System.out.println("endTime ---> " + transFormat.format(endTime.getTime()));
				pstmt.setString(6, transFormat.format(endTime.getTime()));
				pstmt.setString(7, param.get("rdate"));
				pstmt.setString(8, transFormat.format(startTime.getTime()));
				pstmt.setString(9, param.get("rdate"));
				pstmt.setString(10, transFormat.format(endTime.getTime()));

				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					//System.out.println("rs.getInt(4) ---> " + rs.getInt(4));
					int tableNum = 0;
					if(rs.getInt(4) % 2 != 0) {
						tableNum = rs.getInt(4) / 2 + 1;
						sum += tableNum;
					}
					else {
						sum += rs.getInt(4) / 2;
					}
					//System.out.println("sum ---> " + sum);
				}
				if(min > sum) {
					min = sum;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			startTime.add(Calendar.MINUTE, 30); // 분 연산
			endTime.add(Calendar.MINUTE, 30); // 분 연산
		}
		
		return min;
	}
	
	
	public ArrayList<String> selectTime(String sid, int guestnumber){
		ArrayList<String> timeList = new ArrayList<String>();
		ArrayList<String> tableList = new ArrayList<String>();
		String sql = "select SID,ROOFTOP,TERRACE,BAR,DININGHALL,WINDOWSEAT,PRIVATEROOM,RENTAL" 
				+ " from tabletype" 
				+ " where sid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()) {
				for(int i = 1; i <= rsmd.getColumnCount(); i++) {
					if(rs.getInt(i) * 2 >= guestnumber) {
						tableList.add(rsmd.getColumnName(i));
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return tableList;
	}
	
	
	public ArrayList<ReservationVo> select(String sid, String rdate){
		ArrayList<ReservationVo> reservationList = new ArrayList<ReservationVo>();
		String sql = "select RID,RDATE,RTIME,GUESTNUMBER,RMODIFYDATE,RMODIFYTIME,RREQUEST,RPHONE,"
				+ " DELETEYN,SID,MID,RTABLETYPE,RSTATUS,REVIEWYN"
				+ " from reservation" 
				+ " where sid = ? and rmodifydate = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			pstmt.setString(2, rdate);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReservationVo reservationVo = new ReservationVo();
				reservationVo.setRid(rs.getString(1));
				reservationVo.setRdate(rs.getString(2));
				reservationVo.setRtime(rs.getString(3));
				reservationVo.setGuestnumber(rs.getString(4));
				reservationVo.setRmodifydate(rs.getString(5));
				reservationVo.setRmodifytime(rs.getString(6));
				reservationVo.setRrequest(rs.getString(7));
				reservationVo.setRphone(rs.getString(8));
				reservationVo.setDeleteyn(rs.getString(9));
				reservationVo.setSid(rs.getString(10));
				reservationVo.setMid(rs.getString(11));
				reservationVo.setRtabletype(rs.getString(12));
				reservationVo.setRstatus(rs.getString(13));
				reservationVo.setReviewyn(rs.getString(14));
				
				reservationList.add(reservationVo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return reservationList;
	}
}
