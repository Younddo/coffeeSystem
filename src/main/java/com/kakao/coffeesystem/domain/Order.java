package com.kakao.coffeesystem.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Orders")
@NoArgsConstructor
public class Order extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
