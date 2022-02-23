package me.ramos.dongmyeonselect.service;

import lombok.RequiredArgsConstructor;
import me.ramos.dongmyeonselect.domain.Menu;
import me.ramos.dongmyeonselect.domain.Store;
import me.ramos.dongmyeonselect.domain.enums.Category;
import me.ramos.dongmyeonselect.dto.admin.EnrollRequestDto;
import me.ramos.dongmyeonselect.dto.admin.ListResponseDto;
import me.ramos.dongmyeonselect.dto.admin.UpdateRequestDto;
import me.ramos.dongmyeonselect.dto.api.RandomRequestDto;
import me.ramos.dongmyeonselect.dto.api.ResponseDto;
import me.ramos.dongmyeonselect.exceptions.StoreNotFoundException;
import me.ramos.dongmyeonselect.repository.MenuRepository;
import me.ramos.dongmyeonselect.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    @Override
    public ResponseDto randomChoice(RandomRequestDto dto) throws Exception {
        List<Store> storeList = storeRepository.findAllByCategory(Category.valueOf(dto.getCategory()));
        int size = storeList.size();
        if (size == 0) {
            throw new StoreNotFoundException("해당 맛집이 없습니다.");
        } else {
            int random = (int) ((Math.random() * 100) % (size));
            Store store = storeList.get(random);
            return entityToResponseDto(store, store.getMenu());
        }
    }

    @Override
    public List<ResponseDto> findAll() throws Exception {
        List<Store> list = storeRepository.findAllByFetch();
        List<ResponseDto> resultList = new ArrayList<>();
        if (list.isEmpty()) {
            throw new StoreNotFoundException("해당 맛집이 없습니다.");
        } else {
            for (Store store : list) {
                resultList.add(entityToResponseDto(store, store.getMenu()));
            }
        }
        return resultList;
    }

    @Override
    public List<ListResponseDto> findAllForAdmin() {
        List<Store> list = storeRepository.findAllByFetch();
        List<ListResponseDto> resultList = new ArrayList<>();
        for (Store store : list) {
            resultList.add(entityToListResponseDto(store, store.getMenu()));
        }
        return resultList;
    }

    @Override
    public Store findOne(Long storeId) {
        return storeRepository.findById(storeId).orElseThrow();
    }

    @Transactional
    @Override
    public Long enroll(EnrollRequestDto dto) {
        Menu menu = Menu.builder()
                .foodName(dto.getFoodName())
                .price(dto.getPrice())
                .build();
        menuRepository.save(menu);

        Store store = Store.builder()
                .storeName(dto.getStoreName())
                .location(dto.getLocation())
                .contactNum(dto.getContactNum())
                .storeUrl(dto.getStoreUrl())
                .imageUrl(dto.getImageUrl())
                .category(Category.valueOf(dto.getCategory()))
                .menu(menu)
                .build();
        storeRepository.save(store);

        return store.getId();
    }

    @Transactional
    @Override
    public void update(Long storeId, UpdateRequestDto dto) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        store.updateStore(dto.getLocation(), dto.getContactNum());
        Menu menu = store.getMenu();
        menu.updateMenu(dto.getFoodName(), dto.getPrice());

        storeRepository.save(store);
        menuRepository.save(menu);
    }

    @Transactional
    @Override
    public void delete(Long storeId) {
        Menu menu = storeRepository.findById(storeId).orElseThrow().getMenu();
        storeRepository.deleteById(storeId);
        menuRepository.delete(menu);
    }
}
