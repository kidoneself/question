package com.kidoneself.question.service;


import com.kidoneself.aio.common.core.base.R;

public interface QuestionService {

    R<?> getQuestion(Integer id);

    R<?> getQuestionList(Integer num);
}
