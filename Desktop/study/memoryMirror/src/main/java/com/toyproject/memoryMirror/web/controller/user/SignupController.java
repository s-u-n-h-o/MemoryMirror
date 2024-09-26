package com.toyproject.memoryMirror.web.controller.user;

import com.toyproject.memoryMirror.domain.model.user.User;
import com.toyproject.memoryMirror.domain.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    @PostMapping(value="/users")
    public ResponseEntity<Object> signup(@ModelAttribute User user) {

        userService.save(user);

        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
