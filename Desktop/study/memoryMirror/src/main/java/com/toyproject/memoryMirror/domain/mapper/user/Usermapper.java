package com.toyproject.memoryMirror.domain.mapper.user;

import com.toyproject.memoryMirror.domain.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Usermapper {

    void save(User user);

    int checkDuplicate(User user);
    User login(User user);
}
