package com.kidoneself.question.modle.service;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.dto.UserDto;

public interface DeptService {




    R<?> getPageDept(Integer pageSize, Integer pageNum);

}
