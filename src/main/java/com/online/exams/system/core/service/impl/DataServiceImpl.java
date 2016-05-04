package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.DataDao;
import com.online.exams.system.core.model.User;
import com.online.exams.system.core.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by zhang on 2016/4/6.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataDao dataDao;

    @Override
    public List<User> getAllTotalScoreOrder(int offset, int pageSize) {
        return dataDao.getAllTotalScoreOrder(offset, pageSize);
    }

    @Override
    public LinkedHashMap<String, Integer> getUserPaperTendency(Integer uid) {
        return dataDao.getUserPaperTendency(uid);
    }

    @Override
    public HashMap<String, Integer> getAnalysisDataByQuestionType(Integer uid) {
        return dataDao.getAnalysisDataByQuestionType(uid);
    }

    @Override
    public HashMap<String, Integer> getAnalysisDataByQuestionType() {
        return dataDao.getAnalysisDataByQuestionType();
    }
}
