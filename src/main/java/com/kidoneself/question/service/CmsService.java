package com.kidoneself.question.service;


import com.kidoneself.aio.common.core.base.R;

public interface CmsService {


    R<?> getCms(Integer pageSize, Integer pageNum);
}
