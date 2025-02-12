package com.toyproject.memoryMirror.domain.service.user;

import com.toyproject.memoryMirror.domain.mapper.user.Usermapper;
import com.toyproject.memoryMirror.domain.model.user.User;
import com.toyproject.memoryMirror.web.exception.CustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock //Mybatis의 UserMapper를 mocking한다
    private Usermapper usermapper;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("로그인 성공했을때")
    void login_success() {
        //given
        User user = new User().builder()
                .userId("hehe")
                .password("1234")
                .build();

        Mockito.when(usermapper.login(user)).thenReturn(new User(1L, "hehe", BCrypt.hashpw("1234", BCrypt.gensalt(12)),null,null,null));

        //when
        Long id = userService.login(user);

        //then
        assertThat(id).isEqualTo(1L);
    }

    @Test
    @DisplayName("로그인 실패했을때 - 해당 아이디 없음")
    void login_fail_noId() {
        //given
        User user = new User().builder()
                .userId("hehe")
                .password("1234")
                .build();

        User nullUser = null;

        Mockito.when(usermapper.login(user)).thenReturn(nullUser);

        //when & then
        Assertions.assertThrows(CustomException.class, () -> {
            userService.login(user);
        }, "예외가 발생하지 않음");
    }

    @Test
    @DisplayName("로그인 실패했을때 - 해당 비밀번호가 일치하지 않음")
    void login_fail_password() {
        //given
        User user = new User().builder()
                .userId("hehe")
                .password("1234")
                .build();

        //when
        Mockito.when(usermapper.login(user)).thenReturn(new User(1L, "hehe", BCrypt.hashpw("5678", BCrypt.gensalt(12)),null,null,null));

        //when & then
        Assertions.assertThrows(CustomException.class, () -> {
            userService.login(user);
        }, "비밀번호가 일치함");
    }

    @Test
    @DisplayName("회원가입시 핸드폰번호와 이름으로 회원이 있는경우 - 중복이 존재하면 1반환")
    void isDuplicate() {
        //given : 실행준비
        User user = createUser(); //1. 유저객체를 생성한다.
        Mockito.when(usermapper.checkDuplicate(user)).thenReturn(1); //2. checkDuplication메소드를 모킹하고 호출될때 1을 반환하도록 설정

        //when : 테스트진행, 서비스에서 메서드를 호출
        int duplication = userService.isDuplicate(user);

        //then : 테스트 결과
        assertThat(duplication).isEqualTo(1);
    }

    private User createUser() {
        String phone = "01050635938";
        String username = "최선호";
        return new User().builder()
                .phone(phone)
                .username(username)
                .build();
    }
}