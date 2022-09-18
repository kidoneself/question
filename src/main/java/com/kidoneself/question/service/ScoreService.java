package com.kidoneself.question.service;


import com.kidoneself.aio.common.core.base.R;
import com.kidoneself.question.modle.entity.Score;

public interface ScoreService {


    R<?> postScore(Score score);

    R<?> getScore();

    R<?> getAllScore();

}
