package com.kakao.coffeesystem.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class MenuListResponseDto {

    private LocalDateTime currentTime;
    private List<MenuResponseDto> menuResponseDtoList;

    public MenuListResponseDto(List<MenuResponseDto> menuResponseDtoList) {
        this.currentTime = LocalDateTime.now();
        this.menuResponseDtoList = menuResponseDtoList;
    }

}
