package com.kakao.coffeesystem.repository;

import com.kakao.coffeesystem.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
