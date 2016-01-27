package com.online.exams.system.core.util.mongo;

/**
 * Created by vincent on 15/9/1.
 */
public enum SortOrderType {

    ASC("升序"), DESC("降序");

    private String desc;

    SortOrderType(String val) {
        this.desc = val;
    }
}
