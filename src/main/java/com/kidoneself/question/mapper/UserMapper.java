package com.kidoneself.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kidoneself.question.modle.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {

}
