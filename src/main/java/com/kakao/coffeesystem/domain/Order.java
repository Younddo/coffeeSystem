package com.kakao.coffeesystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Order extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String coffeeName;

    @Column
    private Long price;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Menu menu;


    public Order(Member member, Menu menu) {
        this.coffeeName = menu.getCoffeeName();
        this.price = menu.getPrice();
        this.member = member;
        this.menu = menu;
    }

}
