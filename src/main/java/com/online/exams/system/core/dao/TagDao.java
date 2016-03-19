package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.Tag;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
public interface TagDao {
    List<Tag> findAll();

    Tag findById(int id);

    int deleteById(int id);

    List<Tag> findAllTagByTagAttr(Tag tag);

    int deleteTagByTagAttr(Tag tag);

    int saveTag(Tag tag);

    int updateTag(Tag tag);

    int deleteTagList(List<Tag> tagList);

    int saveTagList(List<Tag> tagList);

    int updateTagList(List<Tag> tagList);
}
