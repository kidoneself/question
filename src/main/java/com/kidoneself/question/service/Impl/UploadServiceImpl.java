package com.kidoneself.question.service.Impl;

import com.kidoneself.question.modle.properties.UploadProperties;
import com.kidoneself.question.service.UploadService;
import com.kidoneself.question.utils.UploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private UploadProperties uploadProperties;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        if (!uploadProperties.getAllowTypes().contains(file.getContentType())) {
            throw new IOException("文件上传类型错误！");
        }
        String fileName = UploadUtils.generateFileName(Objects.requireNonNull(file.getOriginalFilename()));
        file.transferTo(new File(uploadProperties.getPath() + fileName));
        return fileName;
    }
}
