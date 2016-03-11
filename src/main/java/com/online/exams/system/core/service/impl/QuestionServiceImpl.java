package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.QuestionDao;
import com.online.exams.system.core.enums.RefTypeEnum;
import com.online.exams.system.core.enums.TagEnum;
import com.online.exams.system.core.model.Question;
import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.service.QuestionService;
import com.online.exams.system.core.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;

    @Autowired
    TagService tagService;

    public List<Question> listAllQuestion() {
        return questionDao.findAll();
    }

    @Override
    public int updateQuestion(Question question, String tagList) {
        int i = questionDao.updateQestion(question);
        updateQuestionTagEnum(tagList, question.getId());
        return i;
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
    public int saveQuestion(Question question, String tagList) {
        int i = questionDao.saveQuestion(question);
        updateQuestionTagEnum(tagList, question.getId());
        return i;
    }

    private int updateQuestionTagEnum(String enumList, int qid) {
        Tag tag = new Tag();
        tag.setRefId(qid);
        tagService.deleteTagByTagAttr(tag);
        if (null != enumList) {
            char[] chars = enumList.toCharArray();
            for (char c : chars) {
                tag.setRefType(RefTypeEnum.QUESTION);
                tag.setTagValue(TagEnum.parse(c - 48));
                tagService.saveTag(tag);
            }
        } else {
            return 0;
        }
        return enumList.length();
    }

}
