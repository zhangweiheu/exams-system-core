package com.online.exams.system.core.dao;

import com.online.exams.system.core.enums.TagEnum;
import com.online.exams.system.core.model.Tag;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
public interface TagDao extends AbstractDao{
    List<Tag> findAllTagByRefid(int uid);
    boolean deleteTagByUidAndTagType(int uid,TagEnum tagEnum);
    boolean addTagToUser(int uid,TagEnum tagEnum);
}
