package com.kidoneself.question.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author xppll
 * @date 2021/12/11 14:39
 */
@Component
public class ConstantWxUtils implements InitializingBean {


    public static String WX_OPEN_APP_ID;
    public static String WX_OPEN_APP_SECRET;
    public static String WX_OPEN_REDIRECT_URL;
    private final String appId = "wx63472391cd7c5d6d";
    private final String appSecret = "8cdb72748e11a513dae71e48cd257a1d";
    private String redirectUrl;

    @Override
    public void afterPropertiesSet() {
        WX_OPEN_APP_ID = appId;
        WX_OPEN_APP_SECRET = appSecret;
        WX_OPEN_REDIRECT_URL = redirectUrl;
    }
}
