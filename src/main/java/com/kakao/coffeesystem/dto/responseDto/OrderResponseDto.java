package com.kakao.coffeesystem.dto.responseDto;

import com.kakao.coffeesystem.domain.Member;
import com.kakao.coffeesystem.domain.Order;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderResponseDto {

    private String userNum;
    private Long price;
    private Long remainingPoints;

    public OrderResponseDto(Order order) {
        this.userNum = order.getMember().getUserNum();
        this.price = order.getPrice();
        this.remainingPoints = order.getMember().getPoint();
    }
}
