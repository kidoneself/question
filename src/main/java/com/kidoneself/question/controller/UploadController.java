package com.kidoneself.question.controller;

import com.kidoneself.question.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(uploadService.uploadImage(file));
    }
}
