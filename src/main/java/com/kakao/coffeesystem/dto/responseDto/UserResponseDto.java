package com.kakao.coffeesystem.dto.responseDto;

import com.kakao.coffeesystem.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String userNum;
    private Long point;

    public UserResponseDto(User user) {
        this.userNum = user.getUserNum();
        this.point = user.getPoint();
    }
}
