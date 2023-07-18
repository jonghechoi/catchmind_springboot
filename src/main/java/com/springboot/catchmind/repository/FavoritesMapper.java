package com.springboot.catchmind.repository;

import com.springboot.catchmind.dto.FavoritesDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface FavoritesMapper {
    int getFavorites(FavoritesDto favoritesdto);

    int deleteFavorites(String fid);

    List<FavoritesDto> select(String mid);
}
