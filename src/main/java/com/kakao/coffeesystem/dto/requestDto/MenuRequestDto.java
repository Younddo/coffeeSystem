package com.kakao.coffeesystem.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class MenuRequestDto {

    @NotBlank(message = "커피이름은 공백일 수 없습니다.")
    private String coffeeName;

    private Long price;

}
