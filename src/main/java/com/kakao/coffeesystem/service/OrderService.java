package com.kakao.coffeesystem.service;

import com.kakao.coffeesystem.domain.Member;
import com.kakao.coffeesystem.domain.Menu;
import com.kakao.coffeesystem.domain.Order;
import com.kakao.coffeesystem.dto.requestDto.OrderRequestDto;
import com.kakao.coffeesystem.dto.responseDto.OrderResponseDto;
import com.kakao.coffeesystem.exception.CustomException;
import com.kakao.coffeesystem.exception.ErrorCode;
import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.repository.MemberRepository;
import com.kakao.coffeesystem.repository.MenuRepository;
import com.kakao.coffeesystem.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;

    @Transactional
    public GlobalResponseDto<?> order(OrderRequestDto orderRequestDto) {

        Member member = memberRepository.findUserByUserNum(orderRequestDto.getUserNum()).orElseThrow(
                ()-> new CustomException(ErrorCode.NotFoundUser)
        );
        Menu menu = menuRepository.findMenuById(orderRequestDto.getMenuId()).orElseThrow(
                ()-> new CustomException(ErrorCode.NotFoundMenu)
        );
        if(member.getPoint() < menu.getPrice()) {
            throw new CustomException(ErrorCode.FailToPay);
        }

        Order order = new Order(member, menu);
        orderRepository.save(order);
        member.charge(menu.getPrice());

        return GlobalResponseDto.ok("결제 완료", new OrderResponseDto(order));
    }
}
