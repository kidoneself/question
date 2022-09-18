package com.kidoneself.question.controller;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.entity.Score;
import com.kidoneself.question.service.QuestionService;
import com.kidoneself.question.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@Api(tags = "得分模块")
@RequestMapping("score")
public class ScoreController {

    @Resource
    private ScoreService scoreService;


    @PostMapping
    @ApiOperation("提交得分")
    public R<?> postScore(@RequestBody Score score) {
        return scoreService.postScore(score);
    }

    @GetMapping("month")
    @ApiOperation("月份排行榜")
    public R<?> getScore() {
        return scoreService.getScore();
    }

    @GetMapping("all")
    @ApiOperation("月份排行榜")
    public R<?> getAllScore() {
        return scoreService.getAllScore();
    }


}
