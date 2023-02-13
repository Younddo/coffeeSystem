package com.kakao.coffeesystem.controller;

import com.kakao.coffeesystem.dto.requestDto.MenuRequestDto;
import com.kakao.coffeesystem.dto.responseDto.MenuListResponseDto;
import com.kakao.coffeesystem.dto.responseDto.MenuResponseDto;
import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/menu")
    public GlobalResponseDto<MenuListResponseDto> checkMenu() {
        return menuService.checkMenu();
    }

    @PostMapping("/menu")
    public GlobalResponseDto<MenuResponseDto> addMenu(@Valid @RequestBody MenuRequestDto menuRequestDto) {
        return menuService.addMenu(menuRequestDto);
    }
}
