package com.toyproject.memoryMirror.web.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ExceptionCode {

    DUPLICATION_USER(HttpStatus.CONFLICT,"이미 존재하는 회원입니다."),
    NOTFOUND_USER(HttpStatus.NOT_FOUND, "아이디 또는 비밀번호를 다시 확인해주세요.");

    private final HttpStatus Code;
    private final String message;
}
