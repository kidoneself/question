package com.kidoneself.question.modle.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@TableName(value = "score")
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Score {


    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "得分")
    private Integer scores;

    @ApiModelProperty(value = "月份")
    private Integer monthNum;

    @ApiModelProperty(value = "时间秒")
    private Long sec;

    @ApiModelProperty(value = "uid")
    private Integer uid;

}
