package com.online.exams.system.core.mybatis.enums;

import com.online.exams.system.core.mybatis.IEnumDesc;
import com.online.exams.system.core.mybatis.IEnumValue;
import com.online.exams.system.core.mybatis.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum UserTypeEnum implements IEnumDesc, IEnumValue {
    COMMON("普通用户", 0),
    MANAGER("管理员", 1),
    ADMIN("系统管理员", 2);

    private String desc;
    private int value;


    UserTypeEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static UserTypeEnum parse(int val) {
        for (UserTypeEnum cycle : UserTypeEnum.values()) {
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
