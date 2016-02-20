package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.enums.TagEnum;
import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Service
public class TagServiceImpl implements TagService{
    @Override
    public List<Tag> findAllTagByUid(int uid) {
        return null;
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
