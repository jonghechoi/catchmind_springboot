//package com.springboot.catchmind.model;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.springboot.catchmind.dto.ShopResponseDto;
//import com.springboot.catchmind.entity.Shop;
//import com.springboot.catchmind.entity.ShopRepository;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class ShopService {
//
//    private final ShopRepository shopRepository;
//
//    /**
//     * 식당 생성
//     */
//    @Transactional
//    public Long save(final ShopRequestDto params) {
//
//        Shop entity = ShopRepository.save(params.toEntity());
//        return entity.getId();
//    }
//
//    /**
//     * 식당 리스트 조회
//     */
//    public List<ShopResponseDto> findAll() {
//
//        Sort sort = Sort.by(Direction.DESC, "sid", "screatedate");
//        List<Shop> list = shopRepository.findAll(sort);
//        return list.stream().map(ShopResponseDto::new).collect(Collectors.toList());
//    }
//
//
//
//
//
//
//
//    /**
//     * 식당 조회
//     */
//    public ShopResponseDto findById(final String sid) {
//
//        Shop entity = shopRepository.findById(sid);
//        return new ShopResponseDto(entity);
//    }
//
//
//
//
//
//
//
//
//    /**
//     * 식당 수정
//     */
//    @Transactional
//    public String update(final Long id, final ShopRequestDto params) {
//
//        Shop entity = shopRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
//        entity.update(params.getSid(), params.getSname(), params.getSloc());
//        return sid;
//    }
//}
