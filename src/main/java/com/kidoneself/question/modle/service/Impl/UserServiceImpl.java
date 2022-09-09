package com.kidoneself.question.modle.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.aio.common.core.exception.BizException;
import com.kidoneself.question.mapper.UserMapper;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.entity.User;
import com.kidoneself.question.modle.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public R<?> postUser(UserDto dto) {
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        try {
            userMapper.insert(user);
            return R.ok("新增成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException(StrUtil.format("新增用户失败，请联系管理员"));
        }
    }

    @Override
    public R<?> putUser(UserDto dto) {
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        try {
            userMapper.updateById(user);
            return R.ok("更新成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException(StrUtil.format("更新用户失败，请联系管理员"));
        }
    }
}
