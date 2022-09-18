package com.kidoneself.question.modle.dto;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.sql.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ScoreDto {


    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "得分")
    private Integer scores;

    @ApiModelProperty(value = "用户昵称")
    private String realName;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "用时")
    private String time;


}
