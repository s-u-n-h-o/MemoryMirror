package com.toyproject.memoryMirror.web.controller.user;

import com.toyproject.memoryMirror.domain.model.user.User;
import com.toyproject.memoryMirror.domain.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@ModelAttribute User user, HttpSession request) {
        //로그인이 되어있는지 확인필요
        Long userSequenceId = userService.login(user);

        //로그인 성공시 유저아이디 세션에 저장
        userService.saveSession(request, user.getUserId(), userSequenceId);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/logout")
    public ResponseEntity<Object> logout(HttpSession httpSession) {
        //로그인 세션 제거
        if (httpSession != null) {
            httpSession.invalidate(); //세션 제거
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
