package com.kidoneself.question.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.aio.common.core.exception.BizException;
import com.kidoneself.question.mapper.ScoreMapper;
import com.kidoneself.question.mapper.UserMapper;
import com.kidoneself.question.modle.dto.ScoreDto;
import com.kidoneself.question.modle.dto.UserDto;
import com.kidoneself.question.modle.entity.Score;
import com.kidoneself.question.modle.entity.User;
import com.kidoneself.question.modle.entity.Wx;
import com.kidoneself.question.service.ScoreService;
import com.kidoneself.question.service.UserService;
import com.kidoneself.question.utils.ConstantWxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {


    @Resource
    private ScoreMapper scoreMapper;


    @Override
    public R<?> postScore(Score score) {
        try {


            int month = DateUtil.thisMonth() + 1;
            score.setMonthNum(month);
            LambdaQueryWrapper<Score> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Score::getMonthNum, month);
            wrapper.eq(Score::getUid, score.getUid());
            Score score1 = scoreMapper.selectOne(wrapper);
            if (BeanUtil.isNotEmpty(score1)) {
                score.setId(score1.getId());
                scoreMapper.updateById(score);
            } else {
                scoreMapper.insert(score);
            }
        } catch (Exception e) {
            return R.failed("答题失败，请稍后刷新重试");
        }
        return R.ok(score);
    }

    @Override
    public R<?> getScore() {
        try {
            int month = DateUtil.thisMonth() + 1;
            return R.ok(scoreMapper.getScore(month));
        } catch (Exception e) {
            return R.failed("获取排行榜失败，请稍后刷新重试");
        }

    }

    @Override
    public R<?> getAllScore() {
        try {
            return R.ok(scoreMapper.getAllScore());
        } catch (Exception e) {
            return R.failed("获取排行榜失败，请稍后刷新重试");
        }
    }
}
