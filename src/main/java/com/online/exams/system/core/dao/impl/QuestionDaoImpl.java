package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.QuestionDao;
import com.online.exams.system.core.mapper.QuestionMapper;
import com.online.exams.system.core.model.Question;
import com.online.exams.system.core.model.QuestionCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public Question findById(int qid) {
        return questionMapper.selectById(qid);
    }

    @Override
    public List<Question> findAll() {
        return questionMapper.selectByCondition(new QuestionCondition());
    }

    @Override
    public List<Question> findQuestionByAttr(Question question) {
        return questionMapper.selectByCondition(convertQuestionAttr2Condition(question));
    }

    @Override
    public int deleteById(int qid) {
        return questionMapper.deleteById(qid);
    }

    @Override
    public int updateQestion(Question question) {
        question.setUpdateAt(new Date());
        return questionMapper.updateByIdSelective(question);
    }

    @Override
    public int deleteQuestionByAttr(Question question) {
        QuestionCondition questionCondition = convertQuestionAttr2Condition(question);

        return null == questionCondition ? 0 : questionMapper.deleteByCondition(questionCondition);
    }

    @Override
    public int saveQuestion(Question question) {
        return questionMapper.insertSelective(question);
    }

    @Override
    public List<Question> listAllQuestion(int offset, int pageSize) {
        QuestionCondition condition = new QuestionCondition();
        condition.setLimitOffset(offset);
        condition.setLimitSize(pageSize);
        return questionMapper.selectByCondition(condition);
    }

    @Override
    public int getTotalCount(Question question) {
        return questionMapper.countByCondition(convertQuestionAttr2Condition(question));
    }

    private QuestionCondition convertQuestionAttr2Condition(Question question) {
        QuestionCondition condition = new QuestionCondition();

        if (null == question) {
            return null;
        }
        if (null != question.getId()) {
            condition.createCriteria().andIdEqualTo(question.getId());
        }
        if (null != question.getTitle()) {
            condition.createCriteria().andTitleEqualTo(question.getTitle());
        }
        if (null != question.getQuestionType()) {
            condition.createCriteria().andQuestionTypeEqualTo(question.getQuestionType());
        }
        if (null != question.getOptions()) {
            condition.createCriteria().andOptionsEqualTo(question.getOptions());
        }
        if (null != question.getAnswers()) {
            condition.createCriteria().andAnswersEqualTo(question.getAnswers());
        }
        if (null != question.getStatus()) {
            condition.createCriteria().andStatusEqualTo(question.getStatus());
        }
        return condition;
    }
}
