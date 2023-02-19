package com.kakao.coffeesystem.dto.responseDto;

import com.kakao.coffeesystem.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String userNum;
    private Long point;

    public MemberResponseDto(Member user) {
        this.id = user.getId();
        this.userNum = user.getUserNum();
        this.point = user.getPoint();
    }
}
