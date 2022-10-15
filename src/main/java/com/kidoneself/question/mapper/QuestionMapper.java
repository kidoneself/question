package com.kidoneself.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kidoneself.question.modle.dto.QuestionDto;
import com.kidoneself.question.modle.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface QuestionMapper extends BaseMapper<Question> {


    List<QuestionDto> getQuestionList(@Param("limit") Integer limit, @Param("month") Integer month);
}
