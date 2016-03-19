package com.online.exams.system.core.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by zhang on 2016/3/12.
 */
@Document(collection = "test_case")
public class TestCase {
    /**
     * test case id
     */
    @Id
    @Indexed(unique = true)
    private Long id;


    /**
     * 键值对
     */
    @Field("keyValue")
    private HashMap<String, String> keyValue;

    /**
     * 创建时间
     */
    @Field("createAt")
    private Date createAt;

    /**
     * 更新时间
     */
    @Field("updateAt")
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashMap<String, String> getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(HashMap<String, String> keyValue) {
        this.keyValue = keyValue;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
