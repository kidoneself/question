package com.kidoneself.question.service;


import com.kidoneself.aio.common.core.base.R;

public interface DeptService {


    R<?> getPageDept(Integer pageSize, Integer pageNum);

}
