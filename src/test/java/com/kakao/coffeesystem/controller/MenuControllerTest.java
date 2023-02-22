package com.kakao.coffeesystem.controller;

import com.kakao.coffeesystem.domain.Menu;
import com.kakao.coffeesystem.dto.requestDto.MenuRequestDto;
import com.kakao.coffeesystem.exception.CustomException;
import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.repository.MenuRepository;
import com.kakao.coffeesystem.service.MenuService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    //TODO 메뉴서비스 테스트옮겨야합니다
    @Mock
    MenuRepository menuRepository;

    @InjectMocks
    MenuService menuService;




    @Test
    @DisplayName("메뉴 체크 테스트")
    void controllerTest(){
        //given
        //when

        menuService.checkMenu();
//        Exception exception = assertThrows(CustomException.class, () -> {
//            new
//        });
//        GlobalResponseDto dto = GlobalResponseDto.fail("조회가능한 메뉴가 없습니다.");
        //then
        assertEquals("조회가능한 메뉴가 없습니다.", menuService.checkMenu().getMsg());
    }

    @Test
    @DisplayName("예외 실험")
    void test12() {
        //given
        String coffeeName = "아베리카노";
        Long price = 3000l;

        MenuRequestDto testDto = MenuRequestDto.builder()
                .coffeeName(coffeeName)
                .price(price)
                .build();

        Exception exception = assertThrows(CustomException.class, () -> {
            menuService.addMenu(testDto);
        });

        //when
        menuService.addMenu(testDto);


        //then

    }

}