package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.bean.MongoPaper;
import com.online.exams.system.core.bean.QuestionMap;
import com.online.exams.system.core.dao.*;
import com.online.exams.system.core.mybatis.enums.*;
import com.online.exams.system.core.mapper.UserMapper;
import com.online.exams.system.core.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by zhang on 2016/4/6.
 */
@Repository
public class DataDaoImpl implements DataDao {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MongoPaperDao mongoPaperDao;

    @Autowired
    private PaperDao paperDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<User> getAllTotalScoreOrder(int offset, int pageSize) {
        UserCondition condition = new UserCondition();
        UserCondition.Criteria criteria = condition.createCriteria();
        criteria.andTotalDoneIsNotNull();
        criteria.andStatusEqualTo(UserStatusEnum.NORMAL);
        criteria.andTypeEqualTo(UserTypeEnum.COMMON);
        condition.setOrderByClause("total_score");
        condition.or(criteria);
        condition.setLimitOffset(offset);
        condition.setLimitSize(pageSize);
        List<User> userList = userMapper.selectByCondition(condition);
        for (User user : userList) {
            user.setCreateAt(null);
            user.setAvatar(null);
            user.setPassword(null);
            user.setEmail(null);
            user.setPhone(null);
            user.setIntro(null);
            user.setWechat(null);
            user.setUpdateAt(null);
            user.setId(null);
        }
        return userList;
    }


    @Override
    public LinkedHashMap<String, Integer> getUserPaperTendency(Integer uid) {
        List<Paper> paperList = paperDao.findAllDonePaperByUid(uid);

        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();

        for (Paper paper : paperList) {
            hashMap.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paper.getCreateAt()), paper.getScore().intValue());
        }

        return hashMap;
    }

    @Override
    public HashMap<String, Integer> getAnalysisDataByQuestionType(Integer uid) {
        List<Paper> paperList = paperDao.findAllDonePaperByUid(uid);
        HashMap<String, Integer> questionTypeEnumIntegerHashMap = new HashMap<>();

        questionTypeEnumIntegerHashMap.put("单选", 0);
        questionTypeEnumIntegerHashMap.put("多选", 0);
        questionTypeEnumIntegerHashMap.put("编程题", 0);

        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.SINGLE_SELECTION.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.MULTI_SELECTION.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.PROGRAMMING_QUESTION.getDesc() + "Right", 0);

        questionTypeEnumIntegerHashMap.put(TagEnum.CSS.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.JAVA.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HIBERNATE.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HTML.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.NETWORK.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SPRING.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SYSTEM.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.MYSQL.getDesc(), 0);

        questionTypeEnumIntegerHashMap.put(TagEnum.CSS.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.JAVA.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HIBERNATE.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HTML.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.NETWORK.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SPRING.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SYSTEM.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.MYSQL.getDesc() + "Right", 0);

        for (Paper paper : paperList) {
            MongoPaper mongoPaper = mongoPaperDao.findMongoPaperById(Integer.toUnsignedLong(paper.getMongoPaperId()));

            List<QuestionMap> questionMapList = mongoPaper.getQuestionMapList();

            for (QuestionMap questionMap : questionMapList) {

                /**type分析*/
                questionTypeEnumIntegerHashMap.replace(questionMap.getQuestionType().getDesc(),
                        questionTypeEnumIntegerHashMap.get(questionMap.getQuestionType().getDesc()) + 1);

                if (questionMap.getRight()) {
                    questionTypeEnumIntegerHashMap.replace(
                            questionMap.getQuestionType().getDesc() + "Right",
                            questionTypeEnumIntegerHashMap.get(questionMap.getQuestionType().getDesc() + "Right") + 1);
                }

                /**tag分析*/
                Tag newTag = new Tag();
                newTag.setRefType(RefTypeEnum.QUESTION);
                newTag.setRefId(questionMap.getId());
                List<Tag> tagList = tagDao.findAllTagByTagAttr(newTag);

                for (Tag tag : tagList) {
                    questionTypeEnumIntegerHashMap.replace(tag.getTagValue().getDesc(),
                            questionTypeEnumIntegerHashMap.get(tag.getTagValue().getDesc()) + 1);

                    if (questionMap.getRight()) {
                        questionTypeEnumIntegerHashMap.replace(
                                tag.getTagValue().getDesc() + "Right", questionTypeEnumIntegerHashMap.get(tag.getTagValue().getDesc() + "Right") + 1);
                    }
                }
            }
        }
        return questionTypeEnumIntegerHashMap;
    }


    @Override
    public HashMap<String, Integer> getAnalysisDataByQuestionType() {
        HashMap<String, Integer> questionTypeEnumIntegerHashMap = new HashMap<>();

        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.SINGLE_SELECTION.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.MULTI_SELECTION.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.PROGRAMMING_QUESTION.getDesc(), 0);

        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.SINGLE_SELECTION.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.MULTI_SELECTION.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.PROGRAMMING_QUESTION.getDesc() + "Done", 0);

        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.SINGLE_SELECTION.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.MULTI_SELECTION.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(QuestionTypeEnum.PROGRAMMING_QUESTION.getDesc() + "Right", 0);

        questionTypeEnumIntegerHashMap.put(TagEnum.CSS.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.JAVA.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HIBERNATE.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HTML.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.NETWORK.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SPRING.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SYSTEM.getDesc(), 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.MYSQL.getDesc(), 0);

        questionTypeEnumIntegerHashMap.put(TagEnum.CSS.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.JAVA.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HIBERNATE.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HTML.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.NETWORK.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SPRING.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SYSTEM.getDesc() + "Done", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.MYSQL.getDesc() + "Done", 0);

        questionTypeEnumIntegerHashMap.put(TagEnum.CSS.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.JAVA.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HIBERNATE.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.HTML.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.NETWORK.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SPRING.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.SYSTEM.getDesc() + "Right", 0);
        questionTypeEnumIntegerHashMap.put(TagEnum.MYSQL.getDesc() + "Right", 0);


        List<Question> questionMapList = questionDao.findQuestionByAttr(null);

        for (Question question : questionMapList) {

            /**type分析*/
            questionTypeEnumIntegerHashMap.replace(question.getQuestionType().getDesc(),
                    questionTypeEnumIntegerHashMap.get(question.getQuestionType().getDesc()) + 1);

            questionTypeEnumIntegerHashMap.replace(
                    question.getQuestionType().getDesc() + "Done",
                    questionTypeEnumIntegerHashMap.get(question.getQuestionType().getDesc() + "Done") + question.getTotalDone());

            questionTypeEnumIntegerHashMap.replace(
                    question.getQuestionType().getDesc() + "Right",
                    questionTypeEnumIntegerHashMap.get(question.getQuestionType().getDesc() + "Right") + question.getTotalSuccess());

            /**tag分析*/
            Tag newTag = new Tag();
            newTag.setRefType(RefTypeEnum.QUESTION);
            newTag.setRefId(question.getId());
            List<Tag> tagList = tagDao.findAllTagByTagAttr(newTag);

            if (null == tagList) {
                continue;
            }

            for (Tag tag : tagList) {
                questionTypeEnumIntegerHashMap.replace(tag.getTagValue().getDesc(),
                        questionTypeEnumIntegerHashMap.get(tag.getTagValue().getDesc()) + 1);


                questionTypeEnumIntegerHashMap.replace(
                        tag.getTagValue().getDesc() + "Done",
                        questionTypeEnumIntegerHashMap.get(tag.getTagValue().getDesc() + "Done") + question.getTotalDone());

                questionTypeEnumIntegerHashMap.replace(
                        tag.getTagValue().getDesc() + "Right",
                        questionTypeEnumIntegerHashMap.get(tag.getTagValue().getDesc() + "Right") + question.getTotalSuccess());
            }
        }
        return questionTypeEnumIntegerHashMap;
    }
}
