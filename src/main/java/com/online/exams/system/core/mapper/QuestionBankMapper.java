package com.online.exams.system.core.mapper;

import com.online.exams.system.core.model.QuestionBank;
import com.online.exams.system.core.model.QuestionBankCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionBankMapper {
    int countByCondition(QuestionBankCondition example);

    int deleteByCondition(QuestionBankCondition example);

    int deleteById(Integer id);

    int insert(QuestionBank record);

    int insertSelective(QuestionBank record);

    List<QuestionBank> selectByCondition(QuestionBankCondition example);

    QuestionBank selectById(Integer id);

    int updateByConditionSelective(@Param("record") QuestionBank record, @Param("example") QuestionBankCondition example);

    int updateByCondition(@Param("record") QuestionBank record, @Param("example") QuestionBankCondition example);

    int updateByIdSelective(QuestionBank record);

    int updateById(QuestionBank record);
}