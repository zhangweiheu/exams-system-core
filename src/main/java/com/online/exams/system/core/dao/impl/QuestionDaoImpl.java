package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.QuestionDao;
import com.online.exams.system.core.mapper.QuestionMapper;
import com.online.exams.system.core.model.Question;
import com.online.exams.system.core.model.QuestionCondition;
import com.online.exams.system.core.mybatis.enums.StatusEnum;
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
    public List<Question> findAll(int offset, int pageSize) {
        QuestionCondition questionCondition = new QuestionCondition();
        questionCondition.setLimitOffset(offset);
        questionCondition.setLimitSize(pageSize);
        return questionMapper.selectByCondition(questionCondition);
    }

    @Override
    public List<Question> findQuestionByAttr(Question question) {
        return questionMapper.selectByCondition(convertQuestionAttr2Condition(question));
    }

    @Override
    public int deleteById(int qid) {
        Question question = new Question();
        question.setId(qid);
        question.setUpdateAt(new Date());
        question.setStatus(StatusEnum.DELETE);
        return questionMapper.updateByIdSelective(question);
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
        QuestionCondition.Criteria criteria = condition.createCriteria();

        if (null == question) {
            return condition;
        }
        if (null != question.getId()) {
            criteria.andIdEqualTo(question.getId());
        }
        if (null != question.getTitle()) {
            criteria.andTitleEqualTo(question.getTitle());
        }
        if (null != question.getQuestionType()) {
            criteria.andQuestionTypeEqualTo(question.getQuestionType());
        }
        if (null != question.getOptions()) {
            criteria.andOptionsEqualTo(question.getOptions());
        }
        if (null != question.getAnswers()) {
            criteria.andAnswersEqualTo(question.getAnswers());
        }
        if (null != question.getStatus()) {
            criteria.andStatusEqualTo(question.getStatus());
        }
        condition.or(criteria);
        return condition;
    }
}
