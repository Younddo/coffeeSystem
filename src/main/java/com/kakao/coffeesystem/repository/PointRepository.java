package com.kakao.coffeesystem.repository;

import com.kakao.coffeesystem.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {
}
