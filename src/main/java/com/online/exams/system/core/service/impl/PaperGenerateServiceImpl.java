package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.bean.MongoPaper;
import com.online.exams.system.core.bean.QuestionMap;
import com.online.exams.system.core.dao.MongoPaperDao;
import com.online.exams.system.core.dao.PaperDao;
import com.online.exams.system.core.dao.PaperGenerateDao;
import com.online.exams.system.core.model.Paper;
import com.online.exams.system.core.mybatis.enums.PaperTypeEnum;
import com.online.exams.system.core.mybatis.enums.StatusEnum;
import com.online.exams.system.core.mybatis.enums.TagEnum;
import com.online.exams.system.core.service.PaperGenerateService;
import com.online.exams.system.core.util.PaperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang on 2016/3/12.
 */
@Service
public class PaperGenerateServiceImpl implements PaperGenerateService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaperGenerateServiceImpl.class);

    @Autowired
    private PaperGenerateDao paperGenerateDao;

    @Autowired
    private PaperDao paperDao;

    @Autowired
    private MongoPaperDao mongoPaperDao;

    @Override
    public HashMap<String, Object> generateSingleSelection(List<TagEnum> tagEnumList, int uid) {
        List<QuestionMap> resultQuestionMap = new ArrayList<>();
        List<Integer> integers = PaperUtil.getRandomNumberByTotalAndCount(20, tagEnumList.size());
        for (int i = 0; i < tagEnumList.size(); i++) {
            TagEnum tagEnum = tagEnumList.get(i);
            List<QuestionMap> questionMapList = paperGenerateDao.generateSingleSelection(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, integers.get(i));
            resultQuestionMap.addAll(questionMapList);
        }

        return convertQMap2QAndSavePaper(resultQuestionMap, PaperTypeEnum.SINGLE_SELECTION, uid);
    }

    @Override
    public HashMap<String, Object> generateMultiSelection(List<TagEnum> tagEnumList, int uid) {
        List<QuestionMap> resultQuestionMap = new ArrayList<>();
        List<Integer> integers = PaperUtil.getRandomNumberByTotalAndCount(10, tagEnumList.size());
        for (int i = 0; i < tagEnumList.size(); i++) {
            TagEnum tagEnum = tagEnumList.get(i);
            List<QuestionMap> questionMapList = paperGenerateDao.generateMultiSelection(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, integers.get(i));
            resultQuestionMap.addAll(questionMapList);
        }
        return convertQMap2QAndSavePaper(resultQuestionMap, PaperTypeEnum.MULTI_SELECTION, uid);
    }

    @Override
    public HashMap<String, Object> generateProgrammingQuestion(List<TagEnum> tagEnumList, int uid) {
        List<QuestionMap> resultQuestionMap = new ArrayList<>();
        for (int i = 0; i < tagEnumList.size(); i++) {
            TagEnum tagEnum = tagEnumList.get(i);
            List<QuestionMap> questionMapList = paperGenerateDao.generateProgrammingQuestion(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, 1);
            resultQuestionMap.addAll(questionMapList);
        }

        return convertQMap2QAndSavePaper(resultQuestionMap, PaperTypeEnum.PROGRAMMING_QUESTION, uid);
    }

    @Override
    public HashMap<String, Object> generateSingleMultiSelection(List<TagEnum> tagEnumList, int uid) {
        List<QuestionMap> questionMaps = new ArrayList<>();
        for (int i = 0; i < tagEnumList.size(); i++) {
            TagEnum tagEnum = tagEnumList.get(i);

            List<QuestionMap> questionMapList = paperGenerateDao.generateSingleSelection(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, 20);
            questionMaps.addAll(questionMapList);

            questionMapList = paperGenerateDao.generateMultiSelection(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, 10);
            questionMaps.addAll(questionMapList);
        }
        return convertQMap2QAndSavePaper(questionMaps, PaperTypeEnum.SINGLE_AND_MULTI, uid);
    }

    @Override
    public HashMap<String, Object> generateMultiProgrammingSelection(List<TagEnum> tagEnumList, int uid) {
        List<QuestionMap> questionMaps = new ArrayList<>();
        for (int i = 0; i < tagEnumList.size(); i++) {
            TagEnum tagEnum = tagEnumList.get(i);

            List<QuestionMap> questionMapList = paperGenerateDao.generateMultiSelection(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, 10);
            questionMaps.addAll(questionMapList);
        }
        questionMaps.addAll(paperGenerateDao.generateProgrammingQuestion());
        return convertQMap2QAndSavePaper(questionMaps, PaperTypeEnum.MULTI_AND_PROGRAMMING, uid);
    }

    @Override
    public HashMap<String, Object> generateSingleProgrammingQuestion(List<TagEnum> tagEnumList, int uid) {
        List<QuestionMap> questionMaps = new ArrayList<>();
        for (int i = 0; i < tagEnumList.size(); i++) {
            TagEnum tagEnum = tagEnumList.get(i);

            List<QuestionMap> questionMapList = paperGenerateDao.generateSingleSelection(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, 10);
            questionMaps.addAll(questionMapList);
        }
        questionMaps.addAll(paperGenerateDao.generateProgrammingQuestion());
        return convertQMap2QAndSavePaper(questionMaps, PaperTypeEnum.MULTI_AND_PROGRAMMING, uid);
    }

    @Override
    public HashMap<String, Object> generateSingleMultiProgrammingQuestion(List<TagEnum> tagEnumList, int uid) {
        List<QuestionMap> questionMaps = new ArrayList<>();
        for (int i = 0; i < tagEnumList.size(); i++) {
            TagEnum tagEnum = tagEnumList.get(i);

            List<QuestionMap> questionMapList = paperGenerateDao.generateSingleSelection(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, 20);
            questionMaps.addAll(questionMapList);

            questionMapList = paperGenerateDao.generateMultiSelection(tagEnum);
            questionMapList = PaperUtil.generateRandomQuestionListByCount(questionMapList, 10);
            questionMaps.addAll(questionMapList);
        }
        questionMaps.addAll(paperGenerateDao.generateProgrammingQuestion());
        return convertQMap2QAndSavePaper(questionMaps, PaperTypeEnum.SINGLE_AND_MULTI_PROGRAMMING, uid);
    }

    private HashMap<String, Object> convertQMap2QAndSavePaper(List<QuestionMap> questionMaps, PaperTypeEnum paperTypeEnum, int uid) {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (QuestionMap questionMap : questionMaps) {
            questionMap.setRight(false);
            questionMap.setCurrentAnswer("");
        }
        MongoPaper mongoPaper = new MongoPaper();
        mongoPaper.setQuestionMapList(questionMaps);
        mongoPaper.setUserId(uid);
        mongoPaper.setCreateAt(new Date());
        mongoPaper.setUpdateAt(new Date());
        int mpid = mongoPaperDao.addPaper(mongoPaper).intValue();

        Paper paper = new Paper();
        paper.setMongoPaperId(mpid);
        paper.setCreateAt(mongoPaper.getCreateAt());
        paper.setUpdateAt(mongoPaper.getUpdateAt());
        paper.setUserId(uid);
        paper.setPaperType(paperTypeEnum);
        paper.setScore(0.0);
        paper.setTotalRight(0);
        paper.setDifficulty(new BigDecimal(PaperUtil.calculateAverageDifficultyOfQuestionMap(questionMaps)).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue());
        paper.setStatus(StatusEnum.NORMAL);
        paperDao.savePaper(paper);

        hashMap.put("questions", questionMaps);
        hashMap.put("pid", paper.getId());
        hashMap.put("time", paper.getCreateAt());
        return hashMap;
    }
}
