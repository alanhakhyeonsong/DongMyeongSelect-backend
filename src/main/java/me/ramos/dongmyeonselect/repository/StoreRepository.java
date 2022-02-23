package me.ramos.dongmyeonselect.repository;


import me.ramos.dongmyeonselect.domain.Store;
import me.ramos.dongmyeonselect.domain.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByCategory(Category category);

    @Query(value = "select s from Store s join fetch s.menu")
    List<Store> findAllByFetch();
}
