package com.kakao.coffeesystem.domain;

import com.kakao.coffeesystem.dto.requestDto.MenuRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Menu extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String coffeeName;

    @Column
    private Long price;

    public Menu(MenuRequestDto menuRequestDto) {
        this.coffeeName = menuRequestDto.getCoffeeName();
        this.price = menuRequestDto.getPrice();
    }
}
