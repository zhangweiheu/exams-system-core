package com.online.exams.system.core.enums;

import com.online.exams.system.core.enums.mybatis.IEnumDesc;
import com.online.exams.system.core.enums.mybatis.IEnumValue;
import com.online.exams.system.core.enums.mybatis.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum RefTypeEnum implements IEnumDesc, IEnumValue {
    USER("用户", 0),
    QUESTION("试题", 1),
    PAPER("试卷", 2);

    private String desc;
    private int value;


    RefTypeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static RefTypeEnum parse(int val) {
        for (RefTypeEnum cycle : RefTypeEnum.values()) {
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
