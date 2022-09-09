package com.kidoneself.question.controller;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.service.DeptService;
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
@Api(tags = "部门模块")
@RequestMapping("dept")
public class DeptController {

    @Resource
    private DeptService deptService;


    @GetMapping("/get")
    @ApiOperation("获取部门列表")
    public R<?> getPageDept(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        return deptService.getPageDept(pageSize, pageNum);
    }


}
