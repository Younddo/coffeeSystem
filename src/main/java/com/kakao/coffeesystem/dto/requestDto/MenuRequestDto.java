package com.kakao.coffeesystem.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuRequestDto {

    @NotBlank(message = "커피이름은 공백일 수 없습니다.")
    private String coffeeName;

    private Long price;

}
