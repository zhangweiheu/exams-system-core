package com.online.exams.system.core.bean;

import com.online.exams.system.core.enums.QuestionTypeEnum;
import com.online.exams.system.core.enums.RefTypeEnum;
import com.online.exams.system.core.enums.StatusEnum;
import com.online.exams.system.core.enums.TagEnum;

/**
 * Created by zhang on 2016/3/16.
 */
public class QuestionTag {
    private QuestionTypeEnum questionType;

    private StatusEnum status;

    private RefTypeEnum refType;

    private TagEnum refValue;

    public QuestionTypeEnum getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionTypeEnum questionType) {
        this.questionType = questionType;
    }

    public RefTypeEnum getRefType() {
        return refType;
    }

    public void setRefType(RefTypeEnum refType) {
        this.refType = refType;
    }

    public TagEnum getRefValue() {
        return refValue;
    }

    public void setRefValue(TagEnum refValue) {
        this.refValue = refValue;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
