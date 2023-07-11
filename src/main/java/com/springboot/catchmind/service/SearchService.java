package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.SearchDao;
import com.springboot.catchmind.vo.SearchVo;

@Service("searchService")
public class SearchService {
	
	@Autowired
	 private SearchDao searchDao;

	public ArrayList<SearchVo> getSelect(String searchValue) {
		return searchDao.select(searchValue);
	}

	public ArrayList<SearchVo> getBookNowSelect(Map<String, String> map) {
		return searchDao.bookNowSelect(map);
	}
}
