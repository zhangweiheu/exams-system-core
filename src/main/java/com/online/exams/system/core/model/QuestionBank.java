package com.online.exams.system.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * graduation.question_bank  
 *
 * @author 36kr
 * @date 2016-1-25
 *
 */
public class QuestionBank implements Serializable {
    /** id */
    private Integer id;

    /** 题目 */
    private Integer content;

    /** 选项 */
    private Integer options;

    /** 答案 */
    private String answers;

    /** 难度系数 */
    private Float difficulty;

    /** 总完成数 */
    private Integer totalDone;

    /** 做对总数 */
    private Integer totalSuccess;

    /** 优先级 */
    private Integer priority;

    /** 状态 */
    private Integer status;

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

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Integer getOptions() {
        return options;
    }

    public void setOptions(Integer options) {
        this.options = options;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers == null ? null : answers.trim();
    }

    public Float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Float difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getTotalDone() {
        return totalDone;
    }

    public void setTotalDone(Integer totalDone) {
        this.totalDone = totalDone;
    }

    public Integer getTotalSuccess() {
        return totalSuccess;
    }

    public void setTotalSuccess(Integer totalSuccess) {
        this.totalSuccess = totalSuccess;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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