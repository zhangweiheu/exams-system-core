package com.online.exams.system.core.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Vincent on 2015/5/23.
 * brief desc : 主键生成的存储bean
 */
@Document(collection = "smsmail_primary_key")
public class MongoPrimaryKey {
//// TODO: 2016/3/11 mongo 
    @Id
    private String serialKey;
    @Field("serial_value")
    private Long serialValue;

    public String getSerialKey() {
        return serialKey;
    }

    public void setSerialKey(String serialKey) {
        this.serialKey = serialKey;
    }

    public Long getSerialValue() {
        return serialValue;
    }

    public void setSerialValue(Long serialValue) {
        this.serialValue = serialValue;
    }
}
