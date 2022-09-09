package com.kidoneself.question.modle.service;


import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.entity.User;

public interface UserService {
    User postUser(UserDto dto);
}
