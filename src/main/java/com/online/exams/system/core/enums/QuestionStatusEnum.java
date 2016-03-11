package com.online.exams.system.core.enums;

import com.online.exams.system.core.enums.mybatis.IEnumDesc;
import com.online.exams.system.core.enums.mybatis.IEnumValue;
import com.online.exams.system.core.enums.mybatis.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum QuestionStatusEnum implements IEnumDesc, IEnumValue {
    NORMAL("正常", 0),
    DELETE("已删除", 1),
    WRONG("有错误", 2);

    private String desc;
    private int value;


    QuestionStatusEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static QuestionStatusEnum parse(int val) {
        for (QuestionStatusEnum cycle : QuestionStatusEnum.values()) {
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
