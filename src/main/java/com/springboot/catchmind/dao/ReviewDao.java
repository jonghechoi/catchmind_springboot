package com.springboot.catchmind.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.springboot.catchmind.vo.ReviewVo;
@Repository
public class ReviewDao extends DBConn{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 *  ReviewYN N -> Y
	 */
	public int updateReviewYN(String rid) {
		return sqlSession.update("mapper.review.updateReviewYN", rid);
	}

	
	/**
	 * Review_Write (insert)
	 */
	public int writeReview(ReviewVo reviewVo) {
		return sqlSession.insert("mapper.review.writeReview", reviewVo);
	}

	/**
	 * ���侲�� ������ ������ ����
	 */
	public ReviewVo reviewSelect(String rid) {
		return sqlSession.selectOne("getReviewSelect", rid);
	}

	public ArrayList<ReviewVo> reviewMainList() {
		List<ReviewVo> list = sqlSession.selectList("mapper.review.reviewMainList");
		return (ArrayList<ReviewVo>)list;
	}
	
	public int updateToMain(String rid) {
		return sqlSession.update("mapper.review.updateToMain", rid);
	}
	
	public int deleteFromMain(String rid) {
		return sqlSession.delete("mapper.review.deleteFromMain", rid);
	}
	
	public ReviewVo selectRid(String rid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		ReviewVo vo = sqlSession.selectOne("mapper.review.one", map);
		return vo;
	}
	
	public ArrayList<ReviewVo> select(int startCount, int endCount) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startCount", startCount);
		map.put("endCount", endCount);
		List<ReviewVo> list = sqlSession.selectList("mapper.review.list", map);
		return (ArrayList<ReviewVo>)list;
	}
	
	public int totalRowCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM REVIEW";
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
	
	public ArrayList<ReviewVo> select(String sid) {
		ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
		String sql = "select rno, REVIEWID, REVIEWCONTENT, REVIEWSTAR, REVIEWCREATEDATE, "
				+ " REVIEWMODIFYDATE, SID, MID, RID, REVIEWPHOTO, REVIEWSPHOTO, mname" 
				+ "	from(select rownum rno, REVIEWID, REVIEWCONTENT, REVIEWSTAR, "
				+ "		 	to_char(REVIEWCREATEDATE, 'yyyy-mm-dd') REVIEWCREATEDATE, " 
				+ "      	to_char(REVIEWMODIFYDATE, 'yyyy-mm-dd') REVIEWMODIFYDATE, "
				+ "		 	SID, review.MID, RID, REVIEWPHOTO, REVIEWSPHOTO, m.mname mname" 
				+ "      from review review, member m" 
				+ "      where sid = ? and review.mid = m.mid" 
				+ "      order by reviewcreatedate desc)" 
				+ " where rno between 1 and 8";


				


		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVo reviewVo = new ReviewVo();
				reviewVo.setRno(rs.getInt(1));
				reviewVo.setReviewid(rs.getString(2));
				reviewVo.setReviewcontent(rs.getString(3));
				reviewVo.setReviewstar(rs.getInt(4));
				reviewVo.setReviewcreatedate(rs.getString(5));
				reviewVo.setReviewmodifydate(rs.getString(6));
				reviewVo.setSid(rs.getString(7));
				reviewVo.setMid(rs.getString(8));
				reviewVo.setRid(rs.getString(9));
				reviewVo.setReviewphoto(rs.getString(10));
				reviewVo.setReviewsphoto(rs.getString(11));
				reviewVo.setMname(rs.getString(12));
				
				reviewList.add(reviewVo);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return reviewList;
	}
	
	public int totalReviewPhotoCount(String sid) {
		int result = 0;
		String sql = "select count(reviewphoto)"
				+ "	  from review"
				+ "	  where sid = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int starAvg(String sid) {
		int result = 0;
		String sql = "select trunc(avg(reviewstar), 2)"
				+ "	  from review "
				+ "	  where sid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int totalReviewCount(String sid) {
		int result = 0;
		String sql = "select count(*) " + 
				" from review " + 
				" where sid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	   public ArrayList<ReviewVo> selectMid(String mid) {
		   System.out.println(mid);
	      ArrayList<ReviewVo> reviewList = new ArrayList<ReviewVo>();
	      String sql = "SELECT review.REVIEWID, review.REVIEWCONTENT, review.REVIEWSTAR, review.REVIEWCREATEDATE, review.REVIEWMODIFYDATE, review.SID,review.MID,review.RID, "
	            + " review.REVIEWPHOTO, review.REVIEWSPHOTO, s.SNAME "
	            + " FROM REVIEW review, SHOP s"
	            + " WHERE review.MID = ? and review.sid = s.sid";
	      getPreparedStatement(sql);
	      try {
	         pstmt.setString(1, mid);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            ReviewVo reviewVo = new ReviewVo();
	            reviewVo.setReviewid(rs.getString(1));
	            reviewVo.setReviewcontent(rs.getString(2));
	            reviewVo.setReviewstar(rs.getInt(3));
	            reviewVo.setReviewcreatedate(rs.getString(4));
	            reviewVo.setReviewmodifydate(rs.getString(5));
	            reviewVo.setSid(rs.getString(6));
	            reviewVo.setMid(rs.getString(7));
	            reviewVo.setRid(rs.getString(8));
	            reviewVo.setReviewphoto(rs.getString(9));
	            reviewVo.setReviewsphoto(rs.getString(10));
	            reviewVo.setSname(rs.getString(11));
	            
	            reviewList.add(reviewVo);
	         }
	         
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }

	      return reviewList;
	   }
	   
}//
