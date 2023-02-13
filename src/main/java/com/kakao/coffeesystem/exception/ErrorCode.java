package com.kakao.coffeesystem.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    NotFoundUser(HttpStatus.NOT_FOUND.value(), "U001", "유저를 찾을 수 없습니다."),
    FailToPay(HttpStatus.BAD_REQUEST.value(), "P001", "잔액이 부족합니다."),
    AlreadyExistName(HttpStatus.BAD_REQUEST.value(), "M001", "이미 존재하는 메뉴명입니다.");


    private final int httpStatus;
    private final String errorCode;
    private final String message;
}
