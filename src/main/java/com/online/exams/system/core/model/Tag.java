package com.online.exams.system.core.model;

import com.online.exams.system.core.mybatis.enums.RefTypeEnum;
import com.online.exams.system.core.mybatis.enums.TagEnum;
import java.io.Serializable;
import java.util.Date;

/**
 * graduation.tag  
 *
 * @author zhang
 * @date 2016-5-6
 *
 */
public class Tag implements Serializable {
    /** id */
    private Integer id;

    /** 关联 id */
    private Integer refId;

    /** 关联类型，枚举：0用户 | 1试题 | 2试卷 */
    private RefTypeEnum refType;

    /** tag value： 0java | 1html | 2操作系统｜３计算机网络｜４ＣＳＳ */
    private TagEnum tagValue;

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

    public RefTypeEnum getRefType() {
        return refType;
    }

    public void setRefType(RefTypeEnum refType) {
        this.refType = refType;
    }

    public TagEnum getTagValue() {
        return tagValue;
    }

    public void setTagValue(TagEnum tagValue) {
        this.tagValue = tagValue;
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