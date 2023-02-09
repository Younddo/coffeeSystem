package com.kakao.coffeesystem.controller;

import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/menu")
    public GlobalResponseDto<?> checkMenu() {
        return menuService.checkMenu();
    }
}
