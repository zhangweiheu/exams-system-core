package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.TagDao;
import com.online.exams.system.core.enums.TagEnum;
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
    public Object findById(int tid) {
        return tagMapper.selectById(tid);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public int deleteById(int tid) {
        return tagMapper.deleteById(tid);
    }

    @Override
    public List<Tag> findAllTagByRefid(int refid) {
        TagCondition condition = new TagCondition();
        condition.createCriteria().andRefIdEqualTo(refid);
        return tagMapper.selectByCondition(condition);
    }

    @Override
    public boolean deleteTagByUidAndTagType(int uid, TagEnum tagEnum) {
        return false;
    }

    @Override
    public boolean addTagToUser(int uid, TagEnum tagEnum) {
        return false;
    }
}
