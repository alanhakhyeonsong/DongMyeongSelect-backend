package me.ramos.dongmyeonselect.service;

import me.ramos.dongmyeonselect.domain.Menu;
import me.ramos.dongmyeonselect.domain.Store;
import me.ramos.dongmyeonselect.domain.enums.Category;
import me.ramos.dongmyeonselect.repository.MenuRepository;
import me.ramos.dongmyeonselect.repository.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StoreServiceImplTest {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Test
    @DisplayName("맛집 등록 테스트")
    public void enrollTest() throws Exception {
        //given
        Menu menu = Menu.builder()
                .foodName("돼지국밥")
                .price(6000)
                .build();
        menuRepository.save(menu);

        Store store = Store.builder()
                .storeName("문신돼지국밥")
                .location("testLocation")
                .contactNum("testNum")
                .storeUrl("test")
                .imageUrl("test")
                .menu(menu)
                .category(Category.KOREA)
                .build();
        storeRepository.save(store);

        //when
        List<Store> list = storeRepository.findAllByFetch();
        Store getStore = list.get(0);
        Menu getMenu = getStore.getMenu();

        //then
        assertThat(getStore.getStoreName()).isEqualTo("문신돼지국밥");
        assertThat(getStore.getMenu()).isEqualTo(getMenu);
    }

    @Test
    @DisplayName("랜덤 추천 테스트")
    public void randomChoiceTest() throws Exception {
        //given
        Menu menu = Menu.builder()
                .foodName("돼지국밥")
                .price(6000)
                .build();
        menuRepository.save(menu);

        Store store1 = Store.builder()
                .storeName("문신돼지국밥")
                .location("testLocation")
                .contactNum("testNum")
                .storeUrl("test")
                .imageUrl("test")
                .menu(menu)
                .category(Category.KOREA)
                .build();
        storeRepository.save(store1);

        Store store2 = Store.builder()
                .storeName("문신돼지국밥2")
                .location("testLocation")
                .contactNum("testNum")
                .storeUrl("test")
                .imageUrl("test")
                .menu(menu)
                .category(Category.KOREA)
                .build();
        storeRepository.save(store2);

        //when
        List<Store> storeList = storeRepository.findAllByCategory(Category.KOREA);
        int random = (int) ((Math.random() * 100) % (storeList.size()));
        Store choice = storeList.get(random);

        //then
        assertThat(choice.getCategory()).isEqualTo(Category.KOREA);
    }

    @Test
    public void updateTest() throws Exception {
        //given
        Menu menu = Menu.builder()
                .foodName("돼지국밥")
                .price(6000)
                .build();
        menuRepository.save(menu);

        Store store = Store.builder()
                .storeName("문신돼지국밥")
                .location("testLocation")
                .contactNum("testNum")
                .storeUrl("test")
                .imageUrl("test")
                .menu(menu)
                .category(Category.KOREA)
                .build();
        storeRepository.save(store);

        //when
        store.updateStore("updateTest", "updateTest");
        storeRepository.save(store);

        //then
        assertThat(store.getLocation()).isEqualTo("updateTest");
    }

    @Test
    public void deleteTest() throws Exception {
        //given
        Menu menu = Menu.builder()
                .foodName("돼지국밥")
                .price(6000)
                .build();
        menuRepository.save(menu);

        Store store = Store.builder()
                .storeName("문신돼지국밥")
                .location("testLocation")
                .contactNum("testNum")
                .storeUrl("test")
                .imageUrl("test")
                .menu(menu)
                .category(Category.KOREA)
                .build();
        storeRepository.save(store);

        //when
        storeRepository.delete(store);
        menuRepository.delete(menu);

        //then
        assertThat(storeRepository.findAllByFetch().size()).isEqualTo(0);
    }
}