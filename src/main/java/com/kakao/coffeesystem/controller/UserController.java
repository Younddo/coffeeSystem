package com.kakao.coffeesystem.controller;

import com.kakao.coffeesystem.dto.requestDto.MemberRequestDto;
import com.kakao.coffeesystem.dto.responseDto.MemberResponseDto;
import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public GlobalResponseDto<MemberResponseDto> chargePoint(@Valid @RequestBody MemberRequestDto userRequestDto) {
        return userService.chargePoint(userRequestDto);
    }

}
