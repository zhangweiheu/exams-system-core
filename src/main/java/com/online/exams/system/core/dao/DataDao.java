package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by zhang on 2016/4/6.
 */
public interface DataDao {
    List<User> getAllTotalScoreOrder(int offset, int pageSize);

    LinkedHashMap<String, Integer> getUserPaperTendency(Integer uid);

    HashMap<String, Integer> getAnalysisDataByQuestionType(Integer uid);

    HashMap<String, Integer> getAnalysisDataByQuestionType();

}
