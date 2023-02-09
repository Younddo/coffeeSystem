package com.kakao.coffeesystem.service;

import com.kakao.coffeesystem.domain.User;
import com.kakao.coffeesystem.dto.requestDto.UserRequestDto;
import com.kakao.coffeesystem.dto.responseDto.UserResponseDto;
import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public GlobalResponseDto<?> chargePoint(UserRequestDto userRequestDto) {
        User user = userRepository.findUserByUserNum(userRequestDto.getUserNum()).orElse(
                userRepository.save(new User(userRequestDto)));
        user.update(userRequestDto);
        return GlobalResponseDto.ok("포인트 충전 성공!", new UserResponseDto(user));
    }

}
