package com.kakao.coffeesystem.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "사용자 식별자는 공백일 수 없습니다.")
    public String userNum;

    @NotBlank(message = "충전금액은 공백일 수 없습니다.")
    public Long chargeAmount;


}
