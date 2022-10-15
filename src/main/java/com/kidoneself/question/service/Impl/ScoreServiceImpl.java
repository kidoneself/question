package com.kidoneself.question.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.mapper.ScoreMapper;
import com.kidoneself.question.modle.entity.Score;
import com.kidoneself.question.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {


    @Resource
    private ScoreMapper scoreMapper;


    @Override
    public R<?> postScore(Score score) {
        try {
            //
            int month = DateUtil.thisMonth() + 1;
            score.setMonthNum(month);
            LambdaQueryWrapper<Score> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Score::getMonthNum, month);
            wrapper.eq(Score::getUid, score.getUid());
            Score score1 = scoreMapper.selectOne(wrapper);
            if (BeanUtil.isNotEmpty(score1)) {
                Integer oldScores = score.getScores();
                Integer newScores = score.getScores();
                if (newScores >= oldScores) {
                    score.setId(score1.getId());
                    scoreMapper.updateById(score);
                }
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
