//package com.toyproject.memoryMirror.domain.service.user;
//
//import com.toyproject.memoryMirror.domain.mapper.user.Usermapper;
//import com.toyproject.memoryMirror.domain.model.user.User;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.assertj.core.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//
//    @Mock //Mybatis의 UserMapper를 mocking한다
//    private Usermapper usermapper;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void login() {
//    }
//
//    @Test
//    @DisplayName("회원가입 테스트")
//    void save() {
//        //given
//
//        //when
//
//        //then
//    }
//
//    @Test
//    @DisplayName("회원가입시 핸드폰번호와 이름으로 회원이 있는경우")
//    void isDuplicate() {
//        //given : 실행준비
//        User user = createUser(); //1. 유저객체를 생성한다.
//        Mockito.when(usermapper.checkDuplicate(user)).thenReturn(1); //2. checkDuplication메소드를 모킹하고 호출될때 1을 반환하도록 설정
//
//        //when : 테스트진행, 서비스에서 메서드를 호출
//        int duplication = userService.isDuplicate(user);
//
//        //then : 테스트 결과
//        assertThat(duplication).isEqualTo(1);
//    }
//
//    private User createUser() {
//        String phone = "01050635938";
//        String username = "최선호";
//        return new User().builder()
//                .phone(phone)
//                .username(username)
//                .build();
//    }
//}