package com.kakao.coffeesystem.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class MemberRequestDto {

//    @NotBlank(message = "사용자 식별자는 공백일 수 없습니다.")
    public String userNum;

//    @NotBlank(message = "충전금액은 공백일 수 없습니다.")
    public Long chargeAmount;


    public MemberRequestDto(String userNum, Long point) {
        this.userNum = userNum;
        this.chargeAmount = point;
    }

}
