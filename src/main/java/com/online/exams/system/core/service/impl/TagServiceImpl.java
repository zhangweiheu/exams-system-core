package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.TagDao;
import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.mybatis.enums.RefTypeEnum;
import com.online.exams.system.core.mybatis.enums.TagEnum;
import com.online.exams.system.core.service.PaperService;
import com.online.exams.system.core.service.QuestionService;
import com.online.exams.system.core.service.TagService;
import com.online.exams.system.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaperService paperService;

    @Override
    public List<Tag> findAllTagByTagAttr(Tag tag) {
        return tagDao.findAllTagByTagAttr(tag);
    }

    @Override
    public int deleteTagByTagAttr(Tag tag) {
        return tagDao.deleteTagByTagAttr(tag);
    }

    @Override
    public int saveTag(Tag tag) {
        return tagDao.saveTag(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    @Override
    public int saveTagList(List<Tag> tagList) {
        return tagDao.saveTagList(tagList);
    }

    @Override
    public int updateTagList(List<Tag> tagList) {
        return tagDao.updateTagList(tagList);
    }

    @Override
    public int saveTagList(String tagList, int refId, RefTypeEnum refType) {
        return saveTagList(convertStringTagList2TagList(tagList, refId, refType));
    }

    @Override
    public int updateTagList(String tagList, int refId, RefTypeEnum refType) {
        if (StringUtils.isEmpty(tagList)) {
            Tag tag = new Tag();
            tag.setRefId(refId);
            tag.setRefType(refType);
            deleteTagByTagAttr(tag);
        }
        return updateTagList(convertStringTagList2TagList(tagList, refId, refType));
    }

    private List<Tag> convertStringTagList2TagList(String enumList, int refId, RefTypeEnum refType) {
        List<Tag> tagList = new ArrayList<>();
        if (null == refType || StringUtils.isEmpty(enumList)) {
            return tagList;
        }
        if (RefTypeEnum.USER.equals(refType) && null == userService.findUserByUid(refId)) {
            return tagList;
        }
        if (RefTypeEnum.QUESTION.equals(refType) && null == questionService.findQuestionById(refId)) {
            return tagList;
        }
        if (RefTypeEnum.PAPER.equals(refType) && null == paperService.findPaperById(refId)) {
            return tagList;
        }
        String[] chars = enumList.split(",");
        for (String c : chars) {
            Tag tag = new Tag();
            tag.setRefId(refId);
            tag.setRefType(refType);
            tag.setTagValue(TagEnum.valueOf(c));
            tagList.add(tag);
        }
        return tagList;
    }
}
