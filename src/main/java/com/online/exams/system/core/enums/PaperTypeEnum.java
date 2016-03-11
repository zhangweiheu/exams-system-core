package com.online.exams.system.core.enums;

import com.online.exams.system.core.enums.mybatis.IEnumDesc;
import com.online.exams.system.core.enums.mybatis.IEnumValue;
import com.online.exams.system.core.enums.mybatis.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum PaperTypeEnum implements IEnumDesc, IEnumValue {

    SINGLE_SELECTION("单选", 0),
    MULTI_SELECTION("多选", 1),
    PROGRAMMING_QUESTION("编程题", 2),
    SINGLE_AND_MULTI("单选和多选",3),
    SINGLE_AND_PROGRAMMING("单选和编程题",4),
    MULTI_AND_PROGRAMMING("多选和编程题",5);


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
