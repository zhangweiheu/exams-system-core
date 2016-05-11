package com.online.exams.system.core.mybatis.enums;

import com.online.exams.system.core.mybatis.IEnumDesc;
import com.online.exams.system.core.mybatis.IEnumValue;
import com.online.exams.system.core.mybatis.ParseNameReplaceValue;

@ParseNameReplaceValue
public enum UserStatusEnum implements IEnumDesc, IEnumValue {
    AUDITING("待审核", 0),
    REFUSE("审核不通过", 1),
    NORMAL("审核通过", 2),
    DELETED("已删除", 3),
    BLACK("黑名单", 4);

    private String desc;
    private int value;


    UserStatusEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static UserStatusEnum parse(int val) {
        for (UserStatusEnum cycle : UserStatusEnum.values()) {
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
