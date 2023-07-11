package com.springboot.catchmind.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.catchmind.vo.BookingVo;
import com.springboot.catchmind.vo.FacilityVo;
import com.springboot.catchmind.vo.SearchVo;
import com.springboot.catchmind.vo.SessionVo;
import com.springboot.catchmind.vo.ShopVo;

@Repository
public class ShopDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Map<String, String> priceInString(String sid) {
		Map<String, String> param = new HashMap<String, String>();
		String sql = "select to_char(sdeposit, 'L999,999') sdeposit, "
				+ " to_char(smealfee, 'L999,999') smealfee, "
				+ " to_char(lunch, 'L999,999') lunch, to_char(dinner, 'L999,999') dinner"
				+ " from shop"
				+ " where sid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				param.put("deposit", rs.getString(1));
				param.put("mealfee", rs.getString(2));
				param.put("lunch", rs.getString(3));
				param.put("dinner", rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return param;
	}
	
	
	public ShopVo select(@RequestParam("sid") String sid) {
		ShopVo shopVo = new ShopVo();
		String sql = "select sid, roleid, screatedate, sdeleteyn, aconfirmyn, aconfirmfinalyn, "
				+ " sconfirmyn, spass, sname, sphone, sloc, slocx, slocy, slocshort, sintro, "
				+ " smodifydate, sclosingdate, sopeninghour, sclosinghour,  "
				+ " sdeposit, smealfee, lunch, dinner, swebsite, sfoodstyle, smphoto" 
				+ "	from shop "
				+ " where sid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				shopVo.setSid(rs.getString(1));
				shopVo.setRoleid(rs.getString(2));
				shopVo.setScreatedate(rs.getString(3));
				shopVo.setSdeleteyn(rs.getString(4));
				shopVo.setAconfirmyn(rs.getString(5));
				shopVo.setAconfirmfinalyn(rs.getString(6));
				shopVo.setSconfirmyn(rs.getString(7));
				shopVo.setSpass(rs.getString(8));
				shopVo.setSname(rs.getString(9));
				shopVo.setSphone(rs.getString(10));
				shopVo.setSloc(rs.getString(11));
				shopVo.setSlocx(rs.getString(12));
				shopVo.setSlocy(rs.getString(13));
				shopVo.setSlocshort(rs.getString(14));
				shopVo.setSintro(rs.getString(15));
				shopVo.setSmodifydate(rs.getString(16));
				shopVo.setSclosingdate(rs.getString(17));
				shopVo.setSopeninghour(rs.getString(18));
				shopVo.setSclosinghour(rs.getString(19));
				shopVo.setSdeposit(rs.getInt(20));
				shopVo.setSmealfee(rs.getInt(21));
				shopVo.setLunch(rs.getInt(22));
				shopVo.setDinner(rs.getInt(23));
				shopVo.setSwebsite(rs.getString(24));
				shopVo.setSfoodstyle(rs.getString(25));
				shopVo.setSmphoto(rs.getString(26));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return shopVo;
	}
	
	/*
	 *	shop 占쌍울옙 占쏙옙占쏙옙 占쏙옙占�(1占쏙옙) - insert(shopVo)
	 */
	public int insert(ShopVo shopVo) {
		int result = 0;
		String sqlSpass = "SELECT DBMS_RANDOM.STRING('L',10)||CEIL(DBMS_RANDOM.VALUE(10000,99999)) SPASS FROM DUAL";
		getPreparedStatement(sqlSpass);
		String spass = "";
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				spass = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String sqlSpassCheck = "SELECT COUNT(*) FROM SHOP WHERE SPASS=?";
		getPreparedStatement(sqlSpassCheck);	
		int spassCheck = 0;
		try {
			pstmt.setString(1, spass);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				spassCheck = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(spassCheck == 0) {
			String sql = "INSERT INTO SHOP(SID, ROLEID, SCREATEDATE, SDELETEYN, ACONFIRMYN, ACONFIRMFINALYN, SCONFIRMYN, SPASS, SNAME, SPHONE, SFOODSTYLE, SLOC, SLOCX, SLOCY, SLOCSHORT, SMPHOTO)"
					+ "   VALUES('S_'||LTRIM(TO_CHAR(SEQU_SHOP_SID.NEXTVAL,'0000')), 'SHOP', SYSDATE, 'N', 'Y', 'N', 'N', "
					+ "         ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			getPreparedStatement(sql);
			try {
				pstmt.setString(1, spass);
				pstmt.setString(2, shopVo.getSname());
				pstmt.setString(3, shopVo.getSphone());
				pstmt.setString(4, shopVo.getSfoodstyle());
				pstmt.setString(5, shopVo.getSloc());
				pstmt.setString(6, shopVo.getSlocx());
				pstmt.setString(7, shopVo.getSlocy());
				pstmt.setString(8, shopVo.getSlocshort());
				pstmt.setString(9, shopVo.getSmphoto());
				result = pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			this.insert(shopVo);
		}
		return result;
	}
	
	/*
	 *	shop - insert(shopVo)
	 */
	public int detailInsert(ShopVo shopVo) {
		return sqlSession.update("mapper.shop.detailInsert", shopVo);
	}
	
	/*
	 *	shop detail info update
	 */
	public int detailUpdate(ShopVo shopVo) {
		return sqlSession.update("mapper.shop.detailUpdate", shopVo);
	}
	
	/*
	 *	shop 占쏙옙占쏙옙占쏙옙 facility 占쏙옙占쏙옙 占쏙옙占�(3占쏙옙) - facilityUpdate(shopVo)
	 */
	public int facilityUpdate(FacilityVo facilityVo) {
		int facilityExisting = sqlSession.selectOne("mapper.shop.facilityCheck", facilityVo.getSid());
		
		int result = 0;
		if(facilityExisting == 0) {
			result = sqlSession.insert("mapper.shop.facilityInsert", facilityVo);
		}else {
			result = sqlSession.update("mapper.shop.facilityUpdate", facilityVo);
		}
		return result;
	}
	
	/*

	 * shop facility select - facilitySelect(sid)
	 */
	public FacilityVo facilitySelect(String sid) {
		return sqlSession.selectOne("mapper.shop.facilitySelect", sid);
	}
	
	/*
	 *	shop admin �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 waiting->completed - update(String sid)
	 */
	public int update(String sid) {
		return sqlSession.update("mapper.shop.adminConfirm", sid);
	}
	
	
	/*
	 *	shop admin 占쏙옙占쏙옙占쏙옙 占쏙옙체 占쏙옙占쏙옙占쏙옙 - select()
	 */
	public ArrayList<ShopVo> select(boolean sconfirm, boolean aconfirmfinal) {
		Map<String, String> map = new HashMap<String, String>();
		String sconfirmCheck = sconfirm ? String.valueOf('Y') : String.valueOf('N');
		String aconfirmfinalCheck = aconfirmfinal ? String.valueOf('Y') : String.valueOf('N');
		map.put("sconfirmCheck", sconfirmCheck);
		map.put("aconfirmfinalCheck", aconfirmfinalCheck);
		List<ShopVo> list = sqlSession.selectList("mapper.shop.adminList", map);
		return (ArrayList<ShopVo>)list;
	}
	
	/*
	 *	main kakao marker 占쏙옙占� - mapSelect()
	 */
	public ArrayList<SearchVo> mapSelect() {
		List<SearchVo> list = sqlSession.selectList("mapper.shop.mapSelect");
		return (ArrayList<SearchVo>)list;
	}
	
	/*
	 *	shop reservation 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 - reservationSelect()
	 */
	public ArrayList<BookingVo> reservationSelect(Map<String, String> map) {
		List<BookingVo> list = sqlSession.selectList("mapper.shop.reservationSelect", map);
		return (ArrayList<BookingVo>)list;
	}
	
	/**
	 * Shop Login Id Check
	 */
	public int shopIdCheck(ShopVo shopVo) {
		return sqlSession.selectOne("mapper.shop.shopIdCheck", shopVo);
	}
	
	/**
	 * Shop Login 
	 */
	public SessionVo shopLogin(ShopVo shopVo) {
		return sqlSession.selectOne("mapper.shop.shopLogin", shopVo);
	}
	
	/**
	 * Shop Registration Check
	 */
	public int shopRegistrationCheck(ShopVo shopVo) {
		return sqlSession.selectOne("mapper.shop.shopRegistrationCheck", shopVo);
	}
}
