package com.kakao.coffeesystem.controller;

import com.kakao.coffeesystem.dto.requestDto.OrderRequestDto;
import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/order")
    public GlobalResponseDto<?> order(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.order(orderRequestDto);
    }
}
