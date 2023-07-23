package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.SearchDto;
import com.springboot.catchmind.exception.BusinessException;
import com.springboot.catchmind.exception.CommonErrorCode;
import com.springboot.catchmind.repository.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {
	
	@Autowired
	SearchMapper searchMapper;

	public List<SearchDto> select(String searchValue) {
		return searchMapper.select(searchValue);
	}

	public List<SearchDto> getBookNowSelect(Map map) {
		return searchMapper.bookNowSelect(map);
	}
}
