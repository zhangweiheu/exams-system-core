package com.online.exams.system.core.service;

import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.mybatis.enums.RefTypeEnum;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
public interface TagService {
    List<Tag> findAllTagByTagAttr(Tag tag);

    int deleteTagByTagAttr(Tag tag);

    int saveTag(Tag tag);

    int updateTag(Tag tag);

    int saveTagList(List<Tag> tagList);

    int updateTagList(List<Tag> tagList);

    int saveTagList(String tagList, int refId, RefTypeEnum refType);

    int updateTagList(String tagList, int refId, RefTypeEnum refType);

}
