package com.online.exams.system.core.model;

import com.online.exams.system.core.enums.QuestionStatusEnum;
import com.online.exams.system.core.enums.QuestionTypeEnum;
import java.io.Serializable;
import java.util.Date;

/**
 * graduation.question  
 *
 * @author zhang
 * @date 2016-3-11
 *
 */
public class Question implements Serializable {
    /** id */
    private Integer id;

    /** 试题类型，枚举：0单选 | 1多选 | 2编程题 */
    private QuestionTypeEnum type;

    /** 试题主干 */
    private String title;

    /** 试题选项 */
    private String options;

    /** 试题答案， 编程题：test_case的id； */
    private String answers;

    /** 难度系数1-10 */
    private Integer difficulty;

    /** 优先级1-10 */
    private Integer priority;

    /** 题目状态，枚举：0正常 | 1已删除 | 2有错误 */
    private QuestionStatusEnum status;

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

    public QuestionTypeEnum getType() {
        return type;
    }

    public void setType(QuestionTypeEnum type) {
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

    public QuestionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(QuestionStatusEnum status) {
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