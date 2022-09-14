package com.kidoneself.question.controller;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.service.CmsService;
import com.kidoneself.question.service.DeptService;
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
@Api(tags = "内容模块")
@RequestMapping("cms")
public class CmsController {

    @Resource
    private CmsService cmsService;


    @GetMapping("/get")
    @ApiOperation("获取文章列表")
    public R<?> getCms(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        return cmsService.getCms(pageSize, pageNum);
    }


}
