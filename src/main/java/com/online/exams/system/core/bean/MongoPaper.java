package com.online.exams.system.core.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang on 2016/3/12.
 */
@Document(collection = "mongo_paper")
public class MongoPaper {
    /**
     * 试卷id
     */
    @Id
    @Indexed(unique = true)
    private Long id;

    @Field("userId")
    private int userId;
    /**
     * 试卷内容
     */
    @Field("questionMapList")
    private List<QuestionMap> questionMapList;

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

    public List<QuestionMap> getQuestionMapList() {
        return questionMapList;
    }

    public void setQuestionMapList(List<QuestionMap> questionMapList) {
        this.questionMapList = questionMapList;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
