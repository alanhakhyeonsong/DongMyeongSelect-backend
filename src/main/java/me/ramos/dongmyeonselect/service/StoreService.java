package me.ramos.dongmyeonselect.service;

import me.ramos.dongmyeonselect.domain.Menu;
import me.ramos.dongmyeonselect.domain.Store;
import me.ramos.dongmyeonselect.dto.admin.EnrollRequestDto;
import me.ramos.dongmyeonselect.dto.admin.ListResponseDto;
import me.ramos.dongmyeonselect.dto.admin.UpdateRequestDto;
import me.ramos.dongmyeonselect.dto.api.RandomRequestDto;
import me.ramos.dongmyeonselect.dto.api.ResponseDto;

import java.util.List;

public interface StoreService {
    // 카테고리 받아서 랜덤으로 하나 반환
    ResponseDto randomChoice(RandomRequestDto dto) throws Exception;

    // 전체 조회 - api용
    List<ResponseDto> findAll() throws Exception;

    // 전체 조회 - admin용
    List<ListResponseDto> findAllForAdmin();

    // 하나 조회
    Store findOne(Long storeId);

    // 등록(menu, store 순서)
    Long enroll(EnrollRequestDto dto);

    // 수정
    void update(Long storeId, UpdateRequestDto dto);

    // 삭제(store, menu 순서)
    void delete(Long storeId);

    default ResponseDto entityToResponseDto(Store store, Menu menu) {
        return ResponseDto.builder()
                .storeId(store.getId())
                .storeName(store.getStoreName())
                .location(store.getLocation())
                .contactNum(store.getContactNum())
                .storeUrl(store.getStoreUrl())
                .imageUrl(store.getImageUrl())
                .category(store.getCategory().toString())
                .foodName(menu.getFoodName())
                .price(menu.getPrice())
                .build();
    }

    default ListResponseDto entityToListResponseDto(Store store, Menu menu) {
        return ListResponseDto.builder()
                .storeId(store.getId())
                .storeName(store.getStoreName())
                .location(store.getLocation())
                .contactNum(store.getContactNum())
                .storeUrl(store.getStoreUrl())
                .imageUrl(store.getImageUrl())
                .category(store.getCategory().toString())
                .foodName(menu.getFoodName())
                .price(menu.getPrice())
                .build();
    }
}
