package com.kidoneself.question.controller;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public R<?> getQuestion(@RequestParam(name = "id") Integer id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("/get/list")
    @ApiOperation("获取题目列表")
    public R<?> getQuestionList(@RequestParam(name = "num") Integer num) {
        return questionService.getQuestionList(num);
    }


}
