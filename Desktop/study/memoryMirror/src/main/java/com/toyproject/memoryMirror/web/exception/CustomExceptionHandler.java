package com.toyproject.memoryMirror.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//스프링부트 애플리케이션에서 전역적으로 예외를 핸들링할수있게 해주는 어노테이션
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> customException(CustomException e , Model model) {
        return ResponseEntity.status(e.getExceptionCode().getCode())
                .body(e.getExceptionCode().getMessage());
    }
}

