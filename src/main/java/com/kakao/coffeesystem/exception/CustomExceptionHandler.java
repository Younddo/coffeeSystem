package com.kakao.coffeesystem.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customExceptionHandle(CustomException e) {
        return ErrorResponse.toResponseEntity(e);
    }


    @RequiredArgsConstructor
    @Getter
    @Builder
    private static class ErrorResponse {
        private final int httpStatus;
        private final String errorCode;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final String field;
        private final String message;

        public static ResponseEntity toResponseEntity(CustomException e) {
            return ResponseEntity
                    .status(e.getErrorCode().getHttpStatus())
                    .body(ErrorResponse.builder()
                            .httpStatus(e.getErrorCode().getHttpStatus())
                            .errorCode(e.getErrorCode().getErrorCode())
                            .message(e.getErrorCode().getMessage())
                            .build()
                    );
        }

        public static ResponseEntity toResponseEntityByErrorCode(ErrorCode errorCode, ConstraintViolationException e) {
            return ResponseEntity
                    .status(errorCode.getHttpStatus())
                    .body(ErrorResponse.builder()
                            .httpStatus(errorCode.getHttpStatus())
                            .errorCode(errorCode.getErrorCode())
                            .message(e.getMessage() + " " + errorCode.getMessage())
                            .build()
                    );
        }
    }
}

