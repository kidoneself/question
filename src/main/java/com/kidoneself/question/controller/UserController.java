package com.kidoneself.question.controller;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.service.UserService;
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

    @GetMapping("/get")
    @ApiOperation("获取用户")
    public R<?> getUser(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "openId", required = false) String openId) {
        return userService.getUser(id, openId);
    }

    @GetMapping("/wx/login")
    @ApiOperation("微信code获取用户信息")
    public R<?> getUser(@RequestParam(name = "code", required = false) String code) {
        return userService.getWxUser(code);
    }


}
