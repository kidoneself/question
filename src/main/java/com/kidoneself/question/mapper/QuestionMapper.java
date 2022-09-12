package com.kidoneself.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kidoneself.question.modle.entity.Question;
import com.kidoneself.question.modle.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface QuestionMapper extends BaseMapper<Question> {


    List<Question> getQuestionList(@Param("limit") Integer limit);
}
