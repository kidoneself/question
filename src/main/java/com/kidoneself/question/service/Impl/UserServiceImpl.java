package com.kidoneself.question.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.aio.common.core.exception.BizException;
import com.kidoneself.question.mapper.UserMapper;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.entity.User;
import com.kidoneself.question.service.UserService;
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
            UserDto userDto = new UserDto();
            userMapper.insert(user);
            BeanUtil.copyProperties(user, userDto);
            return R.ok(userDto);
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

    @Override
    public R<?> getUser(Integer id, String openId) {
        try {

            if (BeanUtil.isEmpty(id) && BeanUtil.isEmpty(openId)) {
                return R.failed("请填写正确的参数");
            }
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            if (BeanUtil.isNotEmpty(id)) {
                userLambdaQueryWrapper.eq(User::getId, id);
            }
            if (BeanUtil.isNotEmpty(openId)) {
                userLambdaQueryWrapper.eq(User::getOpenid, openId);
            }
            User user = userMapper.selectOne(userLambdaQueryWrapper);
            UserDto userDto = new UserDto();
            if (BeanUtil.isNotEmpty(user)) {
                Integer deptId = user.getDeptId();
                String phone = user.getPhone();
                String realName = user.getRealName();
                userDto.setHasDo(BeanUtil.isNotEmpty(deptId) && BeanUtil.isNotEmpty(phone) && BeanUtil.isNotEmpty(realName));
                userDto.setIsNew(false);
                BeanUtil.copyProperties(user, userDto);
            } else {
                userDto.setIsNew(true);
            }
            return R.ok(userDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException(StrUtil.format("获取用户信息失败，请联系管理员"));
        }
    }
}
