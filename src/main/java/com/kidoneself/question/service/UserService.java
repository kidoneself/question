package com.kidoneself.question.service;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.entity.User;

public interface UserService {
    R<?> postUser(UserDto dto);

    R<?> putUser(UserDto dto);

    R<?> getUser(Integer id, String openId);
}
