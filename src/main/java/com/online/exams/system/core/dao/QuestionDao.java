package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.Question;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
public interface QuestionDao {
    List<Question> findAll();

    Question findById(int id);

    int deleteById(int id);

    List<Question> findQuestionByAttr(Question question);

    int updateQestion(Question question);

    int deleteQuestionByAttr(Question question);

    int saveQuestion(Question question);

    List<Question> listAllQuestion(int offset, int pageSize);

    int getTotalCount(Question question);
}
