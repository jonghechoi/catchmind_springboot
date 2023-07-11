package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SearchMapper {
	
	@Autowired
    SqlSessionTemplate sqlSession;
	
	
		ArrayList<SearchDto> select(String searchValue);
		List<SearchDto> list = sqlSession.selectList("mapper.search.list",searchValue);
		(ArrayList<SearchDto>)list;


	
//	ArrayList<SearchDto> bookNowSelect(Map<String, String> map);
//		List<SearchDto> list = sqlSession.selectList("mapper.search.bookNowList", map);
//		return (ArrayList<SearchVo>)list;

}
