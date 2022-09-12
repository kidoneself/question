package com.kidoneself.question.modle.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UserDto {


    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "用户的唯一标识")
    private String openid;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "用户头像")
    private String headimgurl;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "部门id")
    private Integer deptId;

    @ApiModelProperty(value = "是否已经完成手机号等信息")
    private Boolean hasDo;

    @ApiModelProperty(value = "是否是新用户")
    private Boolean isNew;

}
