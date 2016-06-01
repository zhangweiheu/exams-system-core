package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.TagDao;
import com.online.exams.system.core.mapper.TagMapper;
import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.model.TagCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Repository
public class TagDaoImpl implements TagDao {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> findAllTagByTagAttr(Tag tag) {
        return tagMapper.selectByCondition(convertTagAttr2Condition(tag));
    }

    @Override
    public int deleteTagByTagAttr(Tag tag) {
        TagCondition tagCondition = convertTagAttr2Condition(tag);
        return null == tagCondition ? 0 : tagMapper.deleteByCondition(tagCondition);
    }

    @Override
    public int saveTag(Tag tag) {
        tag.setCreateAt(new Date());
        tag.setUpdateAt(new Date());
        return tagMapper.insert(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        tag.setUpdateAt(new Date());
        return tagMapper.updateByIdSelective(tag);
    }

    @Override
    public Tag findById(int id) {
        return tagMapper.selectById(id);
    }

    @Override
    public List<Tag> findAll() {
        return tagMapper.selectByCondition(convertTagAttr2Condition(null));
    }

    @Override
    public int deleteById(int id) {
        return tagMapper.deleteById(id);
    }

    @Override
    public int deleteTagList(List<Tag> tagList) {
        int i = 0;
        if (CollectionUtils.isEmpty(tagList)) {
            return i;
        }
        for (Tag tag : tagList) {

            TagCondition tagCondition = convertTagAttr2Condition(tag);
            i += (null == tagCondition ? 0 : tagMapper.deleteByCondition(tagCondition));
        }
        return i;
    }

    @Override
    public int saveTagList(List<Tag> tagList) {
        int i = 0;
        if (CollectionUtils.isEmpty(tagList)) {
            return i;
        }
        for (Tag tag : tagList) {
            tag.setCreateAt(new Date());
            tag.setUpdateAt(new Date());
            i += tagMapper.insertSelective(tag);
        }
        return i;
    }

    @Override
    public int updateTagList(List<Tag> tagList) {
        if (CollectionUtils.isEmpty(tagList)) {
            return 0;
        }
        Tag tag1 = new Tag();
        tag1.setRefId(tagList.get(0).getRefId());
        tag1.setRefType(tagList.get(0).getRefType());
        deleteTagList(tagMapper.selectByCondition(convertTagAttr2Condition(tag1)));
        return saveTagList(tagList);
    }

    private TagCondition convertTagAttr2Condition(Tag tag) {
        TagCondition condition = new TagCondition();
        TagCondition.Criteria criteria = condition.createCriteria();

        if (null == tag) {
            return condition;
        }
        if (null != tag.getId()) {
            criteria.andIdEqualTo(tag.getId());
        }
        if (null != tag.getRefId()) {
            criteria.andRefIdEqualTo(tag.getRefId());
        }
        if (null != tag.getRefType()) {
            criteria.andRefTypeEqualTo(tag.getRefType());
        }
        if (null != tag.getTagValue()) {
            criteria.andTagValueEqualTo(tag.getTagValue());
        }
        condition.or(criteria);
        return condition;
    }
}
