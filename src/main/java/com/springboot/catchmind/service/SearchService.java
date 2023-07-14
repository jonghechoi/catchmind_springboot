package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.SearchDto;
import com.springboot.catchmind.repository.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
	
	@Autowired
	SearchMapper searchMapper;

	public List<SearchDto> select(String searchValue) {
		System.out.println(searchValue);
		return searchMapper.select(searchValue);
	}

//	public ArrayList<SearchDto> getBookNowSelect(Map<String, String> map) {
//		return searchDao.bookNowSelect(map);
//	}
}
