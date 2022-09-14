package com.kidoneself.question.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
 
    /**
     * 上传图片
     * @param file
     * @return
     */
    String uploadImage(MultipartFile file) throws Exception;
}
