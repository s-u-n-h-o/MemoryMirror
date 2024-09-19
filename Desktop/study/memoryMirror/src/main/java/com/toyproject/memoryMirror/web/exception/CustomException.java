package com.toyproject.memoryMirror.web.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CustomException extends RuntimeException{

    private final ExceptionCode exceptionCode;

}
