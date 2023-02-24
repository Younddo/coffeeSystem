package com.kakao.coffeesystem.domain;

import com.kakao.coffeesystem.dto.requestDto.MemberRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    @DisplayName("정상 케이스")
    void createMember() {
        Long id = 100L;
        String userNum = "장윤서";
        Long point = 10000L;

        MemberRequestDto memberRequestDto = new MemberRequestDto(
                userNum,
                point
        );

        Member member = new Member(memberRequestDto);

        assertNull(member.getId());
        assertEquals(id, member.getId());
        assertEquals(userNum, member.getUserNum());
        assertEquals(point, member.getPoint());
    }
}