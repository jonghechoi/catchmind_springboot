package com.springboot.catchmind.restcontroller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springboot.catchmind.controller.ShopController;
import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.FacilityDto;
import com.springboot.catchmind.dto.ShopDto;
import com.springboot.catchmind.dto.ShopPhotoDto;
import com.springboot.catchmind.service.FileServiceImpl;
import com.springboot.catchmind.service.ShopServiceImpl;
import com.springboot.catchmind.vo.FacilityVo;
import com.springboot.catchmind.vo.ShopPhotoVo;
import com.springboot.catchmind.vo.ShopVo;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.util.*;

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

    @PostMapping("shop_information_proc")
    public String shop_information_proc(ShopDto shopDto) {
        int InsertOrUpdate = shopService.getRegistrationCheck(shopDto);
        if(InsertOrUpdate == 0) {
            System.out.println("shop_information_proc InsertOrUpdate --> " + InsertOrUpdate);
            String.valueOf(shopService.getDetailInsert(shopDto));
        }else {
            System.out.println("shop_information_proc InsertOrUpdate --> " + InsertOrUpdate);
            String.valueOf(shopService.getDetailUpdate(shopDto));
        }

        return String.valueOf(shopService.getDetailInsert(shopDto));
    }

    @PostMapping("shop_information_facility_proc")
    public String shop_information_facility_proc(FacilityDto facilityDto) {
        return String.valueOf(shopService.getDetailFacilityUpdate(facilityDto));
    }

    @PostMapping("shop_information_photoBring")
    public ResponseEntity<String> shop_information_photoBring(@RequestParam("sid") String sid,
                                                              @RequestParam("count") int count,
                                                              @RequestParam("photos") String photos,
                                                              HttpServletRequest request,
                                                              HttpServletResponse response) throws Exception {
        String imgPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\";
        Gson gson = new Gson();

        Map<String, Integer> photosMap = gson.fromJson(photos, new TypeToken<HashMap<String, Integer>>() {}.getType());

        for(Map.Entry<String, Integer> entry : photosMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value : " + entry.getValue());
        }

        ShopPhotoDto shopPhotoDto = shopService.getShopPhotoSelect(sid);

        List<File> imageFiles = new ArrayList<File>();
        if(photosMap.get("photo1") == 1) {
            String imgPath1 = imgPath + shopPhotoDto.getSphoto1();
            File imageFile1 = new File(imgPath1);
            imageFiles.add(imageFile1);
        }
        if(photosMap.get("photo2") == 1) {
            String imgPath2 = imgPath + shopPhotoDto.getSphoto2();
            File imageFile2 = new File(imgPath2);
            imageFiles.add(imageFile2);
        }
        if(photosMap.get("photo3") == 1) {
            String imgPath3 = imgPath + shopPhotoDto.getSphoto3();
            File imageFile3 = new File(imgPath3);
            imageFiles.add(imageFile3);
        }
        if(photosMap.get("photo4") == 1) {
            String imgPath4 = imgPath + shopPhotoDto.getSphoto4();
            File imageFile4 = new File(imgPath4);
            imageFiles.add(imageFile4);
        }
        if(photosMap.get("photo5") == 1) {
            String imgPath5 = imgPath + shopPhotoDto.getSphoto5();
            File imageFile5 = new File(imgPath5);
            imageFiles.add(imageFile5);
        }

        List<byte[]> byteArrayList = new ArrayList<byte[]>();
        for(File imageFile : imageFiles) {
            FileInputStream fileInputStream = new FileInputStream(imageFile);
            byte[] imageData = IOUtils.toByteArray(fileInputStream);
            byteArrayList.add(imageData);
        }

        List<String> jsonStringList = new ArrayList<String>();
        for (byte[] byteArray : byteArrayList) {
            jsonStringList.add(Base64.getEncoder().encodeToString(byteArray));
        }

        String json = gson.toJson(jsonStringList);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<String>(json, headers, HttpStatus.OK);
    }

    @PostMapping("shop_reservation_proc")
    public List<BookingDto> shop_reservation_proc(@RequestParam("sid") String sid,
                                                  @RequestParam("startDate") String startDate,
                                                  @RequestParam("endDate") String endDate) {
        try {
            shopService.dateCheck(startDate, endDate);
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(ShopController.class);
            logger.error("loooooooooooooog", e);
        }

        return shopService.getShopReservationSelectJson(sid, startDate, endDate);
    }
}
