package com.online.exams.system.core.mapper;

import com.online.exams.system.core.model.Paper;
import com.online.exams.system.core.model.PaperCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperMapper {
    int countByCondition(PaperCondition example);

    int deleteByCondition(PaperCondition example);

    int deleteById(Integer id);

    int insert(Paper record);

    int insertSelective(Paper record);

    List<Paper> selectByCondition(PaperCondition example);

    Paper selectById(Integer id);

    int updateByConditionSelective(@Param("record") Paper record, @Param("example") PaperCondition example);

    int updateByCondition(@Param("record") Paper record, @Param("example") PaperCondition example);

    int updateByIdSelective(Paper record);

    int updateById(Paper record);
}