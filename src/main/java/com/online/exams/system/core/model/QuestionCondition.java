package com.online.exams.system.core.model;

import com.online.exams.system.core.mybatis.enums.QuestionTypeEnum;
import com.online.exams.system.core.mybatis.enums.StatusEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitOffset = -1;

    protected int limitSize = 1;

    public QuestionCondition() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitOffset(int limitOffset) {
        this.limitOffset = limitOffset;
    }

    public void setLimitSize(int limitSize) {
        this.limitSize = limitSize;
    }

    public int getLimitOffset() {
        return limitOffset;
    }

    public int getLimitSize() {
        return limitSize;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNull() {
            addCriterion("question_type is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNotNull() {
            addCriterion("question_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeEqualTo(QuestionTypeEnum value) {
            addCriterion("question_type =", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotEqualTo(QuestionTypeEnum value) {
            addCriterion("question_type <>", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThan(QuestionTypeEnum value) {
            addCriterion("question_type >", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThanOrEqualTo(QuestionTypeEnum value) {
            addCriterion("question_type >=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThan(QuestionTypeEnum value) {
            addCriterion("question_type <", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThanOrEqualTo(QuestionTypeEnum value) {
            addCriterion("question_type <=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIn(List<QuestionTypeEnum> values) {
            addCriterion("question_type in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotIn(List<QuestionTypeEnum> values) {
            addCriterion("question_type not in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeBetween(QuestionTypeEnum value1, QuestionTypeEnum value2) {
            addCriterion("question_type between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotBetween(QuestionTypeEnum value1, QuestionTypeEnum value2) {
            addCriterion("question_type not between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNull() {
            addCriterion("options is null");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNotNull() {
            addCriterion("options is not null");
            return (Criteria) this;
        }

        public Criteria andOptionsEqualTo(String value) {
            addCriterion("options =", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotEqualTo(String value) {
            addCriterion("options <>", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThan(String value) {
            addCriterion("options >", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThanOrEqualTo(String value) {
            addCriterion("options >=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThan(String value) {
            addCriterion("options <", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThanOrEqualTo(String value) {
            addCriterion("options <=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLike(String value) {
            addCriterion("options like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotLike(String value) {
            addCriterion("options not like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsIn(List<String> values) {
            addCriterion("options in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotIn(List<String> values) {
            addCriterion("options not in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsBetween(String value1, String value2) {
            addCriterion("options between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotBetween(String value1, String value2) {
            addCriterion("options not between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andAnswersIsNull() {
            addCriterion("answers is null");
            return (Criteria) this;
        }

        public Criteria andAnswersIsNotNull() {
            addCriterion("answers is not null");
            return (Criteria) this;
        }

        public Criteria andAnswersEqualTo(String value) {
            addCriterion("answers =", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersNotEqualTo(String value) {
            addCriterion("answers <>", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersGreaterThan(String value) {
            addCriterion("answers >", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersGreaterThanOrEqualTo(String value) {
            addCriterion("answers >=", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersLessThan(String value) {
            addCriterion("answers <", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersLessThanOrEqualTo(String value) {
            addCriterion("answers <=", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersLike(String value) {
            addCriterion("answers like", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersNotLike(String value) {
            addCriterion("answers not like", value, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersIn(List<String> values) {
            addCriterion("answers in", values, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersNotIn(List<String> values) {
            addCriterion("answers not in", values, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersBetween(String value1, String value2) {
            addCriterion("answers between", value1, value2, "answers");
            return (Criteria) this;
        }

        public Criteria andAnswersNotBetween(String value1, String value2) {
            addCriterion("answers not between", value1, value2, "answers");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(Integer value) {
            addCriterion("difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(Integer value) {
            addCriterion("difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(Integer value) {
            addCriterion("difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(Integer value) {
            addCriterion("difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<Integer> values) {
            addCriterion("difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<Integer> values) {
            addCriterion("difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("difficulty not between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(StatusEnum value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(StatusEnum value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(StatusEnum value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(StatusEnum value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(StatusEnum value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(StatusEnum value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<StatusEnum> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<StatusEnum> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(StatusEnum value1, StatusEnum value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(StatusEnum value1, StatusEnum value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTotalDoneIsNull() {
            addCriterion("total_done is null");
            return (Criteria) this;
        }

        public Criteria andTotalDoneIsNotNull() {
            addCriterion("total_done is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDoneEqualTo(Integer value) {
            addCriterion("total_done =", value, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneNotEqualTo(Integer value) {
            addCriterion("total_done <>", value, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneGreaterThan(Integer value) {
            addCriterion("total_done >", value, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_done >=", value, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneLessThan(Integer value) {
            addCriterion("total_done <", value, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneLessThanOrEqualTo(Integer value) {
            addCriterion("total_done <=", value, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneIn(List<Integer> values) {
            addCriterion("total_done in", values, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneNotIn(List<Integer> values) {
            addCriterion("total_done not in", values, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneBetween(Integer value1, Integer value2) {
            addCriterion("total_done between", value1, value2, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalDoneNotBetween(Integer value1, Integer value2) {
            addCriterion("total_done not between", value1, value2, "totalDone");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessIsNull() {
            addCriterion("total_success is null");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessIsNotNull() {
            addCriterion("total_success is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessEqualTo(Integer value) {
            addCriterion("total_success =", value, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessNotEqualTo(Integer value) {
            addCriterion("total_success <>", value, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessGreaterThan(Integer value) {
            addCriterion("total_success >", value, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_success >=", value, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessLessThan(Integer value) {
            addCriterion("total_success <", value, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessLessThanOrEqualTo(Integer value) {
            addCriterion("total_success <=", value, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessIn(List<Integer> values) {
            addCriterion("total_success in", values, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessNotIn(List<Integer> values) {
            addCriterion("total_success not in", values, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessBetween(Integer value1, Integer value2) {
            addCriterion("total_success between", value1, value2, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("total_success not between", value1, value2, "totalSuccess");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}