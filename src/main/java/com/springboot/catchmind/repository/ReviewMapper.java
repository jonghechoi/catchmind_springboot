package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper{
//	@Autowired
//	private SqlSessionTemplate sqlSession;
	
	 /* REVIEWYN : N -> Y */
	int updateReviewYN(String rid);

	 /* write_review(insert) */
	int writeReview(ReviewDto reviewDto);

	 /* write_review form Data */
	ReviewDto reviewSelect(String rid);

	/*ArrayList<ReviewDto> reviewMainList() {
		List<ReviewDto> list = sqlSession.selectList("mapper.review.reviewMainList");
		return (ArrayList<ReviewDto>)list;
	}
	
	int updateToMain(String rid) {
		return sqlSession.update("mapper.review.updateToMain", rid);
	}
	
	int deleteFromMain(String rid) {
		return sqlSession.delete("mapper.review.deleteFromMain", rid);
	}
	
	ReviewDto selectRid(String rid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("rid", rid);
		ReviewDto vo = sqlSession.selectOne("mapper.review.one", map);
		return vo;
	}
	
	public ArrayList<ReviewDto> select(int startCount, int endCount) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startCount", startCount);
		map.put("endCount", endCount);
		List<ReviewDto> list = sqlSession.selectList("mapper.review.list", map);
		return (ArrayList<ReviewDto>)list;
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
	
	public ArrayList<ReviewDto> select(String sid) {
		ArrayList<ReviewDto> reviewList = new ArrayList<ReviewDto>();
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
				ReviewDto reviewDto = new ReviewDto();
				reviewDto.setRno(rs.getInt(1));
				reviewDto.setReviewid(rs.getString(2));
				reviewDto.setReviewcontent(rs.getString(3));
				reviewDto.setReviewstar(rs.getInt(4));
				reviewDto.setReviewcreatedate(rs.getString(5));
				reviewDto.setReviewmodifydate(rs.getString(6));
				reviewDto.setSid(rs.getString(7));
				reviewDto.setMid(rs.getString(8));
				reviewDto.setRid(rs.getString(9));
				reviewDto.setReviewphoto(rs.getString(10));
				reviewDto.setReviewsphoto(rs.getString(11));
				reviewDto.setMname(rs.getString(12));
				
				reviewList.add(reviewDto);
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

	   public ArrayList<ReviewDto> selectMid(String mid) {
		   System.out.println(mid);
	      ArrayList<ReviewDto> reviewList = new ArrayList<ReviewDto>();
	      String sql = "SELECT review.REVIEWID, review.REVIEWCONTENT, review.REVIEWSTAR, review.REVIEWCREATEDATE, review.REVIEWMODIFYDATE, review.SID,review.MID,review.RID, "
	            + " review.REVIEWPHOTO, review.REVIEWSPHOTO, s.SNAME "
	            + " FROM REVIEW review, SHOP s"
	            + " WHERE review.MID = ? and review.sid = s.sid";
	      getPreparedStatement(sql);
	      try {
	         pstmt.setString(1, mid);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            ReviewDto reviewDto = new ReviewDto();
	            reviewDto.setReviewid(rs.getString(1));
	            reviewDto.setReviewcontent(rs.getString(2));
	            reviewDto.setReviewstar(rs.getInt(3));
	            reviewDto.setReviewcreatedate(rs.getString(4));
	            reviewDto.setReviewmodifydate(rs.getString(5));
	            reviewDto.setSid(rs.getString(6));
	            reviewDto.setMid(rs.getString(7));
	            reviewDto.setRid(rs.getString(8));
	            reviewDto.setReviewphoto(rs.getString(9));
	            reviewDto.setReviewsphoto(rs.getString(10));
	            reviewDto.setSname(rs.getString(11));
	            
	            reviewList.add(reviewDto);
	         }
	         
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }

	      return reviewList;
	   }*/
	   
}
