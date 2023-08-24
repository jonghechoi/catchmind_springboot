package com.springboot.catchmind.service;

import java.util.List;

import com.springboot.catchmind.dto.SearchDto;
import com.springboot.catchmind.repository.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service("mapService")
public class MapServiceImpl {

	@Autowired
	private ShopMapper shopMapper;

	private final double EARTH_RADIUS = 6371.0; // 지구의 반지름 (단위: km)
	
	public String mapMainToSearch(double lat, double lng) {
		List<SearchDto> allShopList = shopMapper.mapSelect(lat, lng);

		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();

 		for(SearchDto searchDto : allShopList) {
			// 검색 위도: lat, 경도, lng / shop 위도:slocy, 경도:slocx / 환산단위 km
			double distance = calculateDistance(lat, lng, Double.parseDouble(searchDto.getSlocy()), Double.parseDouble(searchDto.getSlocx()));
			if(distance <= 10) {
				JsonObject jobj = new JsonObject();
				jobj.addProperty("sid", searchDto.getSid());
				jobj.addProperty("sname", searchDto.getSname());
				jobj.addProperty("sintro", searchDto.getSintro());
				jobj.addProperty("reviewstar", searchDto.getReviewstar());
				jobj.addProperty("slocshort", searchDto.getSlocshort());
				jobj.addProperty("lunch", searchDto.getLunch());
				jobj.addProperty("dinner", searchDto.getDinner());
				jobj.addProperty("smphoto", searchDto.getSmphoto());
				jobj.addProperty("rtime", searchDto.getRtime());
				jobj.addProperty("sloc", searchDto.getSloc());
				jobj.addProperty("sfoodstyle", searchDto.getSfoodstyle());
				jobj.addProperty("sopeninghour", searchDto.getSopeninghour());

				jarray.add(jobj);
			}
		}

 		jlist.add("jlist", jarray);
		return new Gson().toJson(jlist);
	}
	
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS * c;
        return distance;
    }
}
