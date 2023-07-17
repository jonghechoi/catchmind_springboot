package com.springboot.catchmind.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.catchmind.vo.ShopPhotoVo;

@Repository 
public class ShopPhotoDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
//	public Map<String, String> select(String sid) {
//		Map<String, String> shopPhoto = new HashMap<String, String>();
//		String sql = "select photo1, photo2, photo3, photo4, photo5 " + 
	// public Map<String, String> select(String sid) {
	// 	ShopPhotoVo shopPhotoVo = new ShopPhotoVo();
	// 	Map<String, String> shopPhoto = new HashMap<String, String>();
	// 	String sql = "select photo1, photo2, photo3, photo4, photo5 " + 
	// 			"	  from shop_photo" + 
	// 			"	  where sid=?";
	// 	getPreparedStatement(sql);

	// 	try {
	// 		pstmt.setString(1, sid);
	// 		rs = pstmt.executeQuery();
			
	// 		while(rs.next()) {
	// 			shopPhoto.put("photo1", rs.getString(1));

	// 			shopPhotoVo.setSid(rs.getString(1));
	// 			shopPhotoVo.setPhoto1(rs.getString(2));
	// 			shopPhotoVo.setPhoto2(rs.getString(3));
	// 			shopPhotoVo.setPhoto3(rs.getString(4));
	// 			shopPhotoVo.setPhoto4(rs.getString(5));
	// 			shopPhotoVo.setPhoto5(rs.getString(6));
	// 		}
	// 	}
	// 	catch(Exception e) {
	// 		e.printStackTrace();
	// 	}
	// 	return shopPhoto;
	// }		

	public ShopPhotoVo select(String sid) {
		ShopPhotoVo shopPhotoVo = new ShopPhotoVo();
		String sql = "select sid, photo1, photo2, photo3, photo4, photo5, " +
				"                 sphoto1, sphoto2, sphoto3, sphoto4, sphoto5 " + 
				"	  		from shop_photo" + 
				"		    where sid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				shopPhotoVo.setSid(rs.getString(1));
				shopPhotoVo.setPhoto1(rs.getString(2));
				shopPhotoVo.setPhoto2(rs.getString(3));
				shopPhotoVo.setPhoto3(rs.getString(4));
				shopPhotoVo.setPhoto4(rs.getString(5));
				shopPhotoVo.setPhoto5(rs.getString(6));
				shopPhotoVo.setSphoto1(rs.getString(7));
				shopPhotoVo.setSphoto2(rs.getString(8));
				shopPhotoVo.setSphoto3(rs.getString(9));
				shopPhotoVo.setSphoto4(rs.getString(10));
				shopPhotoVo.setSphoto5(rs.getString(11));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return shopPhotoVo;
	}
	
	public int selectCheck(String sid) {
		return sqlSession.selectOne("mapper.shop.photoSelectCheck", sid);
	}

	public int insert(String sid, ShopPhotoVo shopPhotoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", sid);
		map.put("shopPhotoVo", shopPhotoVo);
		return sqlSession.insert("mapper.shop.photoInsert", map);
	}
	
	public int update(String sid, ShopPhotoVo shopPhotoVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", sid);
		map.put("shopPhotoVo", shopPhotoVo);
		return sqlSession.insert("mapper.shop.photoUpdate", map);		
	}
}
