package com.toyproject.memoryMirror.domain.model.user;

import lombok.*;
import org.mindrot.jbcrypt.BCrypt;

@Data
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String userId;
    private String password;
    private String phone;
    private String nickname;
    private String username;

    public User() {

    }

    public static User encodePassword(User preUser) {
        User user = new User().builder()
                .userId(preUser.getUserId())
                .username(preUser.getUsername())
                .password(BCrypt.hashpw(preUser.getPassword(), BCrypt.gensalt(12)))
                .nickname(preUser.getNickname())
                .phone(preUser.getPhone())
                .build();

        return user;
    }

    public static boolean checkPassword(User user, String userPassword) {
        return BCrypt.checkpw(user.getPassword(), userPassword);
    }
}