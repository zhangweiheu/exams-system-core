package com.online.exams.system.core.mapper;

import com.online.exams.system.core.bean.QuestionMap;
import com.online.exams.system.core.bean.QuestionTag;

import java.util.List;

/**
 * Created by zhang on 2016/3/15.
 */
public interface CommonMapper {
    List<QuestionMap> selectQuestionByQuestionTypeAndTagType(QuestionTag questionTag);
}
