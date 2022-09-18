package com.kidoneself.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kidoneself.question.modle.dto.ScoreDto;
import com.kidoneself.question.modle.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

    List<ScoreDto> getScore(@Param("month") Integer month);

    List<ScoreDto> getAllScore();

}
