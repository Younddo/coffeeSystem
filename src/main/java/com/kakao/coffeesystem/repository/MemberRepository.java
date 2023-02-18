package com.kakao.coffeesystem.repository;

import com.kakao.coffeesystem.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findUserByUserNum(String userNum);
    boolean existsMemberByUserNum(String userNum);
}
