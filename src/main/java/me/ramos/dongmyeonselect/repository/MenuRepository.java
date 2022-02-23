package me.ramos.dongmyeonselect.repository;

import me.ramos.dongmyeonselect.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
