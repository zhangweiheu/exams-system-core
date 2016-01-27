package com.online.exams.system.core.mapper;

import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.model.TagCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {
    int countByCondition(TagCondition example);

    int deleteByCondition(TagCondition example);

    int deleteById(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByCondition(TagCondition example);

    Tag selectById(Integer id);

    int updateByConditionSelective(@Param("record") Tag record, @Param("example") TagCondition example);

    int updateByCondition(@Param("record") Tag record, @Param("example") TagCondition example);

    int updateByIdSelective(Tag record);

    int updateById(Tag record);
}