package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.QuestionDao;
import com.online.exams.system.core.model.Question;
import com.online.exams.system.core.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> listAllQuestion(int offset, int pageSize) {
        return questionDao.findAll(offset, pageSize);
    }

    @Override
    public int updateQuestion(Question question) {
        return questionDao.updateQestion(question);
    }

    @Override
    public int deleteQuestionById(int qid) {
        return questionDao.deleteById(qid);
    }

    @Override
    public int deleteQuestionByAttr(Question question) {
        return questionDao.deleteQuestionByAttr(question);
    }

    @Override
    public int saveQuestion(Question question) {
        return questionDao.saveQuestion(question);
    }

    @Override
    public Question findQuestionById(int qid) {
        Question question = new Question();
        question.setId(qid);
        List<Question> questionList = questionDao.findQuestionByAttr(question);
        return CollectionUtils.isEmpty(questionList) ? null : questionList.get(0);
    }

    @Override
    public Question findCommonQuestion(Question question) {
        Question questionnew = new Question();
        questionnew.setTitle(question.getTitle());
        List<Question> questionList = questionDao.findQuestionByAttr(questionnew);
        return CollectionUtils.isEmpty(questionList) ? null : questionList.get(0);
    }

    @Override
    public int getTotalCount(Question question) {
        return questionDao.getTotalCount(question);
    }

    @Override
    public String findQuestionAnswerById(int qid) {
        Question question = findQuestionById(qid);
        return null == question ? null : question.getAnswers();
    }
}
