package com.online.exams.system.core.mybatis.enums;

import com.online.exams.system.core.mybatis.IEnumDesc;
import com.online.exams.system.core.mybatis.IEnumValue;
import com.online.exams.system.core.mybatis.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum QuestionTypeEnum implements IEnumDesc, IEnumValue {
    SINGLE_SELECTION("单选", 0),
    MULTI_SELECTION("多选", 1),
    PROGRAMMING_QUESTION("编程题", 2);

    private String desc;
    private int value;


    QuestionTypeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static QuestionTypeEnum parse(int val) {
        for (QuestionTypeEnum cycle : QuestionTypeEnum.values()) {
            if (cycle.value == val) {
                return cycle;
            }
        }
        return null;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
