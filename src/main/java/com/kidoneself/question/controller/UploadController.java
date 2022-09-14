package com.kidoneself.question.controller;

import com.kidoneself.question.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("upload")
@Api("图片上传")
public class UploadController {

    @Resource
    private UploadService uploadService;

    @ApiOperation(value = "根据id获取题目信息")
    @PostMapping("image")
    @ApiImplicitParam(name = "file", value = "单文件上传", required = true, dataType = "MultipartFile", allowMultiple = true, paramType = "form")
//    @ApiImplicitParam(name = "file", value = "上传的文件（excel）", required = true, dataType = "__File")
    public ResponseEntity<String> upload(@RequestPart("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(uploadService.uploadImage(file));
    }
}
