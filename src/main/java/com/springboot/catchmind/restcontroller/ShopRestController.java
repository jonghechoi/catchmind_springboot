package com.springboot.catchmind.restcontroller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springboot.catchmind.dto.ShopPhotoDto;
import com.springboot.catchmind.service.FileServiceImpl;
import com.springboot.catchmind.service.ShopServiceImpl;
import com.springboot.catchmind.vo.ShopPhotoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.HashMap;

@RestController
public class ShopRestController {
    @Autowired
    ShopServiceImpl shopService;
    @Autowired
    FileServiceImpl fileService;

    @PostMapping("shop_information_photo")
    public String shop_information_photo(@RequestParam("sid") String sid,
                                         @RequestParam("files") String files,
                                         @ModelAttribute ShopPhotoDto shopPhotoDto,
                                         HttpServletRequest request) throws Exception {

        Gson gson = new Gson();
        Type type = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> map = gson.fromJson(files, type);

        int result = -1;
        int insertOrUpdate = shopService.getPhotoSelectCheck(sid);
        if(insertOrUpdate == 0) {
            result = shopService.getPhotoInsert(sid, fileService.multiFileCheck(shopPhotoDto));
        }else {
            fileService.multiFileDelete(sid, map, request);
            result = shopService.getPhotoUpdate(sid, fileService.multiFileUpdateCheck(shopPhotoDto, map));
        }

        if(result == 1) {
            if(!shopPhotoDto.getPhotos()[0].equals("")) {
                fileService.multiFilesave(shopPhotoDto, request);
            }else {
                result = 0;
            }
        }else {
            result = 0;
        }
        return String.valueOf(result);
    }
}
