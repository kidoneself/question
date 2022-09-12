package com.kidoneself.question.controller;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.service.QuestionService;
import com.kidoneself.question.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@Api(tags = "题目模块")
@RequestMapping("question")
public class QuestionController {

    @Resource
    private QuestionService questionService;


    @GetMapping("/get")
    @ApiOperation("根据id获取题目信息")
    public R<?> getQuestion(@RequestParam(name = "题目Id") Integer id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("/get/list")
    @ApiOperation("获取题目列表")
    public R<?> getQuestionList(@RequestParam(name = "获取N条题目（可以被100整除）") Integer num) {
        return questionService.getQuestionList(num);
    }


}
