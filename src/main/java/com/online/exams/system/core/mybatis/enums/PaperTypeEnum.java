package com.online.exams.system.core.mybatis.enums;

import com.online.exams.system.core.mybatis.IEnumDesc;
import com.online.exams.system.core.mybatis.IEnumValue;
import com.online.exams.system.core.mybatis.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum PaperTypeEnum implements IEnumDesc, IEnumValue {

    SINGLE_SELECTION("单选", 0),
    MULTI_SELECTION("多选", 1),
    PROGRAMMING_QUESTION("编程题", 2),
    SINGLE_AND_MULTI("单选和多选", 3),
    SINGLE_AND_PROGRAMMING("单选和编程题", 4),
    MULTI_AND_PROGRAMMING("多选和编程题", 5),
    SINGLE_AND_MULTI_PROGRAMMING("单选和多选和编程题", 6);


    private String desc;
    private int value;


    PaperTypeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static PaperTypeEnum parse(int val) {
        for (PaperTypeEnum cycle : PaperTypeEnum.values()) {
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
