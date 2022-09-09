package com.kidoneself.question.modle.service.Impl;


import cn.hutool.Hutool;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kidoneself.question.mapper.UserMapper;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.entity.User;
import com.kidoneself.question.modle.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public User postUser(UserDto dto) {
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        userMapper.selectById(1);
        userMapper.insert(user);
        return user;
    }
}
