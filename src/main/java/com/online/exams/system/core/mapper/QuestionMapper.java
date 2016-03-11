package com.online.exams.system.core.mapper;

import com.online.exams.system.core.model.Question;
import com.online.exams.system.core.model.QuestionCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
    int countByCondition(QuestionCondition example);

    int deleteByCondition(QuestionCondition example);

    int deleteById(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByCondition(QuestionCondition example);

    Question selectById(Integer id);

    int updateByConditionSelective(@Param("record") Question record, @Param("example") QuestionCondition example);

    int updateByCondition(@Param("record") Question record, @Param("example") QuestionCondition example);

    int updateByIdSelective(Question record);

    int updateById(Question record);
}