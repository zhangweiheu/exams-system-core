package com.online.exams.system.core.bean;

import com.online.exams.system.core.mybatis.enums.TagEnum;
import com.online.exams.system.core.model.Question;

/**
 * Created by zhang on 2016/3/13.
 */
public class QuestionMap extends Question {
    private TagEnum tagValue;

    /**
     * 是否正确
     */
    private Boolean isRight;

    private String currentAnswer;

    public TagEnum getTagValue() {
        return tagValue;
    }

    public void setTagValue(TagEnum tagValue) {
        this.tagValue = tagValue;
    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }
}
