package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface SearchMapper {
	List<SearchDto> select(String searchValue);

	List<SearchDto> bookNowSelect(Map<String, String> map);
}


//	ArrayList<SearchDto> bookNowSelect(Map<String, String> map);
//		List<SearchDto> list = sqlSession.selectList("mapper.search.bookNowList", map);
//		return (ArrayList<SearchVo>)list;


