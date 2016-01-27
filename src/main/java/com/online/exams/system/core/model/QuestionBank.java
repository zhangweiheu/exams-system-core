package com.online.exams.system.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * graduation.question_bank  
 *
 * @author 36kr
 * @date 2016-1-27
 *
 */
public class QuestionBank implements Serializable {
    /** id */
    private Integer id;

    /** 试题类型，枚举：0用户 | 1试题 */
    private Integer type;

    /** 试题标题 */
    private String title;

    /** 试题选项 */
    private String options;

    /** 试题答案 */
    private String answers;

    /** 难度系数0-10 */
    private Integer difficulty;

    /** 优先级0-10 */
    private Integer priority;

    /** 题目状态，枚举： */
    private Integer status;

    /** 总完成数 */
    private Integer totalDone;

    /** 总正确数 */
    private Integer totalSuccess;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers == null ? null : answers.trim();
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
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