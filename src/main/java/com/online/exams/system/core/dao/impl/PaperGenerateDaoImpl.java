package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.bean.QuestionMap;
import com.online.exams.system.core.bean.QuestionTag;
import com.online.exams.system.core.dao.PaperGenerateDao;
import com.online.exams.system.core.mapper.CommonMapper;
import com.online.exams.system.core.mybatis.enums.QuestionTypeEnum;
import com.online.exams.system.core.mybatis.enums.RefTypeEnum;
import com.online.exams.system.core.mybatis.enums.StatusEnum;
import com.online.exams.system.core.mybatis.enums.TagEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhang on 2016/3/12.
 */
@Repository
public class PaperGenerateDaoImpl implements PaperGenerateDao {

    @Autowired
    CommonMapper commonMapper;

    @Override
    public List<QuestionMap> generateSingleSelection(TagEnum tagValue) {
        return getQuestionMapByAttr(QuestionTypeEnum.SINGLE_SELECTION, RefTypeEnum.QUESTION, tagValue);
    }

    @Override
    public List<QuestionMap> generateMultiSelection(TagEnum tagValue) {
        return getQuestionMapByAttr(QuestionTypeEnum.MULTI_SELECTION, RefTypeEnum.QUESTION, tagValue);
    }

    @Override
    public List<QuestionMap> generateProgrammingQuestion(TagEnum tagValue) {
        return getQuestionMapByAttr(QuestionTypeEnum.PROGRAMMING_QUESTION, RefTypeEnum.QUESTION, tagValue);
    }

    @Override
    public List<QuestionMap> generateProgrammingQuestion() {
        return getQuestionMapByAttr(QuestionTypeEnum.PROGRAMMING_QUESTION, RefTypeEnum.QUESTION, TagEnum.JAVA);
    }

    private List<QuestionMap> getQuestionMapByAttr(QuestionTypeEnum questionType, RefTypeEnum refType, TagEnum tagValue) {
        QuestionTag questionTag = new QuestionTag();
        questionTag.setQuestionType(questionType);
        questionTag.setRefType(refType);
        questionTag.setRefValue(tagValue);
        questionTag.setStatus(StatusEnum.NORMAL);
        return commonMapper.selectQuestionByQuestionTypeAndTagType(questionTag);
    }
}
