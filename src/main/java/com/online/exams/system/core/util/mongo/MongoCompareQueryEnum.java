package com.online.exams.system.core.util.mongo;

/**
 * Created by Vincent on 2015/5/22.
 * brief desc :  创建查询的条件 比较 范围  equals
 */
public enum MongoCompareQueryEnum {

    GT(1,"大于"),
    LT(2,"小于"),
    GTE(3,"大于等于"),
    LTE(4,"小于等于");

    private int val;
    private String desc;

    MongoCompareQueryEnum(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
