package com.online.exams.system.core.service;

import com.online.exams.system.core.model.Question;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
public interface QuestionService {
    List<Question> listAllQuestion();

    int updateQuestion(Question question, String tagList);

    int deleteQuestionById(int qid);

    int deleteQuestionByAttr(Question question);

    int saveQuestion(Question question, String tagList);
}
