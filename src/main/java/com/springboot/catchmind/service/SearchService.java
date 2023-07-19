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

	public List<SearchDto> getBookNowSelect(String date, String location, String cuisine) {
		Map<String, String> map = new HashMap<String, String>();

		if(location.equals("Location") || cuisine.equals("Cuisine")) {
			throw new BusinessException(CommonErrorCode.INVALID_INPUT_VALUE);
		}else {
			map.put("date", date);
			map.put("location", location);
			map.put("cuisine", cuisine);
		}
		return searchMapper.bookNowSelect(map);
	}
}
