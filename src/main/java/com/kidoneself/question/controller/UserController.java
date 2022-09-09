package com.kidoneself.question.controller;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@Api(tags = "用户模块")
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/post")
    @ApiOperation("微信登录新增用户")
    public R<?> postUser(@RequestBody UserDto dto) {
        return userService.postUser(dto);
    }

    @PutMapping("/put")
    @ApiOperation("更新用户信息")
    public R<?> putUser(@RequestBody UserDto dto) {
        return userService.putUser(dto);
    }

}
