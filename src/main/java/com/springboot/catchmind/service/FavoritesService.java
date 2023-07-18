package com.springboot.catchmind.service;

import com.springboot.catchmind.dto.FavoritesDto;

import java.util.ArrayList;

public interface FavoritesService {
    int getFavorites(FavoritesDto favoritesDto);
    int deleteFavorites(String fid);
    ArrayList<FavoritesDto> select(String mid);
}
