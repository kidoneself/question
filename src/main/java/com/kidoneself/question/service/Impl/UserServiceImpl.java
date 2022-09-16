package com.kidoneself.question.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.aio.common.core.exception.BizException;
import com.kidoneself.question.mapper.UserMapper;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.entity.User;
import com.kidoneself.question.modle.entity.Wx;
import com.kidoneself.question.service.UserService;
import com.kidoneself.question.utils.ConstantWxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


//    @Value("${wx.open.app_id}")
//    private String appId;
//    @Value("${wx.open.app_secret}")
//    private String appSecret;
//    @Value("${wx.open.redirect_url}")
//    private String redirectUrl;
//
//    public static String WX_OPEN_APP_ID;
//    public static String WX_OPEN_APP_SECRET;
//    public static String WX_OPEN_REDIRECT_URL;


    //获取openid和access_token的连接
    private static String getOpenId = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&state=123&grant_type=authorization_code";
    //获取用户基本信息的连接
    private static String getUserInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";


    @Resource
    private UserMapper userMapper;

    @Override
    public R<?> postUser(UserDto dto) {
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        try {
            UserDto userDto = new UserDto();
            userMapper.insert(user);
            BeanUtil.copyProperties(user, userDto);
            return R.ok(userDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException(StrUtil.format("新增用户失败，请联系管理员"));
        }
    }

    @Override
    public R<?> putUser(UserDto dto) {
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        try {
            userMapper.updateById(user);
            return R.ok("更新成功");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException(StrUtil.format("更新用户失败，请联系管理员"));
        }
    }

    @Override
    public R<?> getUser(Integer id, String openId) {
        try {
            if (BeanUtil.isEmpty(id) && BeanUtil.isEmpty(openId)) {
                return R.failed("请填写正确的参数");
            }
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            if (BeanUtil.isNotEmpty(id)) {
                userLambdaQueryWrapper.eq(User::getId, id);
            }
            if (BeanUtil.isNotEmpty(openId)) {
                userLambdaQueryWrapper.eq(User::getOpenid, openId);
            }
            User user = userMapper.selectOne(userLambdaQueryWrapper);
            UserDto userDto = new UserDto();
            if (BeanUtil.isNotEmpty(user)) {
                Integer deptId = user.getDeptId();
                String phone = user.getPhone();
                String realName = user.getRealName();
                userDto.setHasDo(BeanUtil.isNotEmpty(deptId) && BeanUtil.isNotEmpty(phone) && BeanUtil.isNotEmpty(realName));
                userDto.setIsNew(false);
                BeanUtil.copyProperties(user, userDto);
            } else {
                userDto.setIsNew(true);
            }
            return R.ok(userDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException(StrUtil.format("获取用户信息失败，请联系管理员"));
        }
    }

    //获取用户基本信息的连接


    @Override
    public R<?> getWxUser(String code) {
        UserDto userDto = new UserDto();
        String getOpenIdUrl = getOpenId.replace("APPID", ConstantWxUtils.WX_OPEN_APP_ID).replace("APPSECRET", ConstantWxUtils.WX_OPEN_APP_SECRET).replace("CODE", code);
        String openIdBody = HttpUtil.createGet(getOpenIdUrl).execute().body();
        Wx wx = JSONObject.parseObject(openIdBody, Wx.class);
        if (ObjectUtil.isNotEmpty(wx) && ObjectUtil.isNotEmpty(wx.getAccess_token()) && ObjectUtil.isNotEmpty(wx.getOpenid())) {
            String userInfoUrl = getUserInfo.replace("ACCESS_TOKEN", wx.getAccess_token()).replace("OPENID", wx.getOpenid());
            String userInfoBody = HttpUtil.createGet(userInfoUrl).execute().body();
            User user = JSONObject.parseObject(userInfoBody, User.class);
            if (ObjectUtil.isNotEmpty(user) && ObjectUtil.isNotEmpty(user.getOpenid())) {
                LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
                userLambdaQueryWrapper.eq(User::getOpenid, user.getOpenid());
                User hasUser = userMapper.selectOne(userLambdaQueryWrapper);
                if (BeanUtil.isNotEmpty(hasUser)) {
                    Integer deptId = user.getDeptId();
                    String phone = user.getPhone();
                    String realName = user.getRealName();
                    userDto.setHasDo(BeanUtil.isNotEmpty(deptId) && BeanUtil.isNotEmpty(phone) && BeanUtil.isNotEmpty(realName));
                    BeanUtil.copyProperties(hasUser, userDto);
                    userDto.setIsNew(false);
                } else {
                    userMapper.insert(user);
                    BeanUtil.copyProperties(user,userDto);
                    userDto.setHasDo(false);
                    userDto.setIsNew(true);
                }
            }
        } else {
            return R.failed("获取用户信息失败请重试");
        }
        return R.ok(userDto);
    }


}
