package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.FavoritesDto;
import com.springboot.catchmind.repository.FavoritesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritesServiceImpl {
    @Autowired
    private FavoritesMapper favoritesMapper;

    public int getFavorites(FavoritesDto favoritesdto) {return favoritesMapper.getFavorites(favoritesdto); }
    public int deleteFavorites(String fid) { return favoritesMapper.deleteFavorites(fid); }
    public List<FavoritesDto> select(String mid) { return favoritesMapper.select(mid); }
}
