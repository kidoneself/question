package com.kidoneself.question.modle.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Wx {


    @ApiModelProperty(value = "access_token")
    private String access_token;

    @ApiModelProperty(value = "openid")
    private String openid;


}
