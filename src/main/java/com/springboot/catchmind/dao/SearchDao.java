package com.springboot.catchmind.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.catchmind.vo.SearchVo;

@Repository
public class SearchDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public ArrayList<SearchVo> select(String searchValue){
		List<SearchVo> list = sqlSession.selectList("mapper.search.list",searchValue);
		return (ArrayList<SearchVo>)list;
		/*String sql = " SELECT S.SID SID,S.SNAME SNAME,S.SINTRO SINTRO,R.REVIEWSTAR REVIEWSTAR,S.SLOCSHORT SLOCSHORT,S.LUNCH LUNCH,S.DINNER DINNER,S.SMPHOTO SMPHOTO ,Y.RTIME RTIME FROM RESERVATION Y,SHOP S,REVIEW R " + 
				" WHERE S.SID = R.SID AND R.SID = Y.SID  AND Y.SID = S.SID ";
		getPreparedStatement(sql);
		ArrayList<SearchVo> list = new ArrayList<SearchVo>();
		try {
					
			rs = pstmt.executeQuery();
			while(rs.next()) {	
				SearchVo searchVo = new SearchVo();
				searchVo.setSid(rs.getString(1));
				searchVo.setSname(rs.getString(2));
				searchVo.setSintro(rs.getString(3));
				searchVo.setReviewstar(rs.getDouble(4));
				searchVo.setSlocshort(rs.getString(5));
				searchVo.setLunch(rs.getInt(6));
				searchVo.setDinner(rs.getInt(7));
				searchVo.setSmphoto(rs.getString(8));
				searchVo.setRtime(rs.getString(9));
				
				list.add(searchVo);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;*/
	}
	
	public ArrayList<SearchVo> bookNowSelect(Map<String, String> map){
		List<SearchVo> list = sqlSession.selectList("mapper.search.bookNowList", map);
		return (ArrayList<SearchVo>)list;
	}
}
