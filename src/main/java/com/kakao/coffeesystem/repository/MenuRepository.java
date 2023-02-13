package com.kakao.coffeesystem.repository;

import com.kakao.coffeesystem.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    boolean existsMenuByCoffeeName(String coffeeName);
}
