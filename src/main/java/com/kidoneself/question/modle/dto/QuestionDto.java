package com.kidoneself.question.modle.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuestionDto {


    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "题目")
    private String question;

    @ApiModelProperty(value = "答案（xxx/xxx/xxx/xxx/xxx/xxx）")
    private String answer;

    @ApiModelProperty(value = "正确答案xxx")
    private String trueAnswer;

    @ApiModelProperty(value = "几月份的题目")
    private String monthNum;

    @ApiModelProperty(value = "几月份的题目")
    private Integer score;

    @ApiModelProperty(value = "体型")
    private Integer type;

}
