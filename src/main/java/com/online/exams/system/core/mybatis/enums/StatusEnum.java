package com.online.exams.system.core.mybatis.enums;

import com.online.exams.system.core.mybatis.IEnumDesc;
import com.online.exams.system.core.mybatis.IEnumValue;
import com.online.exams.system.core.mybatis.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum StatusEnum implements IEnumDesc, IEnumValue {
    NORMAL("正常", 0),
    DELETE("已删除", 1),
    WRONG("有错误", 2),
    CLOSE("关闭", 3);

    private String desc;
    private int value;


    StatusEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static StatusEnum parse(int val) {
        for (StatusEnum cycle : StatusEnum.values()) {
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
