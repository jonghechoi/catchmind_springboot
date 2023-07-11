package com.springboot.catchmind.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.catchmind.vo.ReviewVo;

@Repository
public class ReviewPhotoDao extends DBConn{
	
//	@Autowired
//	private SqlSessionTemplate sqlSession;
//	
//
//	public ReviewVo select(String rid) {
//		ReviewVo reviewVo = new ReviewVo();
//		String sql = "select rid, reviewphoto " + 
//				"	  from reviewphoto" + 
//				"	  where rid=?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, rid);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				ReviewVo.setRid(rs.getString(1));
//				ReviewVo.setReviewphoto(rs.getString(2));
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//
//		return ReviewVo;
//	}
//
//	public int insert(String rid, ReviewVo reviewVo) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("rid", rid);
//		map.put("ReviewVo", ReviewVo);
//		return sqlSession.insert("mapper.review.photoInsert", map);
//	}




}