package com.kidoneself.question.modle.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@TableName(value = "content")
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cms {


    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "图片地址")
    private String img;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "文章链接")
    private String url;

    @ApiModelProperty(value = "排序")
    private Integer sort;


}
