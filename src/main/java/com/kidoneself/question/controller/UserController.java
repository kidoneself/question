package com.kidoneself.question.controller;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@Api(tags = "用户模块")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/step")
    @ApiOperation("微信登录新增用户")
    public R<?> postUser(@RequestBody UserDto dto) {
        return R.ok(userService.postUser(dto));
    }


}
