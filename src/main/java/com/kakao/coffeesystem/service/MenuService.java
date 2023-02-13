package com.kakao.coffeesystem.service;

import com.kakao.coffeesystem.domain.Menu;
import com.kakao.coffeesystem.dto.requestDto.MenuRequestDto;
import com.kakao.coffeesystem.dto.responseDto.MenuListResponseDto;
import com.kakao.coffeesystem.dto.responseDto.MenuResponseDto;
import com.kakao.coffeesystem.exception.CustomException;
import com.kakao.coffeesystem.exception.ErrorCode;
import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    // 메뉴 조회 기능
    public GlobalResponseDto<MenuListResponseDto> checkMenu() {
        List<Menu> menuList = menuRepository.findAll();
        if(menuList.isEmpty()) {
            return GlobalResponseDto.fail("조회가능한 메뉴가 없습니다.");
        }
        List<MenuResponseDto> menuResponseDtos = new ArrayList<>();
        for(Menu menu : menuList) {
            menuResponseDtos.add(new MenuResponseDto(menu));
        }
        MenuListResponseDto menuListResponseDto = new MenuListResponseDto(menuResponseDtos);
        return GlobalResponseDto.ok("메뉴 조회완료", menuListResponseDto);
    }

    // 메뉴 추가 기능
    public GlobalResponseDto<MenuResponseDto> addMenu(MenuRequestDto menuRequestDto) {
        if(menuRepository.existsMenuByCoffeeName(menuRequestDto.getCoffeeName())) {
            throw new CustomException(ErrorCode.AlreadyExistName);
        }
        Menu menu = new Menu(menuRequestDto);
        menuRepository.save(menu);
        return GlobalResponseDto.created("메뉴 추가 성공", new MenuResponseDto(menu));
    }
}
