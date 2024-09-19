package com.toyproject.memoryMirror.web.controller.user;

import com.toyproject.memoryMirror.domain.model.user.User;
import com.toyproject.memoryMirror.domain.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@ModelAttribute User user) {

        userService.login(user);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "/home")
                .build();
    }
}
