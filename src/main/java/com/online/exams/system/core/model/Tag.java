package com.online.exams.system.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * graduation.tag  
 *
 * @author 36kr
 * @date 2016-1-28
 *
 */
public class Tag implements Serializable {
    /** id */
    private Integer id;

    /** 关联 id */
    private Integer refId;

    /** tag类型，枚举：0用户 | 1试题 | 2Java 试题 */
    private Integer type;

    /** 标签内容 */
    private String content;

    /** 创建时间 */
    private Date createAt;

    /** 更新时间 */
    private Date updateAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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