package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SearchMapper {
	List<SearchDto> select(String searchValue);
}


//	ArrayList<SearchDto> bookNowSelect(Map<String, String> map);
//		List<SearchDto> list = sqlSession.selectList("mapper.search.bookNowList", map);
//		return (ArrayList<SearchVo>)list;


