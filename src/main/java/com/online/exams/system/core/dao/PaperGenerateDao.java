package com.online.exams.system.core.dao;

import com.online.exams.system.core.bean.QuestionMap;
import com.online.exams.system.core.enums.TagEnum;

import java.util.List;

/**
 * Created by zhang on 2016/3/12.
 */
public interface PaperGenerateDao {
    List<QuestionMap> generateSingleSelection(TagEnum tagValue);

    List<QuestionMap> generateMultiSelection(TagEnum tagValue);

    List<QuestionMap> generateProgrammingQuestion(TagEnum tagValue);

    List<QuestionMap> generateProgrammingQuestion();
}
