package com.online.exams.system.core.model;

import com.online.exams.system.core.enums.PaperTypeEnum;
import com.online.exams.system.core.enums.StatusEnum;
import java.io.Serializable;
import java.util.Date;

/**
 * graduation.paper  
 *
 * @author zhang
 * @date 2016-3-16
 *
 */
public class Paper implements Serializable {
    /** id */
    private Integer id;

    /** 用户 id */
    private Integer userId;

    /** mongo试卷 id */
    private Integer mongoPaperId;

    /** 试卷类型,枚举：0单选题 | 1多选题 | 2编程题 | 3单选、多选 | 4单选、编程 | 5多选、编程 | 6单选多选和编程题 */
    private PaperTypeEnum paperType;

    /** 难度系数0-10 */
    private Integer difficulty;

    /** 总做对题数 */
    private Integer totalRight;

    /** 总分 */
    private Integer totalPoints;

    /** 得分 */
    private Integer score;

    /** 状态：0正常 | 1删除 | 2有错误 | 3关闭 */
    private StatusEnum status;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMongoPaperId() {
        return mongoPaperId;
    }

    public void setMongoPaperId(Integer mongoPaperId) {
        this.mongoPaperId = mongoPaperId;
    }

    public PaperTypeEnum getPaperType() {
        return paperType;
    }

    public void setPaperType(PaperTypeEnum paperType) {
        this.paperType = paperType;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getTotalRight() {
        return totalRight;
    }

    public void setTotalRight(Integer totalRight) {
        this.totalRight = totalRight;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
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