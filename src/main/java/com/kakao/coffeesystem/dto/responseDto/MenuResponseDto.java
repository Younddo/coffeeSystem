package com.kakao.coffeesystem.dto.responseDto;

import com.kakao.coffeesystem.domain.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuResponseDto {

    private Long menuId;
    private String coffeeName;
    private Long price;


    public MenuResponseDto(Menu menu) {
        this.menuId = menu.getId();
        this.coffeeName = menu.getCoffeeName();
        this.price = menu.getPrice();
    }

}
