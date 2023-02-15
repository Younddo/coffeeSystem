package com.kakao.coffeesystem.repository;

import com.kakao.coffeesystem.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findUserByUserNum(String userNum);
    boolean existsMemberByUserNum(String userNum);
}
