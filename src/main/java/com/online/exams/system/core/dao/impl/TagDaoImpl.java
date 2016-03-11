package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.TagDao;
import com.online.exams.system.core.mapper.TagMapper;
import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.model.TagCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Repository
public class TagDaoImpl implements TagDao {
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> findAllTagByTagAttr(Tag tag) {
        return tagMapper.selectByCondition(convertTagAttr2Condition(tag));
    }

    @Override
    public int deleteTagByTagAttr(Tag tag) {
        return tagMapper.deleteByCondition(convertTagAttr2Condition(tag));
    }

    @Override
    public int saveTag(Tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateByIdSelective(tag);
    }

    @Override
    public Object findById(int id) {
        return tagMapper.selectById(id);
    }

    @Override
    public List findAll() {
        return tagMapper.selectByCondition(convertTagAttr2Condition(null));
    }

    @Override
    public int deleteById(int id) {
        return tagMapper.deleteById(id);
    }

    @Override
    public int deleteTagByListId(List<Integer> list) {
        int i = 0;
        for(Integer id : list)
        {
            if(tagMapper.deleteById(id) > 0){
                i++;
            }
        }
        return i;
    }

    private TagCondition convertTagAttr2Condition(Tag tag) {
        TagCondition condition = new TagCondition();

        if (null == tag) {
            return condition;
        }
        if (null != tag.getId()) {
            condition.createCriteria().andIdEqualTo(tag.getId());
        }
        if (null != tag.getRefId()) {
            condition.createCriteria().andRefIdEqualTo(tag.getRefId());
        }
        if (null != tag.getRefType()) {
            condition.createCriteria().andRefTypeEqualTo(tag.getRefType());
        }
        if (null != tag.getEnumValue()) {
            condition.createCriteria().andEnumValueEqualTo(tag.getEnumValue());
        }
        return condition;
    }
}
