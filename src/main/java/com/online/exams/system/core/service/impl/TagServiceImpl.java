package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.TagDao;
import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagDao tagDao;

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
}
