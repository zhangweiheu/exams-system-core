package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.Question;

/**
 * Created by zhang on 2016/2/15.
 */
public interface QuestionDao extends AbstractDao{
    int updateQestion(Question question);
    int deleteQuestionByAttr(Question question);
    int saveQuestion(Question question);
}
