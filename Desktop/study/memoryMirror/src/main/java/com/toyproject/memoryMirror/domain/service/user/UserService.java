package com.toyproject.memoryMirror.domain.service.user;

import com.toyproject.memoryMirror.domain.mapper.user.Usermapper;
import com.toyproject.memoryMirror.domain.model.user.User;
import com.toyproject.memoryMirror.web.exception.CustomException;
import com.toyproject.memoryMirror.web.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final Usermapper usermapper;

    @Transactional
    public void login(User user) {
        //로그인 아이디 확인하기
        String userPassword = usermapper.login(user);
        boolean checkPassword = User.checkPassword(user, userPassword);
        if(!checkPassword) {
            throw new CustomException(ExceptionCode.NOTFOUND_USER);
        }
    }

    @Transactional
    public void save(User user) {

        int duplicateExists = isDuplicate(user);
        if(duplicateExists > 0) {
           throw new CustomException(ExceptionCode.DUPLICATION_USER);
        }
        usermapper.save(User.encodePassword(user));
    }

    @Transactional
    public int isDuplicate(User user) {
        return usermapper.checkDuplicate(user);
    }
}
