package com.kidoneself.question.utils;

public class UploadUtils {
 
    /**
     * 文件名称替换工具，将文件名称替换为随机名称
     * @param oldName
     * @return
     */
    public static String generateFileName(String oldName){
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        return IDUtils.generateUniqueId()+suffix;
    }
}
